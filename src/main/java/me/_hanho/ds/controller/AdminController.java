package me._hanho.ds.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me._hanho.ds.model.CancelLog;
import me._hanho.ds.model.Enroll;
import me._hanho.ds.model.Schedule;
import me._hanho.ds.model.User;
import me._hanho.ds.service.AdminService;
import me._hanho.ds.service.ScheduleService;


@RestController
@RequestMapping("/v1/expert")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ScheduleService scheduleService;
	
	// 관리자 프로그램리스트 조회
	@GetMapping("/application/{year}/{month}")
	public ResponseEntity<Map<String, Object>> getAdminApp() {
		System.out.println("getAdminApp");
		Map<String, Object> result = new HashMap<String, Object>();
		
		ArrayList<Schedule> schedule_list = adminService.getAdminSchedules();

		result.put("data", schedule_list);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 강의 정보수정
	@PutMapping("/schedule/info")
	public ResponseEntity<Map<String, Object>> setAdminApp(@ModelAttribute Schedule schedule) {
		System.out.println("setAdminApp");
		Map<String, Object> result = new HashMap<String, Object>();
		
		adminService.updateSchedule(schedule);
		
		Schedule result_schedule = adminService.getAdminSchedule(schedule.getSchedule_code());

		result.put("data", result_schedule);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 강의 프로그램 차수 등록
	@PostMapping("/schedule/info")
	public ResponseEntity<Map<String, Object>> addProgramSchedules() {
		System.out.println("addProgramSchedules");
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 체크강의 설정(폐강, 숨김, 엑셀다운로드)
	@GetMapping("/control/user")
	public ResponseEntity<Map<String, Object>> actionCheckedPrograms(@RequestParam("type") String type,
			@RequestParam("schedule_code") List<String> schedule_codes) {
		System.out.println("actionCheckedPrograms");
		Map<String, Object> result = new HashMap<String, Object>();

		System.out.println(schedule_codes);
		System.out.println(type);
		
		// 폐강
		if(type.equals("SC") || type.equals("OPEN_STATUS")) {
			adminService.updateScheduleStatus(schedule_codes, type);
		// 숨김
		} else if(type == "EXCEL_WITH_WAIT") {
			
		} else if(type == "EXCEL") {
			
		}
		

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
//	/* 프로그램리스트->수강생리스트 */
	// 관리자 프로그램 신청인원 조회
	@GetMapping("/user/enrollment")
	public ResponseEntity<Map<String, Object>> getAdminAppStudents(@RequestParam("schedule_code") String schedule_code) {
		System.out.println("getAdminAppStudents");
		Map<String, Object> result = new HashMap<String, Object>();
		
		ArrayList<Enroll> student_list = adminService.getAdminStudents(schedule_code);

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
		System.out.println("setPresent");
		Map<String, Object> result = new HashMap<String, Object>();
		
		adminService.updatePresent(member_no, schedule_code, type, description);

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 관리자 수강신청자 변경
	@PutMapping("/user/enrollment")
	public ResponseEntity<Map<String, Object>> setEnrollStudent(@RequestParam("enroll_id") int enroll_id,
			@RequestParam("to_member_no") int member_no, @RequestAttribute("login_id") String login_id) {
		System.out.println("setEnrollStudent");
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
		System.out.println("deleteEnrollStudent");
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
		System.out.println("getStudentsSearch");
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<User> user_list = adminService.userSearch(type, keyword);

		result.put("data", user_list);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 교육생 정보 가져오기
	@GetMapping("/member/info")
	public ResponseEntity<Map<String, Object>> getStudentInfo() {
		System.out.println("getStudentInfo");
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 교육색 정보 수정하기
	@PutMapping("/member/info")
	public ResponseEntity<Map<String, Object>> setStudentInfo() {
		System.out.println("setStudentInfo");
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 교육생 과정차수 등록 해주기
	@PostMapping("/member/info")
	public ResponseEntity<Map<String, Object>> adminAppRegist() {
		System.out.println("adminAppRegist");
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
//	/*  */
	// 과정가져오기
	@GetMapping("/program/info")
	public ResponseEntity<Map<String, Object>> getProgram() {
		System.out.println("getProgram");
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 과정추가
	@PostMapping("/program/write")
	public ResponseEntity<Map<String, Object>> addProgram() {
		System.out.println("addProgram");
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 과정수정
	@PostMapping("/program/modify")
	public ResponseEntity<Map<String, Object>> setProgram() {
		System.out.println("setProgram");
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 과정 숨김
//	export const programHide = (code) => get_normal(`/program/modify/${code}`);
//	/*  */
	// 기본 설정 정보 가져오기
	@GetMapping("/other/main")
	public ResponseEntity<Map<String, Object>> getInitMonth() {
		System.out.println("getInitMonth");
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 기본 월 설정
	@PostMapping("/other/month")
	public ResponseEntity<Map<String, Object>> setInitMonth() {
		System.out.println("setInitMonth");
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 취소 사유 목록 엑셀다운로드
	@GetMapping("/other/excel/cancel")
	public ResponseEntity<Map<String, Object>> cancelListDownload() {
		System.out.println("cancelListDownload");
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 메인팝업 설정 수정
	@PostMapping("/other/popup")
	public ResponseEntity<Map<String, Object>> setMainPopup() {
		System.out.println("setMainPopup");
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 수강생 후기 작성
	@PostMapping("/other/review")
	public ResponseEntity<Map<String, Object>> addReview() {
		System.out.println("addReview");
		Map<String, Object> result = new HashMap<String, Object>();

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
