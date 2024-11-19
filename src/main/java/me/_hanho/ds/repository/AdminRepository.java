package me._hanho.ds.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me._hanho.ds.mapper.AdminMapper;
import me._hanho.ds.model.CancelLog;
import me._hanho.ds.model.Enroll;
import me._hanho.ds.model.Schedule;
import me._hanho.ds.model.User;
import me._hanho.ds.util.JsonUtils;

@Repository
public class AdminRepository {
	
	@Autowired
	private AdminMapper adminMapper;

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

	public void updateSchedule(Schedule schedule) {
		adminMapper.updateSchedule(schedule);
	}
	
	public void updateProgram(Schedule schedule) {
		adminMapper.updateProgram(schedule);
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
	
	public List<User> userSearch(String type, String keyword) {
		if(type.equals("hp")) {
			type = "member_hp";
		} else if(type.equals("insa_number")) {
			type = "member_insa_number";
		}
		return adminMapper.userSearch(type, keyword);
	}












}
