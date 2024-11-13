package me._hanho.ds.model;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {
	
	@Id
	private int id;
	private String content;
	private String writer;
	private String writer_login_id;
	private Date regdate;
	private int notice_id;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(int id, String content, String writer, String writer_login_id, Date regdate, int notice_id) {
		super();
		this.id = id;
		this.content = content;
		this.writer = writer;
		this.writer_login_id = writer_login_id;
		this.regdate = regdate;
		this.notice_id = notice_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWriter_login_id() {
		return writer_login_id;
	}

	public void setWriter_login_id(String writer_login_id) {
		this.writer_login_id = writer_login_id;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", writer=" + writer + ", writer_login_id="
				+ writer_login_id + ", regdate=" + regdate + ", notice_id=" + notice_id + "]";
	}

	
	
}
