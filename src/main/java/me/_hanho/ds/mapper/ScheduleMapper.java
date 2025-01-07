package me._hanho.ds.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import me._hanho.ds.model.CancelLog;
import me._hanho.ds.model.Enroll;
import me._hanho.ds.model.Schedule;

@Mapper
public interface ScheduleMapper {

	ArrayList<Schedule> getSchedules(String login_id);
	
	Schedule getSchedule(@Param("schedule_code") String schedule_code, @Param("login_id") String login_id);
	
	int createEnroll(@Param("schedule_code") String schedule_code, @Param("login_id") String login_id);

	ArrayList<Enroll> getEnrolls(String login_id);

	void deleteEnroll(@Param("schedule_code") String schedule_code, @Param("login_id") String login_id);

	void createCancelLog(CancelLog cancel_log);

}
