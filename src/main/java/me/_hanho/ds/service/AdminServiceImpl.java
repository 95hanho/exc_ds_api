package me._hanho.ds.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import me._hanho.ds.model.Schedule;
import me._hanho.ds.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminDAO;

	@Override
	public ArrayList<Schedule> getAdminSchedules() {
		return adminDAO.getAdminSchedules();
	}

	@Override
	@Transactional
	public void updateSchedule(Schedule schedule) {
		adminDAO.updateSchedule(schedule);
		adminDAO.updateProgram(schedule);
	}

	@Override
	public Schedule getAdminSchedule(String schedule_code) {
		return adminDAO.getAdminSchedule(schedule_code);
	}

	@Override
	public void updateScheduleStatus(List<String> schedule_codes, String type) {
		adminDAO.updateScheduleStatus(schedule_codes, type);
	}


}
