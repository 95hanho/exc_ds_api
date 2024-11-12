package me._hanho.ds.mapper;

import org.apache.ibatis.annotations.Mapper;

import me._hanho.ds.model.Notice;

@Mapper
public interface NoticeMapper {

	int createNotice(Notice notice);

	Notice getNotice();

}
