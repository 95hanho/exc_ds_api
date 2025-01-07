package me._hanho.ds.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me._hanho.ds.model.Comment;
import me._hanho.ds.model.Notice;
import me._hanho.ds.repository.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeRepository noticeDAO;
	
	@Override
	public int createNotice(Notice notice) {
		return noticeDAO.createNotice(notice);
	}
	
	@Override
	public int updateNotice(Notice notice) {
		return noticeDAO.updateNotice(notice);
	}

	@Override
	public Notice getNotice() {
		return noticeDAO.getNotice();
	}
	
	@Override
	public Notice getNotice(int id) {
		return noticeDAO.getNotice(id);
	}


	@Override
	public int getNoticeCount() {
		return noticeDAO.getNoticeCount();
	}

	@Override
	public List<Notice> getNotices(int size, int offset) {
		return noticeDAO.getNotices(size, offset);
	}
	
	@Override
	public ArrayList<Notice> getNoticesLatest() {
		return noticeDAO.getNoticesLatest();
	}
	
	@Override
	public int deleteNotice(int id) {
		return noticeDAO.deleteNotice(id);
	}

	@Override
	public int noticeUpHit(int id) {
		return noticeDAO.noticeUpHit(id);
	}

	@Override
	public int createComment(Comment comment) {
		return noticeDAO.createComment(comment);
	}

	@Override
	public Comment getComment() {
		return noticeDAO.getComment();
	}

	@Override
	public ArrayList<Comment> getComments(int id) {
		return noticeDAO.getComments(id);
	}
	
	@Override
	public int updateComment(Comment comment) {
		return noticeDAO.updateComment(comment);
	}

	@Override
	public int deleteComment(int id) {
		return noticeDAO.deleteComment(id);
	}

	@Override
	public int updateNoticeManagerLatest(int id, boolean status) {
		return noticeDAO.updateNoticeManagerLatest(id, status);
	}




}
