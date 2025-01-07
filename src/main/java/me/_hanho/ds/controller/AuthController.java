package me._hanho.ds.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/v1/auth")
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenService tokenService;

	// 로그인
	@PostMapping("/login-old")
	public ResponseEntity<Map<String, Object>> login(@ModelAttribute User user, @RequestHeader("user-agent") String agent
			, HttpServletRequest request) {
		logger.info("login");
		Map<String, Object> result = new HashMap<String, Object>();
		
		User checkUser = userService.getUser(user);
		if(checkUser != null) {
			User onlyId = new User();
			onlyId.setLogin_id(checkUser.getLogin_id());
			String accessToken = tokenService.makeJwtToken(60L, onlyId);
			String refreshToken = tokenService.makeJwtToken(180L);
			String ipAddress = request.getRemoteAddr();
			Token token = new Token(refreshToken, agent, ipAddress, checkUser.getLogin_id());
			Token checkToken = userService.getToken(token);
			int result_count = 0;
			if(checkToken == null) {
				result_count = userService.insertToken(token);
			} else {
				try {
					tokenService.parseJwtToken(checkToken.getRefresh_token());
					result_count = userService.updateToken(token);
				} catch (Exception e) {
					result_count = userService.insertToken(token);
				}
			}

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
	@PostMapping("/regenerator/refresh")
	public ResponseEntity<Map<String, Object>> tokenRefresh(@RequestParam("refresh_token") String refresh_token
			, @RequestHeader("user-agent") String agent, HttpServletRequest request) {
		logger.info("tokenRefresh");
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
			
			if(checkUser != null) {
				User onlyId = new User();
				onlyId.setLogin_id(checkUser.getLogin_id());
				String accessToken = tokenService.makeJwtToken(60L, onlyId);
				String refreshToken = tokenService.makeJwtToken(180L);
				Token token2 = new Token(refreshToken, agent, ipAddress, checkUser.getLogin_id());
				int result_count = userService.updateToken(token2);
				
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
	
}
