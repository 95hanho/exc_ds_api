package me._hanho.ds.model;


import java.util.Date;

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
	private String filePath;
	private Date create_at;
	private int popup_id;
	private int notice_id;
	private int program_num;
	private String url;
	
	public UploadFile() {
	}

	public UploadFile(int file_num, String name, String filePath, Date create_at, int notice_id, int program_num,
			String url) {
		super();
		this.file_num = file_num;
		this.name = name;
		this.filePath = filePath;
		this.create_at = create_at;
		this.notice_id = notice_id;
		this.program_num = program_num;
		this.url = url;
	}
	
	public UploadFile(int file_num, String name, String filePath, Date create_at, int popup_id, int notice_id,
			int program_num, String url) {
		super();
		this.file_num = file_num;
		this.name = name;
		this.filePath = filePath;
		this.create_at = create_at;
		this.popup_id = popup_id;
		this.notice_id = notice_id;
		this.program_num = program_num;
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

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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

	public int getProgram_num() {
		return program_num;
	}

	public void setProgram_num(int program_num) {
		this.program_num = program_num;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPopup_id() {
		return popup_id;
	}

	public void setPopup_id(int popup_id) {
		this.popup_id = popup_id;
	}

	@Override
	public String toString() {
		return "UploadFile [file_num=" + file_num + ", name=" + name + ", filePath=" + filePath + ", create_at="
				+ create_at + ", popup_id=" + popup_id + ", notice_id=" + notice_id + ", program_num=" + program_num
				+ ", url=" + url + "]";
	}

}
