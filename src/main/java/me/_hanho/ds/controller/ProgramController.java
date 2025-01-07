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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me._hanho.ds.model.Program;
import me._hanho.ds.service.ProgramService;

@RestController
@RequestMapping("/v1/program")
public class ProgramController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProgramController.class);

	@Autowired
	private ProgramService programeService;
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> getProgramNames() {
		logger.info("getProgramNames");
		Map<String, Object> result = new HashMap<String, Object>();
		
		ArrayList<Program> program_list = programeService.getPrograms();
		
		result.put("data", program_list);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
