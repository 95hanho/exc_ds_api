package me._hanho.ds.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import me._hanho.ds.model.Schedule;

@Mapper
public interface AdminMapper {

	ArrayList<Schedule> getAdminSchedules();

	void updateSchedule(Schedule schedule);
	void updateProgram(Schedule schedule);

	Schedule getAdminSchedule(String schedule_code);

	int updateScheduleStatus(@Param("schedule_codes") List<String> schedule_codes);

	int updateScheduleOpenStatus(@Param("schedule_codes") List<String> schedule_codes);
	
}
