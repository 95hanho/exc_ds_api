package me._hanho.ds.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;
import me._hanho.ds.model.CancelLog;
import me._hanho.ds.model.Enroll;
import me._hanho.ds.model.Popup;
import me._hanho.ds.model.Program;
import me._hanho.ds.model.ProgramCategory;
import me._hanho.ds.model.Review;
import me._hanho.ds.model.Schedule;
import me._hanho.ds.model.User;
import me._hanho.ds.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminDAO;
	
	@Autowired
	private FileService fileService;

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
	public Schedule getScheduleLatest() {
		return adminDAO.getScheduleLatest();
	}

	
	@Override
	public void setSchedules(List<Schedule> param_schedule_list) {
		adminDAO.setSchedules(param_schedule_list);
	}

	@Override
	@Transactional
	public void updateSchedule(Schedule schedule) {
		adminDAO.updateSchedule(schedule);
		adminDAO.updateProgramTime(schedule);
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
	public List<User> getStudents(List<String> schedule_codes, boolean b) {
		return adminDAO.getStudents(schedule_codes, b);
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
	
	/* */

	@Override
	public ArrayList<ProgramCategory> getProgramCategory() {
		return adminDAO.getProgramCategory();
	}
	
	@Override
	public Program getProgramLatest() {
		return adminDAO.getProgramLatest();
	}

	@Override
	@Transactional
	public void createProgram(Program program, MultipartFile file) {
		Program latest_program = adminDAO.createProgram(program);
		fileService.createProgramFile(latest_program.getProgram_num(), file);
	}

	@Override
	@Transactional
	public void updateProgram(Program program, MultipartFile file) {
		adminDAO.updateProgram(program);
		if(file != null) {
			fileService.createProgramFile(program.getProgram_num(), file);
		}
	}

	@Override
	public void updateProgram_status(String program_code) {
		adminDAO.updateProgram_status(program_code);
	}
	
	/* */
	@Override
	public List<CancelLog> getCancels() {
		return adminDAO.getCancels();
	}
	
	@Override
	public List<Popup> getPopups() {
		return adminDAO.getPopups();
	}

	
	@Override
	@Transactional
	public void updatePopup(MultipartFile file, Boolean file_status, int type) {
		adminDAO.updatePopup(file_status, type);
		if(file != null) {
			fileService.createPopupFile(file, type);
		}
	}

	@Override
	public void createReview(Review review) {
		adminDAO.createReview(review);
	}


}
