package me._hanho.ds.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import me._hanho.ds.model.Program;
import me._hanho.ds.model.ProgramCategory;
import me._hanho.ds.model.Review;

@Mapper
public interface ProgramMapper {

	ArrayList<Program> getPrograms();
	
	ArrayList<Program> getPrograms2(int cate_num);

	ArrayList<ProgramCategory> getProgramCategory();

	Program getProgramAndCategory(String program_code);

	List<Review> getReviews(String program_code);

}
