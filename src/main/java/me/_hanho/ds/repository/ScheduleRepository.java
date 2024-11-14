package me._hanho.ds.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me._hanho.ds.mapper.ScheduleMapper;
import me._hanho.ds.model.Schedule;

@Repository
public class ScheduleRepository {
	
	@Autowired
	private ScheduleMapper scheduleMapper;

	public ArrayList<Schedule> getSchedules() {
		return scheduleMapper.getSchedules();
	}

	
}
