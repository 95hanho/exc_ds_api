package me._hanho.ds.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import me._hanho.ds.model.CancelLog;
import me._hanho.ds.model.Enroll;
import me._hanho.ds.model.Schedule;
import me._hanho.ds.repository.ScheduleRepository;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleRepository scheduleDAO;
	
	@Override
	public ArrayList<Schedule> getSchedules(String login_id) {
		return scheduleDAO.getSchedules(login_id);
	}
	
	@Override
	public Schedule getSchedule(String schedule_code, String login_id) {
		return scheduleDAO.getSchedule(schedule_code, login_id);
	}

	@Override
	@Transactional
	public void createEnroll(String schedule_code, String login_id) {
		scheduleDAO.createEnroll(schedule_code, login_id);
		CancelLog cancel_log = new CancelLog("", "등록", schedule_code, login_id);
		scheduleDAO.createCancelLog(cancel_log);
	}

	@Override
	public ArrayList<Enroll> getEnrolls(String login_id) {
		return scheduleDAO.getEnrolls(login_id);
	}

	@Override
	@Transactional
	public void deleteEnroll(CancelLog cancel_log) {
		scheduleDAO.deleteEnroll(cancel_log.getSchedule_code(), cancel_log.getLogin_id());
		scheduleDAO.createCancelLog(cancel_log);
	}
	
}
