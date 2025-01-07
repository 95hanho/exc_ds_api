package me._hanho.ds.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletResponse;
import me._hanho.ds.model.CancelLog;
import me._hanho.ds.model.Enroll;
import me._hanho.ds.model.ExcelRequest;
import me._hanho.ds.model.Popup;
import me._hanho.ds.model.Program;
import me._hanho.ds.model.ProgramCategory;
import me._hanho.ds.model.Review;
import me._hanho.ds.model.Schedule;
import me._hanho.ds.model.User;
import me._hanho.ds.service.AdminService;


@RestController
@RequestMapping("/v1/expert")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	// 관리자 프로그램리스트 조회
	@GetMapping("/application/{year}/{month}")
	public ResponseEntity<Map<String, Object>> getAdminApp() {
		logger.info("getAdminApp");
		Map<String, Object> result = new HashMap<String, Object>();
		
		ArrayList<Schedule> schedule_list = adminService.getAdminSchedules();

		result.put("data", schedule_list);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 강의 정보수정
	@PutMapping("/schedule/info")
	public ResponseEntity<Map<String, Object>> setAdminApp(@ModelAttribute Schedule schedule) {
		logger.info("setAdminApp");
		Map<String, Object> result = new HashMap<String, Object>();
		
		adminService.updateSchedule(schedule);
		
		Schedule result_schedule = adminService.getAdminSchedule(schedule.getSchedule_code());

		result.put("data", result_schedule);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 강의 프로그램 차수 등록
	@PostMapping("/schedule/info")
	public ResponseEntity<Map<String, Object>> addProgramSchedules(@RequestBody ExcelRequest excelData) {
		logger.info("addProgramSchedules");
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<Schedule> param_schedule_list = new ArrayList<>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Schedule latest_schedule = adminService.getScheduleLatest();
		int last_index = Integer.parseInt(latest_schedule.getSchedule_code());
		try {
			for(int i = 0; i < excelData.getList().size(); i++) {
				List<String> excel = excelData.getList().get(i);
				Schedule schedule = new Schedule();
				schedule.setSchedule_code("" + ++last_index);
				schedule.setSchedule_number(Integer.parseInt(excel.get(0)));
				schedule.setSchedule_start_date(formatter.parse(excel.get(1)));
				schedule.setSchedule_enrol_start_date(formatter.parse(excel.get(2)));
				schedule.setSchedule_enrol_end_date(formatter.parse(excel.get(3)));
				schedule.setEnrol_limit(Integer.parseInt(excel.get(4)));
				schedule.setPart_type(excel.get(5));
				schedule.setProgram_code(excel.get(6));
				schedule.setOnline(excel.get(7).charAt(0));
				param_schedule_list.add(schedule);
			}
		} catch(ParseException e) {
			result.put("msg", "fail");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
		adminService.setSchedules(param_schedule_list);

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 체크강의 설정(폐강, 숨김, 엑셀다운로드)
	@GetMapping("/control/user")
	public Object actionCheckedPrograms(@RequestParam("type") String type,
			@RequestParam("schedule_code") List<String> schedule_codes, 
			HttpServletResponse response) throws IOException {
		logger.info("actionCheckedPrograms");
		Map<String, Object> result = new HashMap<String, Object>();

		List<User> student_list = null;
		
		// 폐강
		if(type.equals("SC") || type.equals("OPEN_STATUS")) {
			adminService.updateScheduleStatus(schedule_codes, type);
		// 대기자포함 엑셀
		} else if(type.equals("EXCEL_WITH_WAIT")) {
			student_list = adminService.getStudents(schedule_codes, true);
		}
		// 대기자제외 엑셀 
		else if(type.equals("EXCEL")) {
			student_list = adminService.getStudents(schedule_codes, false);
		}
		
		if(type.equals("EXCEL_WITH_WAIT") || type.equals("EXCEL")) {
			// 2. 엑셀 파일 생성
	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("취소 사유 목록");

	        // 3. 헤더 작성
	        Row headerRow = sheet.createRow(0);
	        String[] headers = {"사번", "이름", "유형", "아이디", "연락처", "이메일", "차수", "일자", "선택프로그램", "부서", "신청일", 
	        		"출결", "출결 특이사항"};
	        for (int i = 0; i < headers.length; i++) {
	            Cell cell = headerRow.createCell(i);
	            cell.setCellValue(headers[i]);
	        }

	        // 4. 데이터 작성
	        int rowIndex = 1; // 헤더 다음 행부터 작성
	        for (User student : student_list) {
	            Row row = sheet.createRow(rowIndex++);
	            row.createCell(0).setCellValue(student.getMember_no());
	            row.createCell(1).setCellValue(student.getName());
	            row.createCell(2).setCellValue(student.getMember_type());
	            row.createCell(3).setCellValue(student.getMember_hp());
	            row.createCell(4).setCellValue(student.getMember_email());
	            row.createCell(5).setCellValue(student.getSchedule_number());
	            row.createCell(6).setCellValue(student.getSchedule_start_date());
	            row.createCell(7).setCellValue(student.getProgram_name());
	            row.createCell(8).setCellValue(student.getTeam_name());
	            row.createCell(9).setCellValue(student.getCreated_at());
	            row.createCell(10).setCellValue(student.getAttendance_msg());
	            row.createCell(11).setCellValue(student.getAttendance_description());
	        }

	        // 5. HTTP 응답에 엑셀 파일 첨부
	        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	        response.setHeader("Content-Disposition", "attachment; filename=cancel_list.xlsx");

	        workbook.write(response.getOutputStream());
	        workbook.close();
		}

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
//	/* 프로그램리스트->수강생리스트 */
	// 관리자 프로그램 신청인원 조회
	@GetMapping("/user/enrollment")
	public ResponseEntity<Map<String, Object>> getAdminAppStudents(@RequestParam("schedule_code") String schedule_code) {
		logger.info("getAdminAppStudents");
		Map<String, Object> result = new HashMap<String, Object>();
		
		ArrayList<Enroll> student_list = adminService.getAdminStudents(schedule_code);
		
		System.out.println(student_list);

		result.put("enrol_final_status", true);
		result.put("schedule_info", student_list);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 출결변경
	@PostMapping("/attendance/info")
	public ResponseEntity<Map<String, Object>> setPresent(@RequestParam("member_no") List<String> member_no,
			@RequestParam("schedule_code") String schedule_code, @RequestParam("type") String type,
			@RequestParam(value = "description", defaultValue = "") String description) {
		logger.info("setPresent");
		Map<String, Object> result = new HashMap<String, Object>();
		
		adminService.updatePresent(member_no, schedule_code, type, description);

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 관리자 수강신청자 변경
	@PutMapping("/user/enrollment")
	public ResponseEntity<Map<String, Object>> setEnrollStudent(@RequestParam("enroll_id") int enroll_id,
			@RequestParam("to_member_no") int member_no, @RequestAttribute("login_id") String login_id) {
		logger.info("setEnrollStudent");
		Map<String, Object> result = new HashMap<String, Object>();
		
		adminService.deleteStudent(enroll_id, member_no, login_id);
		adminService.updateStudent(enroll_id, member_no, login_id);
		Schedule schedule = adminService.getAdminSchedule(enroll_id);

		result.put("data", schedule);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 신청명단 삭제
	@DeleteMapping("/user/enrollment")
	public ResponseEntity<Map<String, Object>> deleteEnrollStudent(@ModelAttribute CancelLog cancel_log,
			@RequestAttribute("login_id") String login_id) {
		logger.info("deleteEnrollStudent");
		Map<String, Object> result = new HashMap<String, Object>();
		cancel_log.setExecutor(login_id);

		try {
			adminService.deleteStudent(cancel_log);
			result.put("msg", "success");
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			result.put("msg", "fail");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
//	/*  */
	// 유저 검색
	@GetMapping("/member/search")
	public ResponseEntity<Map<String, Object>> getStudentsSearch(@RequestParam("type") String type,
			@RequestParam("keyword") String keyword) {
		logger.info("getStudentsSearch");
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<User> user_list = adminService.userSearch(type, keyword);

		result.put("data", user_list);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 교육생 정보 가져오기
	@GetMapping("/member/info")
	public ResponseEntity<Map<String, Object>> getStudentInfo(@RequestParam("member_no") int member_no,
			@RequestParam("month") String month) {
		logger.info("getStudentInfo");
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<CancelLog> log_list = adminService.getLogs(member_no);
		List<Enroll> enroll_list = adminService.getEnrolls(member_no);
		
		Map<String, Object> data_result = new HashMap<String, Object>();
		data_result.put("application_list", false);
		data_result.put("change_log", log_list);
		Map<String, Object> enrol_list = new HashMap<String, Object>();
		enrol_list.put("new_list", enroll_list);
		enrol_list.put("old_list", new ArrayList<>());
		data_result.put("enrol_list", enrol_list);
		result.put("data", data_result);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 교육색 정보 수정하기
	@PutMapping("/member/info")
	public ResponseEntity<Map<String, Object>> setStudentInfo(@ModelAttribute User user) {
		logger.info("setStudentInfo");
		Map<String, Object> result = new HashMap<String, Object>();
		
		adminService.updateUser(user);

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
//	/*  */
	// 과정가져오기
	@GetMapping("/program/info")
	public ResponseEntity<Map<String, Object>> getProgram() {
		logger.info("getProgram");
		Map<String, Object> result = new HashMap<String, Object>();
		
		ArrayList<ProgramCategory> catelist = adminService.getProgramCategory();

		result.put("data", catelist);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 과정추가
	@PostMapping("/program/write")
	public ResponseEntity<Map<String, Object>> addProgram(@ModelAttribute Program program, 
			@RequestParam(value="file", required=false) MultipartFile file) {
		logger.info("addProgram");
		Map<String, Object> result = new HashMap<String, Object>();
		
		Program latest_program = adminService.getProgramLatest();
		
		// 문자열의 숫자 부분 추출
        String prefix = latest_program.getProgram_code().replaceAll("\\d", ""); // "S"
        String numericPart = latest_program.getProgram_code().replaceAll("\\D", ""); // "20"
        // 숫자를 증가시키고 다시 결합
        int incrementedValue = Integer.parseInt(numericPart) + 1; // 숫자 변환 후 +1
        program.setProgram_code(prefix + incrementedValue);
        
        // "4H (8:30~12:30 / 13:30~17:30)" time이랑 ment로 구분
        String[] parts = ((String) program.getTime()).split(" ", 2);
        int time = Integer.parseInt(parts[0].replaceAll("\\D", ""));
        String time_ment = parts[1];
        program.setTime(time);
        program.setTime_ment(time_ment);
		
		adminService.createProgram(program, file);

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 과정수정
	@PostMapping("/program/modify")
	public ResponseEntity<Map<String, Object>> setProgram(@ModelAttribute Program program, 
			@RequestParam(value="file", required=false) MultipartFile file) {
		logger.info("setProgram");
		Map<String, Object> result = new HashMap<String, Object>();
		
		// "4H (8:30~12:30 / 13:30~17:30)" time이랑 ment로 구분
        String[] parts = ((String) program.getTime()).split(" ", 2);
        int time = Integer.parseInt(parts[0].replaceAll("\\D", ""));
        String time_ment = parts[1];
        program.setTime(time);
        program.setTime_ment(time_ment);
        
        adminService.updateProgram(program, file);

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 과정 숨김
	@GetMapping("/program/modify/{code}")
	public ResponseEntity<Map<String, Object>> programHide(@PathVariable("code") String program_code) {
		logger.info("programHide");
		Map<String, Object> result = new HashMap<String, Object>();
		
		adminService.updateProgram_status(program_code);

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
//	/*  */
	// 기본 설정 정보 가져오기
	@GetMapping("/other/main")
	public ResponseEntity<Map<String, Object>> getInitMonth() {
		logger.info("getInitMonth");
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> data_result = new HashMap<String, Object>();
		
		List<Popup> popup_info = adminService.getPopups();
		
		data_result.put("pop_info", popup_info);
		result.put("data", data_result);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 기본 월 설정
	/*
	@PostMapping("/other/month")
	public ResponseEntity<Map<String, Object>> setInitMonth() {
		System.out.println("setInitMonth");
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	*/
	// 취소 사유 목록 엑셀다운로드
	@GetMapping("/other/excel/cancel")
	public void cancelListDownload(HttpServletResponse response) throws IOException {
		logger.info("cancelListDownload");
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<CancelLog> cancel_list = adminService.getCancels();
		
		// 2. 엑셀 파일 생성
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("취소 사유 목록");

        // 3. 헤더 작성
        Row headerRow = sheet.createRow(0);
        String[] headers = {"취소번호", "사유", "날짜", "타입", "유저이름", "변경인"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // 4. 데이터 작성
        int rowIndex = 1; // 헤더 다음 행부터 작성
        for (CancelLog cancelLog : cancel_list) {
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(cancelLog.getId());
            row.createCell(1).setCellValue(cancelLog.getReason());
            row.createCell(2).setCellValue(cancelLog.getCreated_at().toString()); // Date -> String 변환
            row.createCell(3).setCellValue(cancelLog.getFlag());
            row.createCell(4).setCellValue(cancelLog.getLogin_id());
            row.createCell(5).setCellValue(cancelLog.getExecutor());
        }

        // 5. HTTP 응답에 엑셀 파일 첨부
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=cancel_list.xlsx");

        workbook.write(response.getOutputStream());
        workbook.close();
	}
	// 메인팝업 설정 수정
	@PostMapping("/other/popup")
	public ResponseEntity<Map<String, Object>> setMainPopup(@RequestParam(value="file1", required=false) MultipartFile file1,
			@RequestParam(value="file2", required=false) MultipartFile file2, @RequestParam("file1_status") Boolean file1_status,
			@RequestParam("file2_status") Boolean file2_status) {
		logger.info("setMainPopup");
		Map<String, Object> result = new HashMap<String, Object>();
		
		adminService.updatePopup(file1, file1_status, 1);
		adminService.updatePopup(file2, file2_status, 2);

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 수강생 후기 작성
	@PostMapping("/other/review")
	public ResponseEntity<Map<String, Object>> addReview(@ModelAttribute Review review) {
		logger.info("addReview");
		Map<String, Object> result = new HashMap<String, Object>();
		
		adminService.createReview(review);

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
