package me._hanho.ds.repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import me._hanho.ds.mapper.ScheduleMapper;
import me._hanho.ds.model.Enroll;
import me._hanho.ds.model.Schedule;

@Repository
public class ScheduleRepository {
	
	@Autowired
	private ScheduleMapper scheduleMapper;

	public ArrayList<Schedule> getSchedules(String login_id) {
		ArrayList<Schedule> s_list = scheduleMapper.getSchedules(login_id);
		s_list.stream().forEach(schedule -> {
			String json = schedule.getSchedule_after_date_JSON();
			if(json != null) {
				schedule.setSchedule_after_date(parseScheduleAfterDate(schedule.getSchedule_after_date_JSON()));
			}
		});
		return s_list;
	}
	
	public Schedule getSchedule(String schedule_code, String login_id) {
		return scheduleMapper.getSchedule(schedule_code, login_id);
	}
	
	public static List<Date> parseScheduleAfterDate(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        objectMapper.setDateFormat(dateFormat);

        // JSON 문자열을 List<Date>로 변환
        List<Date> dateList;
		try {
			dateList = objectMapper.readValue(json, new TypeReference<List<Date>>() {});
		} catch (JsonMappingException e) {
			return null;
		} catch (JsonProcessingException e) {
			return null;
		}
        return dateList;
    }

	public int createEnroll(String schedule_code, String login_id) {
		System.out.println(schedule_code);
		int up_result = scheduleMapper.upEnrol_count(schedule_code);
		System.out.println(up_result);
		if(up_result > 0) {
			Schedule schedule = scheduleMapper.getSchedule(schedule_code, login_id);
			int rank = 0;
			if(schedule.getEnrol_count() > schedule.getEnrol_limit()) {
				rank = schedule.getEnrol_count() - schedule.getEnrol_limit();
			}
			return scheduleMapper.createEnroll(schedule_code, login_id, rank);
		} else {
			return 0;
		}
		
	}

	public ArrayList<Enroll> getEnrolls(String login_id) {
		return scheduleMapper.getEnrolls(login_id);
	}
	
}
