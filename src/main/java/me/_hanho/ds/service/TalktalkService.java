package me._hanho.ds.service;

import java.util.ArrayList;
import java.util.List;

import me._hanho.ds.model.Comment;
import me._hanho.ds.model.Talktalk;

public interface TalktalkService {

	int createTalktalk(Talktalk talktalk);
	
	int updateTalktalk(Talktalk talktalk);
	// 최신 가져오기
	Talktalk getTalktalk();
	// 
	Talktalk getTalktalk(int id);

	int getTalktalkCount();

	List<Talktalk> getTalktalks(int size, int offset, String program_code);
	
	int deleteTalktalk(int id);
	
	int talktalkUpHit(int id);
	
	int createComment(Comment comment);
	
	Comment getComment();
	
	ArrayList<Comment> getComments(int id);
	
	int updateComment(Comment comment);
	
	int deleteComment(int id);
}
