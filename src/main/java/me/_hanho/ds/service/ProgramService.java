package me._hanho.ds.service;

import java.util.ArrayList;
import java.util.List;

import me._hanho.ds.model.Program;
import me._hanho.ds.model.ProgramCategory;
import me._hanho.ds.model.Review;

public interface ProgramService {

	ArrayList<Program> getPrograms();

	ArrayList<ProgramCategory> getProgramCategory();

	Program getProgramAndCategory(String program_code);

	List<Review> getReviews(String program_code);

}
