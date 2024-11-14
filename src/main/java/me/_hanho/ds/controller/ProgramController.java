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

import me._hanho.ds.model.Program;
import me._hanho.ds.service.ProgramService;

@RestController
@RequestMapping("/v1/program")
public class ProgramController {

	@Autowired
	private ProgramService programeService;
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> getProgramNames() {
		System.out.println("getProgramNames");
		Map<String, Object> result = new HashMap<String, Object>();
		
		ArrayList<Program> program_list = programeService.getPrograms();
		
		result.put("data", program_list);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
