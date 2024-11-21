package me._hanho.ds.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me._hanho.ds.model.Program;
import me._hanho.ds.model.ProgramCategory;
import me._hanho.ds.model.Review;
import me._hanho.ds.repository.ProgramRepository;

@Service
public class ProgramServiceImpl implements ProgramService {

	@Autowired
	private ProgramRepository programDAO;
	
	@Override
	public ArrayList<Program> getPrograms() {
		return programDAO.getPrograms();
	}

	@Override
	public ArrayList<ProgramCategory> getProgramCategory() {
		return programDAO.getProgramCategory();
	}

	@Override
	public Program getProgramAndCategory(String program_code) {
		return programDAO.getProgramAndCategory(program_code);
	}

	@Override
	public List<Review> getReviews(String program_code) {
		return programDAO.getReviews(program_code);
	}

}
