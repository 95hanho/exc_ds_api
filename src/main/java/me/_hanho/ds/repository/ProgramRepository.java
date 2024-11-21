package me._hanho.ds.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me._hanho.ds.mapper.ProgramMapper;
import me._hanho.ds.model.Program;
import me._hanho.ds.model.ProgramCategory;
import me._hanho.ds.model.Review;

@Repository
public class ProgramRepository {
	
	@Autowired
	private ProgramMapper programMapper;

	public ArrayList<Program> getPrograms() {
		return programMapper.getPrograms();
	}

	public ArrayList<ProgramCategory> getProgramCategory() {
		ArrayList<ProgramCategory> result =  new ArrayList<>();
		ArrayList<ProgramCategory> pc_list =  programMapper.getProgramCategory();
		pc_list.stream().forEach(pc -> {
			ArrayList<Program> p_list = programMapper.getPrograms2(pc.getCate_num());
			if(p_list.size() > 0) {
				pc.setList(p_list);
				result.add(pc);
			}
		});
		
		return result;
	}

	public Program getProgramAndCategory(String program_code) {
		return programMapper.getProgramAndCategory(program_code);
	}

	public List<Review> getReviews(String program_code) {
		return programMapper.getReviews(program_code);
	}

}
