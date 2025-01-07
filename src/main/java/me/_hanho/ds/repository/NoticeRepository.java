package me._hanho.ds.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me._hanho.ds.mapper.NoticeMapper;
import me._hanho.ds.model.Comment;
import me._hanho.ds.model.Notice;

@Repository
public class NoticeRepository {

	@Autowired
	private NoticeMapper noticeMapper;
	
	public int createNotice(Notice notice) {
		return noticeMapper.createNotice(notice);
	}

	public int updateNotice(Notice notice) {
		return noticeMapper.updateNotice(notice);
	}
	
	public Notice getNotice() {
		return noticeMapper.getNotice();
	}
	public Notice getNotice(int id) {
		return noticeMapper.getNotice2(id);
	}

	public int getNoticeCount() {
		return noticeMapper.getNoticeCount();
	}

	public List<Notice> getNotices(int size, int offset) {
		return noticeMapper.getNotices(size, offset);
	}
	
	public ArrayList<Notice> getNoticesLatest() {
		return noticeMapper.getNoticesLatest();
	}
	
	public int deleteNotice(int id) {
		return noticeMapper.deleteNotice(id);
	}

	public int noticeUpHit(int id) {
		return noticeMapper.noticeUpHit(id);
	}

	public int createComment(Comment comment) {
		return noticeMapper.createComment(comment);
	}

	public Comment getComment() {
		return noticeMapper.getComment();
	}

	public ArrayList<Comment> getComments(int id) {
		return noticeMapper.getComments(id);
	}
	
	public int updateComment(Comment comment) {
		return noticeMapper.updateComment(comment);
	}

	public int deleteComment(int id) {
		return noticeMapper.deleteComment(id);
	}

	public int updateNoticeManagerLatest(int id, boolean status) {
		return noticeMapper.updateNoticeManagerLatest(id, status);
	}



	
}
