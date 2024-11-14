package me._hanho.ds.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import me._hanho.ds.model.Program;
import me._hanho.ds.model.ProgramCategory;

@Mapper
public interface ProgramMapper {

	ArrayList<Program> getPrograms();
	
	ArrayList<Program> getPrograms2(int cate_num);

	ArrayList<ProgramCategory> getProgramCategory();

	Program getProgramAndCategory(String program_code);

}
