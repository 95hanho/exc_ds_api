package me._hanho.ds.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me._hanho.ds.model.Program;
import me._hanho.ds.model.ProgramCategory;
import me._hanho.ds.service.ProgramService;

@RestController
@RequestMapping("/v1/introduce")
public class IntroController {
	
	@Autowired
	private ProgramService programService;

	// 프로그램소개 리스트 가져오기
	@GetMapping("/info")
	public ResponseEntity<Map<String, Object>> getIntros() {
		System.out.println("getIntros");
		Map<String, Object> result = new HashMap<String, Object>();
		
		ArrayList<ProgramCategory> catelist = programService.getProgramCategory();

		result.put("data", catelist);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	// 프로그램 상세조회
	@GetMapping("/detail/{program_code}")
	public ResponseEntity<Map<String, Object>> getIntroDetail(@PathVariable("program_code") String program_code) {
		System.out.println("getIntroDetail");
		Map<String, Object> result = new HashMap<String, Object>();
		
		Program program = programService.getProgramAndCategory(program_code);
		
		Map<String, Object> dataResult = new HashMap<String, Object>();
		Map<String, Object> data_infoResult = new HashMap<String, Object>();
		
		dataResult.put("program_name", program.getProgram_name());
		
		data_infoResult.put("categroy_name", program.getCategory_name());
		data_infoResult.put("categroy_bg_url", program.getCategory_bg_url());
		data_infoResult.put("time", program.getTime() + "H " + program.getTime_ment());
		data_infoResult.put("place", program.getPlace());
		dataResult.put("program_meta_info", data_infoResult);
		dataResult.put("program_content", program.getProgram_content());
		dataResult.put("review_data", new ArrayList<>());
		result.put("data", dataResult);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}