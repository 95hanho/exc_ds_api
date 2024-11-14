package me._hanho.ds.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me._hanho.ds.model.User;
import me._hanho.ds.service.UserService;

@RestController
@RequestMapping("/v1/member")
public class MemberController {

	@Autowired
	private UserService userService;
	
	// 유저정보가져오기
	@GetMapping("/info")
	public ResponseEntity<Map<String, Object>> getUserInfo(@RequestAttribute("login_id") String login_id) {
		System.out.println("getUserInfo");
		Map<String, Object> result = new HashMap<String, Object>();
		
		System.out.println("param login_id : " + login_id);
		
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
		System.out.println("myApplication");
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 수강신청취소 사유목록
	@GetMapping("/cancel/msg")
	public ResponseEntity<Map<String, Object>> applyCancelList(@RequestAttribute("login_id") String login_id) {
		System.out.println("applyCancelList");
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 수강신청취소
	@PutMapping("/member/application")
	public ResponseEntity<Map<String, Object>> applyCancel(@RequestAttribute("login_id") String login_id) {
		System.out.println("applyCancel");
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
