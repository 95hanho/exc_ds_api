package me._hanho.ds.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me._hanho.ds.model.Notice;
import me._hanho.ds.service.NoticeService;

@RestController
@RequestMapping("/v1/main")
public class MainController {
	
	@Autowired
	private NoticeService noticeService;

	// 메인페이지 필요정보
	@GetMapping("/latest")
	public ResponseEntity<Map<String, Object>> mainInit() {
		System.out.println("getProgram");
		Map<String, Object> result = new HashMap<String, Object>();
		
		ArrayList<Notice> notice_latest = noticeService.getNoticesLatest();
		
		Map<String, Object> dataResult = new HashMap<String, Object>();
		
		dataResult.put("notice_latest", notice_latest);
		dataResult.put("popup_list", new ArrayList<>());
		result.put("data", dataResult);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
