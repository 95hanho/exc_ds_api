package me._hanho.ds.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "file")
public class UploadFile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int file_num;
	private String name;
	private String fileName;
	private Date create_at;
	private int notice_id;
	private String url;
	
	public UploadFile() {
	}

	public UploadFile(String name, int notice_id) {
		super();
		this.name = name;
		this.notice_id = notice_id;
	}

	public UploadFile(int file_num, String name, Date create_at, int notice_id, String url) {
		super();
		this.file_num = file_num;
		this.name = name;
		this.create_at = create_at;
		this.notice_id = notice_id;
		this.url = url;
	}
	
	public UploadFile(int file_num, String name, String fileName, Date create_at, int notice_id, String url) {
		super();
		this.file_num = file_num;
		this.name = name;
		this.fileName = fileName;
		this.create_at = create_at;
		this.notice_id = notice_id;
		this.url = url;
	}

	public int getFile_num() {
		return file_num;
	}

	public void setFile_num(int file_num) {
		this.file_num = file_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public int getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "UploadFile [file_num=" + file_num + ", name=" + name + ", fileName=" + fileName + ", create_at="
				+ create_at + ", notice_id=" + notice_id + ", url=" + url + "]";
	}
	
}
