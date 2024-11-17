package me._hanho.ds.service;

import java.util.ArrayList;
import java.util.List;

import me._hanho.ds.model.Schedule;

public interface AdminService {

	ArrayList<Schedule> getAdminSchedules();

	void updateSchedule(Schedule schedule);

	Schedule getAdminSchedule(String schedule_code);

	void updateScheduleStatus(List<String> schedule_codes, String type);
}
