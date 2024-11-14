package me._hanho.ds.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "program")
public class Program {

	@Id
	private int program_num;
	private String program_code;
	private String program_name;
	private String program_status;
	private String program_header_img_url_v2;
	private String program_new_label;
	private String program_hash_tag;
	private int category_num;
	
	private String category_name;
	private String category_bg_url;
	private String time;
	private String place;
	private String program_content;
	
	public Program() {
	}

	public Program(int program_num, String program_code, String program_name, String program_status,
			String program_header_img_url_v2, String program_new_label, String program_hash_tag, int category_num,
			String category_name, String category_bg_url, String time, String place, String program_content) {
		super();
		this.program_num = program_num;
		this.program_code = program_code;
		this.program_name = program_name;
		this.program_status = program_status;
		this.program_header_img_url_v2 = program_header_img_url_v2;
		this.program_new_label = program_new_label;
		this.program_hash_tag = program_hash_tag;
		this.category_num = category_num;
		this.category_name = category_name;
		this.category_bg_url = category_bg_url;
		this.time = time;
		this.place = place;
		this.program_content = program_content;
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

	public String getProgram_status() {
		return program_status;
	}

	public void setProgram_status(String program_status) {
		this.program_status = program_status;
	}

	public String getProgram_header_img_url_v2() {
		return program_header_img_url_v2;
	}

	public void setProgram_header_img_url_v2(String program_header_img_url_v2) {
		this.program_header_img_url_v2 = program_header_img_url_v2;
	}

	public String getProgram_new_label() {
		return program_new_label;
	}

	public void setProgram_new_label(String program_new_label) {
		this.program_new_label = program_new_label;
	}

	public String getProgram_hash_tag() {
		return program_hash_tag;
	}

	public void setProgram_hash_tag(String program_hash_tag) {
		this.program_hash_tag = program_hash_tag;
	}

	public int getCategory_num() {
		return category_num;
	}

	public void setCategory_num(int category_num) {
		this.category_num = category_num;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	

	public String getCategory_bg_url() {
		return category_bg_url;
	}

	public void setCategory_bg_url(String category_bg_url) {
		this.category_bg_url = category_bg_url;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getProgram_content() {
		return program_content;
	}

	public void setProgram_content(String program_content) {
		this.program_content = program_content;
	}

	@Override
	public String toString() {
		return "Program [program_num=" + program_num + ", program_code=" + program_code + ", program_name="
				+ program_name + ", program_status=" + program_status + ", program_header_img_url_v2="
				+ program_header_img_url_v2 + ", program_new_label=" + program_new_label + ", program_hash_tag="
				+ program_hash_tag + ", category_num=" + category_num + ", category_name=" + category_name
				+ ", category_bg_url=" + category_bg_url + ", time=" + time + ", place=" + place + ", program_content="
				+ program_content + "]";
	}

}

