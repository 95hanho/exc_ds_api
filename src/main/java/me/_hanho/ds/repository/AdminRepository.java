package me._hanho.ds.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import me._hanho.ds.mapper.AdminMapper;
import me._hanho.ds.mapper.FileMapper;
import me._hanho.ds.model.CancelLog;
import me._hanho.ds.model.Enroll;
import me._hanho.ds.model.Popup;
import me._hanho.ds.model.Program;
import me._hanho.ds.model.ProgramCategory;
import me._hanho.ds.model.Review;
import me._hanho.ds.model.Schedule;
import me._hanho.ds.model.User;
import me._hanho.ds.util.JsonUtils;

@Repository
public class AdminRepository {
	
	@Autowired
	private AdminMapper adminMapper;
	
	@Autowired
	private FileMapper fileMapper;
	
	@Value("${spring.servlet.multipart.location}")
    private String uploadDir;

	public ArrayList<Schedule> getAdminSchedules() {
		ArrayList<Schedule> s_list = adminMapper.getAdminSchedules();
		s_list.stream().forEach(schedule -> {
			String json = schedule.getSchedule_after_date_JSON();
			if(json != null) {
				schedule.setSchedule_after_date(JsonUtils.parseScheduleAfterDate(schedule.getSchedule_after_date_JSON()));
			}
		});
		return s_list;
	}
	
	public Schedule getAdminSchedule(String schedule_code) {
		return adminMapper.getAdminSchedule(schedule_code);
	}
	
	public Schedule getAdminSchedule(int enroll_id) {
		return adminMapper.getAdminSchedule2(enroll_id);
	}

	public void setSchedules(List<Schedule> param_schedule_list) {
		param_schedule_list.stream().forEach(schedule -> {
			adminMapper.setSchedule(schedule);
		});
	}

	public void updateSchedule(Schedule schedule) {
		adminMapper.updateSchedule(schedule);
	}
	
	public void updateProgramTime(Schedule schedule) {
		adminMapper.updateProgramTime(schedule);
	}

	public void updateScheduleStatus(List<String> schedule_codes, String type) {
		if(type.equals("SC")) {
			adminMapper.updateScheduleStatus(schedule_codes);
		} else if(type.equals("OPEN_STATUS")) {
			adminMapper.updateScheduleOpenStatus(schedule_codes);
		}
	}

	public ArrayList<Enroll> getAdminStudents(String schedule_code) {
		int confirmed_index = 1;
		int wait_index = 1;
		ArrayList<Enroll> student_list = adminMapper.getAdminStudents(schedule_code);
		for(Enroll student : student_list) {
			if(!student.getEnrol_waiting_status()) {
				student.setEnrol_rank(confirmed_index);
				confirmed_index++;
			} else {
				student.setEnrol_rank(wait_index);
				wait_index++;
			}
			
		}
		return student_list;
	}
	
	public List<User> getStudents(List<String> schedule_codes, boolean b) {
		if(b) {
			return adminMapper.getStudents(schedule_codes);
		} else {
			return adminMapper.getStudentsWithoutWait(schedule_codes);
		}
		
	}

	public void updatePresent(List<String> member_no, String schedule_code, String type, String description) {
		String msg = "";
		if(type.equals("Y")) {
			msg = "수료";
		} else if(type.equals("N")) {
			msg = "미수료";
		} else if(type.equals("T")) {
			msg = "지각";
		}
		adminMapper.updatePresent(member_no, schedule_code, type, description, msg);
	}
	
	public void deleteStudent(int enroll_id, int member_no) {
		adminMapper.deleteStudent(enroll_id, member_no);
	}
	
	public void deleteStudent(String schedule_code, int member_no) {
		adminMapper.deleteStudent2(schedule_code, member_no);
	}
	
	public void createCancelLog(CancelLog cancel_log) {
		adminMapper.createCancelLog(cancel_log);
	}
	
	public void createCancelLog(int enroll_id, int member_no, String login_id, String flag) {
		if(flag.equals("취소")) {
			int original_memNo = adminMapper.getMember_no(enroll_id);
			adminMapper.createCancelLog2(enroll_id, original_memNo, login_id, flag);
		} else {
			adminMapper.createCancelLog2(enroll_id, member_no, login_id, flag);	
		}
		
	}
	
	
	public void updateStudent(int enroll_id, int member_no) {
		adminMapper.updateStudent(enroll_id, member_no);
	}
	
	/* */
	
	public List<User> userSearch(String type, String keyword) {
		if(type.equals("hp")) {
			type = "member_hp";
		} else if(type.equals("insa_number")) {
			type = "member_insa_number";
		}
		return adminMapper.userSearch(type, keyword);
	}

	public List<CancelLog> getLogs(int member_no) {
		return adminMapper.getLogs(member_no);
	}

	public List<Enroll> getEnrolls(int member_no) {
		return adminMapper.getEnrolls(member_no);
	}

	public void updateUser(User user) {
		adminMapper.updateUser(user);
	}
	
	/* */

	public ArrayList<ProgramCategory> getProgramCategory() {
		ArrayList<ProgramCategory> result =  new ArrayList<>();
		ArrayList<ProgramCategory> pc_list =  adminMapper.getProgramCategory();
		pc_list.stream().forEach(pc -> {
			ArrayList<Program> p_list = adminMapper.getPrograms2(pc.getCate_num());
			if(p_list.size() > 0) {
				pc.setList(p_list);
				result.add(pc);
			}
		});
		
		return result;
	}

	public Program getProgramLatest() {
		return adminMapper.getProgramLatest();
	}

	public Program createProgram(Program program) {
		adminMapper.createProgram(program);
		return adminMapper.getProgramLatest();
	}

	public void updateProgram(Program program) {
		adminMapper.updateProgram(program);
	}

	public void updateProgram_status(String program_code) {
		adminMapper.updateProgram_status(program_code);
	}
	
	/* */
	public List<CancelLog> getCancels() {
		return adminMapper.getCancels();
	}

	
	public void updatePopup(Boolean file_status, int type) {
		adminMapper.updatePopup(file_status, type);
	}

	public void createReview(Review review) {
		adminMapper.createReview(review);
	}

	public List<Popup> getPopups() {
		return adminMapper.getPopups();
	}

	public Schedule getScheduleLatest() {
		return adminMapper.getScheduleLatest();
	}







}
