package me._hanho.ds.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import me._hanho.ds.model.CancelLog;
import me._hanho.ds.model.Enroll;
import me._hanho.ds.model.Popup;
import me._hanho.ds.model.Program;
import me._hanho.ds.model.ProgramCategory;
import me._hanho.ds.model.Review;
import me._hanho.ds.model.Schedule;
import me._hanho.ds.model.User;

public interface AdminService {

	ArrayList<Schedule> getAdminSchedules();
	Schedule getAdminSchedule(String schedule_code);
	Schedule getAdminSchedule(int enroll_id);
	
	Schedule getScheduleLatest();
	
	void setSchedules(List<Schedule> param_schedule_list);

	void updateSchedule(Schedule schedule);

	void updateScheduleStatus(List<String> schedule_codes, String type);

	ArrayList<Enroll> getAdminStudents(String schedule_code);
	
	List<User> getStudents(List<String> schedule_codes, boolean b);
	
	void deleteStudent(int enroll_id, int member_no, String login_id);

	void deleteStudent(CancelLog cancel_log);
	
	void updateStudent(int enroll_id, int member_no, String login_id);

	void updatePresent(List<String> member_no, String schedule_code, String type, String description);

	/* */
	
	List<User> userSearch(String type, String keyword);
	
	List<CancelLog> getLogs(int member_no);
	
	List<Enroll> getEnrolls(int member_no);
	
	void updateUser(User user);
	
	/* */
	
	ArrayList<ProgramCategory> getProgramCategory();
	
	Program getProgramLatest();
	
	void createProgram(Program program, MultipartFile file);
	
	void updateProgram(Program program, MultipartFile file);
	
	void updateProgram_status(String program_code);
	
	/* */
	List<CancelLog> getCancels();
	
	List<Popup> getPopups();
	
	void updatePopup(MultipartFile file2, Boolean file2_status, int i);
	
	void createReview(Review review);
	
	
	
	
	

	
}
