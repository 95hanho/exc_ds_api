package me._hanho.ds.service;

import java.util.ArrayList;
import java.util.List;

import me._hanho.ds.model.Comment;
import me._hanho.ds.model.Notice;

public interface NoticeService {

	int createNotice(Notice notice);
	// 최신 가져오기
	Notice getNotice();
	// 
	Notice getNotice(int id);

	int getNoticeCount();

	List<Notice> getNotices(int size, int offset);
	
	int noticeUpHit(int id);
	
	int createComment(Comment comment);
	
	Comment getComment();
	
	ArrayList<Comment> getComments(int id);
	
	int deleteComment(int id);
	

}
