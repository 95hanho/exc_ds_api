package me._hanho.ds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Notice getNotice() {
		return noticeDAO.getNotice();
	}

}
