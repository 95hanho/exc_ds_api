package me._hanho.ds.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	// 로그인
	@PostMapping("/v1/auth/login-old")
	public ResponseEntity<Map<String, Object>> login() {
		Map<String, Object> result = new HashMap<String, Object>();
		
		
		return new ResponseEntity<>(null);
	}
	// 토큰 리프레쉬
	@PostMapping("/v1/auth/regenerator/refresh")
	public ResponseEntity<Map<String, Object>> tokenRefresh() {
		Map<String, Object> result = new HashMap<String, Object>();
		
		
		return new ResponseEntity<>(null);
	}
	// 유저정보가져오기
	@GetMapping("/v1/member/info")
	public ResponseEntity<Map<String, Object>> getUserInfo() {
		Map<String, Object> result = new HashMap<String, Object>();
		
		
		return new ResponseEntity<>(null);
	}
	
}
