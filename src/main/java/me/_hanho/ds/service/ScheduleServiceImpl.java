package me._hanho.ds.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me._hanho.ds.model.Schedule;
import me._hanho.ds.repository.ScheduleRepository;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleRepository ScheduleDAO;
	
	@Override
	public ArrayList<Schedule> getSchedules() {
		return ScheduleDAO.getSchedules();
	}
	
	
}
