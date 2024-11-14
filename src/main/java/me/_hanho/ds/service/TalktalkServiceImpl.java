package me._hanho.ds.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me._hanho.ds.model.Comment;
import me._hanho.ds.model.Talktalk;
import me._hanho.ds.repository.TalktalkRepository;

@Service
public class TalktalkServiceImpl implements TalktalkService {
	@Autowired
	private TalktalkRepository talktalkDAO;

	@Override
	public int createTalktalk(Talktalk talktalk) {
		return talktalkDAO.createTalktalk(talktalk);
	}
	
	@Override
	public int updateTalktalk(Talktalk talktalk) {
		return talktalkDAO.updateTalktalk(talktalk);
	}

	@Override
	public Talktalk getTalktalk() {
		return talktalkDAO.getTalktalk();
	}
	
	@Override
	public Talktalk getTalktalk(int id) {
		return talktalkDAO.getTalktalk(id);
	}


	@Override
	public int getTalktalkCount() {
		return talktalkDAO.getTalktalkCount();
	}

	@Override
	public List<Talktalk> getTalktalks(int size, int offset, String program_code) {
		return talktalkDAO.getTalktalks(size, offset, program_code);
	}
	
	@Override
	public int deleteTalktalk(int id) {
		return talktalkDAO.deleteTalktalk(id);
	}

	@Override
	public int talktalkUpHit(int id) {
		return talktalkDAO.talktalkUpHit(id);
	}

	@Override
	public int createComment(Comment comment) {
		return talktalkDAO.createComment(comment);
	}

	@Override
	public Comment getComment() {
		return talktalkDAO.getComment();
	}

	@Override
	public ArrayList<Comment> getComments(int id) {
		return talktalkDAO.getComments(id);
	}
	
	@Override
	public int updateComment(Comment comment) {
		return talktalkDAO.updateComment(comment);
	}

	@Override
	public int deleteComment(int id) {
		return talktalkDAO.deleteComment(id);
	}

}
