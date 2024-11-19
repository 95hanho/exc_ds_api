package me._hanho.ds.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import me._hanho.ds.model.CancelLog;
import me._hanho.ds.model.Enroll;
import me._hanho.ds.model.Schedule;
import me._hanho.ds.model.User;
import me._hanho.ds.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminDAO;

	@Override
	public ArrayList<Schedule> getAdminSchedules() {
		return adminDAO.getAdminSchedules();
	}
	
	@Override
	public Schedule getAdminSchedule(String schedule_code) {
		return adminDAO.getAdminSchedule(schedule_code);
	}
	
	@Override
	public Schedule getAdminSchedule(int enroll_id) {
		return adminDAO.getAdminSchedule(enroll_id);
	}

	@Override
	@Transactional
	public void updateSchedule(Schedule schedule) {
		adminDAO.updateSchedule(schedule);
		adminDAO.updateProgram(schedule);
	}


	@Override
	public void updateScheduleStatus(List<String> schedule_codes, String type) {
		adminDAO.updateScheduleStatus(schedule_codes, type);
	}

	@Override
	public ArrayList<Enroll> getAdminStudents(String schedule_code) {
		return adminDAO.getAdminStudents(schedule_code);
	}

	@Override
	public void updatePresent(List<String> member_no, String schedule_code, String type, String description) {
		adminDAO.updatePresent(member_no, schedule_code, type, description);
	}
	
	@Override
	@Transactional
	public void deleteStudent(int enroll_id, int member_no, String login_id) {
		adminDAO.createCancelLog(enroll_id, member_no, login_id, "취소");
		adminDAO.deleteStudent(enroll_id, member_no);
	}
	
	@Override
	@Transactional
	public void deleteStudent(CancelLog cancel_log) {
		adminDAO.deleteStudent(cancel_log.getSchedule_code(), cancel_log.getMember_no());
		adminDAO.createCancelLog(cancel_log); 
	}

	@Override
	public void updateStudent(int enroll_id, int member_no, String login_id) {
		adminDAO.updateStudent(enroll_id, member_no);
		adminDAO.createCancelLog(enroll_id, member_no, login_id, "변경");
	}
	
	/* */

	@Override
	public List<User> userSearch(String type, String keyword) {
		return adminDAO.userSearch(type, keyword);
	}

	@Override
	public List<CancelLog> getLogs(int member_no) {
		return adminDAO.getLogs(member_no);
	}

	@Override
	public List<Enroll> getEnrolls(int member_no) {
		return adminDAO.getEnrolls(member_no);
	}

	@Override
	public void updateUser(User user) {
		adminDAO.updateUser(user);
	}






}
