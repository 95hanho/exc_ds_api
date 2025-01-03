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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me._hanho.ds.model.Notice;
import me._hanho.ds.model.UploadFile;
import me._hanho.ds.service.FileService;
import me._hanho.ds.service.NoticeService;

@RestController
@RequestMapping("/v1/main")
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private FileService fileService;

	// 메인페이지 필요정보
	@GetMapping("/latest")
	public ResponseEntity<Map<String, Object>> mainInit() {
		logger.info("mainInit");
		Map<String, Object> result = new HashMap<String, Object>();
		
		ArrayList<Notice> notice_latest = noticeService.getNoticesLatest();
		
		Map<String, Object> dataResult = new HashMap<String, Object>();
		
		List<String> popup_list = fileService.getMainPopups();
		
		dataResult.put("notice_latest", notice_latest);
		dataResult.put("popup_list", popup_list);
		result.put("data", dataResult);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
