package me._hanho.ds.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import me._hanho.ds.model.Token;
import me._hanho.ds.model.User;
import me._hanho.ds.service.TokenService;
import me._hanho.ds.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenService tokenService;

	// 로그인
	@PostMapping("/v1/auth/login-old")
	public ResponseEntity<Map<String, Object>> login(@ModelAttribute User user, @RequestHeader("user-agent") String agent
			, HttpServletRequest request) {
		System.out.println("login");
		Map<String, Object> result = new HashMap<String, Object>();
		System.out.println("param User : " + user);
		
		User checkUser = userService.getUser(user);
		if(checkUser != null) {
			User onlyId = new User();
			onlyId.setLogin_id(checkUser.getLogin_id());
			String accessToken = tokenService.makeJwtToken(60L, onlyId);
			String refreshToken = tokenService.makeJwtToken(180L);
			String ipAddress = request.getRemoteAddr();
			Token token = new Token(refreshToken, agent, ipAddress, checkUser.getLogin_id());
			int result_count = userService.createToken(token);
			System.out.println(result_count);

			result.put("msg", "success");
			result.put("access_token", accessToken);
			;
			if(checkUser.getGrant() == 90) {
				result.put("exception", "ADMIN");
			} else {
				result.put("exception", "USER");
			}
			result.put("refresh_token", refreshToken);
			return new ResponseEntity<>(
					result
					, HttpStatus.OK);
		} else {
			result.put("msg", "아이디/비번틀림");
			return new ResponseEntity<>(
					result
					, HttpStatus.BAD_REQUEST);
		}
			
	}
	// 토큰 리프레쉬
	@PostMapping("/v1/auth/regenerator/refresh")
	public ResponseEntity<Map<String, Object>> tokenRefresh(@RequestParam("refresh_token") String refresh_token
			, @RequestHeader("user-agent") String agent, HttpServletRequest request) {
		System.out.println("tokenRefresh");
		Map<String, Object> result = new HashMap<String, Object>();
		
		Claims claims = null;
		try {
			claims = tokenService.parseJwtToken(refresh_token);
		} catch (Exception e) {
			result.put("msg", "token제대로 안됨");
			return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
		}
		
		if(claims != null) {
			String ipAddress = request.getRemoteAddr();
			Token token = new Token(refresh_token, agent, ipAddress);
			User checkUser = userService.getUser(token);
			
			System.out.println(checkUser);
			if(checkUser != null) {
				User onlyId = new User();
				onlyId.setLogin_id(checkUser.getLogin_id());
				String accessToken = tokenService.makeJwtToken(60L, onlyId);
				String refreshToken = tokenService.makeJwtToken(180L);
				Token token2 = new Token(refreshToken, agent, ipAddress, checkUser.getLogin_id());
				int result_count = userService.createToken(token2);
				
				System.out.println("result_count : " + result_count);
				
				Map<String, Object> dataMap = new HashMap<String, Object>();
				result.put("msg", "success");
				dataMap.put("access_token", accessToken);
				dataMap.put("refresh_token", refreshToken);
				if(checkUser.getGrant() == 90) {
					result.put("exception", "ADMIN");
				} else {
					result.put("exception", "USER");
				}
				result.put("data", dataMap);
				return new ResponseEntity<>(result, HttpStatus.OK);
			} else {
				result.put("msg", "token제대로 안됨");
				return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
			}
		} else {
			result.put("msg", "token제대로 안됨");
			return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
		}
		
	}
	// 유저정보가져오기
	@GetMapping("/v1/member/info")
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
	
}
