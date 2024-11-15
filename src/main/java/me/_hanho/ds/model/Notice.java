package me._hanho.ds.model;

import java.util.ArrayList;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notice")
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String content;
	private Date regdate;
	private int hit;
	private Boolean secret;
	private int top;
	private String type;
	private String writer;
	private String writer_login_id;
	private Boolean manager_comment_latest;
	private ArrayList<UploadFile> file_list = new ArrayList<>();
	private ArrayList<Comment> comment_list = new ArrayList<>();
	
	public Notice() {
	}
	
	public Notice(int id, String title, String content, Date regdate, int hit, Boolean secret, int top, String type,
		String writer, String writer_login_id, Boolean manager_comment_latest, ArrayList<UploadFile> file_list) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
		this.secret = secret;
		this.top = top;
		this.type = type;
		this.writer = writer;
		this.writer_login_id = writer_login_id;
		this.manager_comment_latest = manager_comment_latest;
		this.file_list = file_list;
	}

	public Notice(int id, String title, String content, Date regdate, int hit, Boolean secret, int top, String type,
			String writer, String writer_login_id, Boolean manager_comment_latest, ArrayList<UploadFile> file_list,
			ArrayList<Comment> comment_list) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
		this.secret = secret;
		this.top = top;
		this.type = type;
		this.writer = writer;
		this.writer_login_id = writer_login_id;
		this.manager_comment_latest = manager_comment_latest;
		this.file_list = file_list;
		this.comment_list = comment_list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Boolean getSecret() {
		return secret;
	}

	public void setSecret(Boolean secret) {
		this.secret = secret;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Boolean getManager_comment_latest() {
		return manager_comment_latest;
	}

	public void setManager_comment_latest(Boolean manager_comment_latest) {
		this.manager_comment_latest = manager_comment_latest;
	}
	
	public ArrayList<UploadFile> getFile_list() {
		return file_list;
	}

	public void setFile_list(ArrayList<UploadFile> file_list) {
		this.file_list = file_list;
	}
	
	public ArrayList<Comment> getComment_list() {
		return comment_list;
	}

	public void setComment_list(ArrayList<Comment> comment_list) {
		this.comment_list = comment_list;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", hit="
				+ hit + ", secret=" + secret + ", top=" + top + ", type=" + type + ", writer=" + writer
				+ ", writer_login_id=" + writer_login_id + ", manager_comment_latest=" + manager_comment_latest
				+ ", file_list=" + file_list + ", comment_list=" + comment_list + "]";
	}

	
}
