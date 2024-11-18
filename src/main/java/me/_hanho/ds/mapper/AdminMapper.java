package me._hanho.ds.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import me._hanho.ds.model.Enroll;
import me._hanho.ds.model.Schedule;
import me._hanho.ds.model.User;

@Mapper
public interface AdminMapper {

	ArrayList<Schedule> getAdminSchedules();

	void updateSchedule(Schedule schedule);
	void updateProgram(Schedule schedule);

	Schedule getAdminSchedule(String schedule_code);

	int updateScheduleStatus(@Param("schedule_codes") List<String> schedule_codes);

	int updateScheduleOpenStatus(@Param("schedule_codes") List<String> schedule_codes);

	ArrayList<Enroll> getAdminStudents(String schedule_code);

	int updatePresent(@Param("member_nos") List<String> member_nos, @Param("schedule_code") String schedule_code,
			@Param("type") String type, @Param("description") String description, @Param("msg") String msg);

	void updateStudent(@Param("enroll_id") int enroll_id, @Param("member_no") String member_no);

	List<User> userSearch(@Param("type") String type, @Param("keyword") String keyword);
	
}
