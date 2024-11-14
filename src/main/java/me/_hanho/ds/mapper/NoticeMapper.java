package me._hanho.ds.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import me._hanho.ds.model.Comment;
import me._hanho.ds.model.Notice;

@Mapper
public interface NoticeMapper {

	int createNotice(Notice notice);
	
	int updateNotice(Notice notice);

	Notice getNotice();
	Notice getNotice2(int id);

	int getNoticeCount();

	List<Notice> getNotices(@Param("size") int size, @Param("offset") int offset);
	
	ArrayList<Notice> getNoticesLatest();
	
	int deleteNotice(int id);

	int noticeUpHit(int id);

	int createComment(Comment comment);

	Comment getComment();

	ArrayList<Comment> getComments(int id);
	
	int updateComment(Comment comment);

	int deleteComment(int id);

	int updateNoticeManagerLatest(@Param("id") int id, @Param("status") boolean status);

}
