package me._hanho.ds.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me._hanho.ds.model.Enroll;
import me._hanho.ds.model.Schedule;
import me._hanho.ds.repository.ScheduleRepository;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleRepository ScheduleDAO;
	
	@Override
	public ArrayList<Schedule> getSchedules(String login_id) {
		return ScheduleDAO.getSchedules(login_id);
	}
	
	@Override
	public Schedule getSchedule(String schedule_code, String login_id) {
		return ScheduleDAO.getSchedule(schedule_code, login_id);
	}

	@Override
	public int createEnroll(String schedule_code, String login_id) {
		return ScheduleDAO.createEnroll(schedule_code, login_id);
	}

	@Override
	public ArrayList<Enroll> getEnrolls(String login_id) {
		return ScheduleDAO.getEnrolls(login_id);
	}



	
	
}
