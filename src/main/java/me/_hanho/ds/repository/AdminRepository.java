package me._hanho.ds.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me._hanho.ds.mapper.AdminMapper;
import me._hanho.ds.model.Schedule;
import me._hanho.ds.util.JsonUtils;

@Repository
public class AdminRepository {
	
	@Autowired
	private AdminMapper adminMapper;

	public ArrayList<Schedule> getAdminSchedules() {
		ArrayList<Schedule> s_list = adminMapper.getAdminSchedules();
		s_list.stream().forEach(schedule -> {
			String json = schedule.getSchedule_after_date_JSON();
			if(json != null) {
				schedule.setSchedule_after_date(JsonUtils.parseScheduleAfterDate(schedule.getSchedule_after_date_JSON()));
			}
		});
		return s_list;
	}

	public void updateSchedule(Schedule schedule) {
		adminMapper.updateSchedule(schedule);
	}
	
	public void updateProgram(Schedule schedule) {
		adminMapper.updateProgram(schedule);
	}


	public Schedule getAdminSchedule(String schedule_code) {
		return adminMapper.getAdminSchedule(schedule_code);
	}

	public void updateScheduleStatus(List<String> schedule_codes, String type) {
		if(type.equals("SC")) {
			adminMapper.updateScheduleStatus(schedule_codes);
		} else if(type.equals("OPEN_STATUS")) {
			adminMapper.updateScheduleOpenStatus(schedule_codes);
		}
	}


}
