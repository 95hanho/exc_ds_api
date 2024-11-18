package me._hanho.ds.service;

import java.util.ArrayList;
import java.util.List;

import me._hanho.ds.model.Enroll;
import me._hanho.ds.model.Schedule;
import me._hanho.ds.model.User;

public interface AdminService {

	ArrayList<Schedule> getAdminSchedules();

	void updateSchedule(Schedule schedule);

	Schedule getAdminSchedule(String schedule_code);

	void updateScheduleStatus(List<String> schedule_codes, String type);

	ArrayList<Enroll> getAdminStudents(String schedule_code);

	void updatePresent(List<String> member_no, String schedule_code, String type, String description);

	void updateStudent(int enroll_id, String member_no);

	List<User> userSearch(String type, String keyword);
}
