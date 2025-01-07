package me._hanho.ds.service;

import java.util.ArrayList;

import me._hanho.ds.model.CancelLog;
import me._hanho.ds.model.Enroll;
import me._hanho.ds.model.Schedule;

public interface ScheduleService {

	ArrayList<Schedule> getSchedules(String login_id);
	
	Schedule getSchedule(String schedule_code, String login_id);

	void createEnroll(String schedule_code, String login_id);

	ArrayList<Enroll> getEnrolls(String login_id);

	void deleteEnroll(CancelLog cancel_log);

}
