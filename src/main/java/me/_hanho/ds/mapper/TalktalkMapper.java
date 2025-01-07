package me._hanho.ds.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import me._hanho.ds.model.Comment;
import me._hanho.ds.model.Talktalk;

@Mapper
public interface TalktalkMapper {

	int createTalktalk(Talktalk talktalk);
	
	int updateTalktalk(Talktalk talktalk);

	Talktalk getTalktalk();
	Talktalk getTalktalk2(int id);

	int getTalktalkCount();

	List<Talktalk> getTalktalks(@Param("size") int size, @Param("offset") int offset);
	List<Talktalk> getTalktalks2(@Param("size") int size, @Param("offset") int offset, @Param("program_code") String program_code);
	
	int deleteTalktalk(int id);

	int talktalkUpHit(int id);

	int createComment(Comment comment);

	Comment getComment();

	ArrayList<Comment> getComments(int id);
	
	int updateComment(Comment comment);

	int deleteComment(int id);
	
}
