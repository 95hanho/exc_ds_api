package me._hanho.ds.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me._hanho.ds.model.Schedule;
import me._hanho.ds.service.ScheduleService;

@RestController
@RequestMapping("/v1/application")
public class ApplicationController {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);
	
	@Autowired
	private ScheduleService scheduleService;

	// 프로그램조회
	@GetMapping("/{month}")
	public ResponseEntity<Map<String, Object>> getSchedules(@PathVariable("month") String month,
			@RequestAttribute("login_id") String login_id) {
		logger.info("getSchedules");
		Map<String, Object> result = new HashMap<String, Object>();
		
		ArrayList<Schedule> schedule_list = scheduleService.getSchedules(login_id);
		
		result.put("data", schedule_list);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 프로그램신청(수강신청)
	@PostMapping
	public ResponseEntity<Map<String, Object>> programApply(@RequestParam("schedule_code") String schedule_code,
			@RequestAttribute("login_id") String login_id) {
		logger.info("programApply");
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			scheduleService.createEnroll(schedule_code, login_id);
			Schedule schedule = scheduleService.getSchedule(schedule_code, login_id);
			
			result.put("schedule_info", schedule);
			result.put("msg", "success");
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			result.put("msg", "fail");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
	}
}
