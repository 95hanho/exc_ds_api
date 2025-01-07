package me._hanho.ds.model;

import java.util.ArrayList;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "talktalk")
public class Talktalk {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String content;
	private int hit;
	private Date regdate;
	private int program_num;
	private String program_code;
	private String program_name;
	private String writer_login_id;
	private String writer;
	private ArrayList<Comment> comment_list = new ArrayList<>();
	
	public Talktalk() {
		// TODO Auto-generated constructor stub
	}
	
	public Talktalk(int id, String title, String content, int hit, Date regdate, int program_num, String program_code,
			String program_name, String writer_login_id, String writer, ArrayList<Comment> comment_list) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.regdate = regdate;
		this.program_num = program_num;
		this.program_code = program_code;
		this.program_name = program_name;
		this.writer_login_id = writer_login_id;
		this.writer = writer;
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getProgram_num() {
		return program_num;
	}

	public void setProgram_num(int program_num) {
		this.program_num = program_num;
	}

	public String getProgram_code() {
		return program_code;
	}

	public void setProgram_code(String program_code) {
		this.program_code = program_code;
	}

	public String getProgram_name() {
		return program_name;
	}

	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}

	public String getWriter_login_id() {
		return writer_login_id;
	}

	public void setWriter_login_id(String writer_login_id) {
		this.writer_login_id = writer_login_id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public ArrayList<Comment> getComment_list() {
		return comment_list;
	}

	public void setComment_list(ArrayList<Comment> comment_list) {
		this.comment_list = comment_list;
	}

	@Override
	public String toString() {
		return "Talktalk [id=" + id + ", title=" + title + ", content=" + content + ", hit=" + hit + ", regdate="
				+ regdate + ", program_num=" + program_num + ", program_code=" + program_code + ", program_name="
				+ program_name + ", writer_login_id=" + writer_login_id + ", writer=" + writer + ", comment_list="
				+ comment_list + "]";
	}
	
}
