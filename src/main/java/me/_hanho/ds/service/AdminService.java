package me._hanho.ds.service;

import java.util.ArrayList;
import java.util.List;

import me._hanho.ds.model.CancelLog;
import me._hanho.ds.model.Enroll;
import me._hanho.ds.model.Schedule;
import me._hanho.ds.model.User;

public interface AdminService {

	ArrayList<Schedule> getAdminSchedules();
	Schedule getAdminSchedule(String schedule_code);
	Schedule getAdminSchedule(int enroll_id);

	void updateSchedule(Schedule schedule);

	void updateScheduleStatus(List<String> schedule_codes, String type);

	ArrayList<Enroll> getAdminStudents(String schedule_code);
	
	void deleteStudent(int enroll_id, int member_no, String login_id);

	void deleteStudent(CancelLog cancel_log);
	
	void updateStudent(int enroll_id, int member_no, String login_id);

	void updatePresent(List<String> member_no, String schedule_code, String type, String description);

	/* */
	
	List<User> userSearch(String type, String keyword);
	
	List<CancelLog> getLogs(int member_no);
	
	List<Enroll> getEnrolls(int member_no);
	
	void updateUser(User user);
	
}
