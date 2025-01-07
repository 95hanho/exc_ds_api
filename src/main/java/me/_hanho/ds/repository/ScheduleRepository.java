package me._hanho.ds.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me._hanho.ds.mapper.ScheduleMapper;
import me._hanho.ds.model.CancelLog;
import me._hanho.ds.model.Enroll;
import me._hanho.ds.model.Schedule;
import me._hanho.ds.util.JsonUtils;

@Repository
public class ScheduleRepository {
	
	@Autowired
	private ScheduleMapper scheduleMapper;

	public ArrayList<Schedule> getSchedules(String login_id) {
		ArrayList<Schedule> s_list = scheduleMapper.getSchedules(login_id);
		System.out.println(s_list);
		s_list.stream().forEach(schedule -> {
			String json = schedule.getSchedule_after_date_JSON();
			if(json != null) {
				schedule.setSchedule_after_date(JsonUtils.parseScheduleAfterDate(schedule.getSchedule_after_date_JSON()));
			}
		});
		return s_list;
	}
	
	public Schedule getSchedule(String schedule_code, String login_id) {
		return scheduleMapper.getSchedule(schedule_code, login_id);
	}
	

	public int createEnroll(String schedule_code, String login_id) {
		return scheduleMapper.createEnroll(schedule_code, login_id);
	}

	public ArrayList<Enroll> getEnrolls(String login_id) {
		return scheduleMapper.getEnrolls(login_id);
	}

	public void deleteEnroll(String schedule_code, String login_id) {
		scheduleMapper.deleteEnroll(schedule_code, login_id);
	}
	
	public void createCancelLog(CancelLog cancel_log) {
		scheduleMapper.createCancelLog(cancel_log);
	}
	
	


}


