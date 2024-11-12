package me._hanho.ds.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me._hanho.ds.mapper.NoticeMapper;
import me._hanho.ds.model.Notice;

@Repository
public class NoticeRepository {

	@Autowired
	private NoticeMapper noticeMapper;
	
	public int createNotice(Notice notice) {
		return noticeMapper.createNotice(notice);
	}

	public Notice getNotice() {
		return noticeMapper.getNotice();
	}

	
}
