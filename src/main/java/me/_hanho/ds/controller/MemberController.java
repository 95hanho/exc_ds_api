package me._hanho.ds.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me._hanho.ds.model.CancelLog;
import me._hanho.ds.model.Enroll;
import me._hanho.ds.model.User;
import me._hanho.ds.service.ScheduleService;
import me._hanho.ds.service.UserService;

@RestController
@RequestMapping("/v1/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private ScheduleService scheduleService;
	
	// 유저정보가져오기
	@GetMapping("/info")
	public ResponseEntity<Map<String, Object>> getUserInfo(@RequestAttribute("login_id") String login_id) {
		logger.info("getUserInfo");
		Map<String, Object> result = new HashMap<String, Object>();
		
		if(login_id != null) {
			User user = userService.getUser(login_id);
			result.put("msg", "success");
			result.put("data", user);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			result.put("msg", "token제대로 안됨");
			return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
		}
	}
	
	// 나의수강신청정보조회
	@GetMapping("/application")
	public ResponseEntity<Map<String, Object>> myApplication(@RequestAttribute("login_id") String login_id) {
		logger.info("myApplication");
		Map<String, Object> result = new HashMap<String, Object>();
		
		ArrayList<Enroll> enroll_list = scheduleService.getEnrolls(login_id);
		
		Map<String, Object> dataResult = new HashMap<String, Object>();
		dataResult.put("new_list", enroll_list);
		dataResult.put("old_list", new ArrayList<>());
		result.put("data", dataResult);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 수강신청취소 사유목록
	@GetMapping("/cancel/msg")
	public ResponseEntity<Map<String, Object>> applyCancelList(@RequestAttribute("login_id") String login_id) {
		logger.info("applyCancelList");
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<String> cancel_list = new ArrayList<>();
		cancel_list.add("급한 업무 및 회의");
		cancel_list.add("동일 과정 다른 날짜로 변경");
		cancel_list.add("본인 코로나 양성 판정(자가진단~PCR)");
		cancel_list.add("가족/동료 코로나 확진으로 인한 검사 실시");
		cancel_list.add("정원미달로 인한 폐강");
		cancel_list.add("개인 사정 및 기타");
		
		result.put("data", cancel_list);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 수강신청취소
	@PutMapping("/application")
	public ResponseEntity<Map<String, Object>> applyCancel(@ModelAttribute CancelLog cancel_log,
			@RequestAttribute("login_id") String login_id) {
		logger.info("applyCancel");
		Map<String, Object> result = new HashMap<String, Object>();
		cancel_log.setLogin_id(login_id);
		
		try {
			cancel_log.setFlag("취소");
			scheduleService.deleteEnroll(cancel_log);
			result.put("msg", "success");
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			result.put("msg", "fail");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
