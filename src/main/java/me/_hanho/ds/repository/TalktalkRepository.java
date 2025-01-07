package me._hanho.ds.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me._hanho.ds.mapper.TalktalkMapper;
import me._hanho.ds.model.Comment;
import me._hanho.ds.model.Talktalk;

@Repository
public class TalktalkRepository {
	
	@Autowired
	private TalktalkMapper talktalkMapper;
	
	public int createTalktalk(Talktalk talktalk) {
		return talktalkMapper.createTalktalk(talktalk);
	}

	public int updateTalktalk(Talktalk talktalk) {
		return talktalkMapper.updateTalktalk(talktalk);
	}
	
	public Talktalk getTalktalk() {
		return talktalkMapper.getTalktalk();
	}
	public Talktalk getTalktalk(int id) {
		return talktalkMapper.getTalktalk2(id);
	}

	public int getTalktalkCount() {
		return talktalkMapper.getTalktalkCount();
	}

	public List<Talktalk> getTalktalks(int size, int offset, String program_code) {
		if(program_code == null) {
			return talktalkMapper.getTalktalks(size, offset);	
		} else {
			return talktalkMapper.getTalktalks2(size, offset, program_code);
		}
		
	}
	
	public int deleteTalktalk(int id) {
		return talktalkMapper.deleteTalktalk(id);
	}

	public int talktalkUpHit(int id) {
		return talktalkMapper.talktalkUpHit(id);
	}

	public int createComment(Comment comment) {
		return talktalkMapper.createComment(comment);
	}

	public Comment getComment() {
		return talktalkMapper.getComment();
	}

	public ArrayList<Comment> getComments(int id) {
		return talktalkMapper.getComments(id);
	}
	
	public int updateComment(Comment comment) {
		return talktalkMapper.updateComment(comment);
	}

	public int deleteComment(int id) {
		return talktalkMapper.deleteComment(id);
	}


}
