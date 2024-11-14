package me._hanho.ds.service;

import java.util.ArrayList;

import me._hanho.ds.model.Program;
import me._hanho.ds.model.ProgramCategory;

public interface ProgramService {

	ArrayList<Program> getPrograms();

	ArrayList<ProgramCategory> getProgramCategory();

	Program getProgramAndCategory(String program_code);

}
