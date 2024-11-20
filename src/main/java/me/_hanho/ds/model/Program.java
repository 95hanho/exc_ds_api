package me._hanho.ds.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "program")
public class Program {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int program_num;
	private String program_code;
	private String program_name;
	private String program_status;
	private String program_header_img_url_v2;
	private String program_new_label;
	private String program_hash_tag;
	private Object time;
	private String time_ment;
	private String place;
	private String program_content;
	
	private int category_num;
	private String category_name;
	private String category_bg_url;
	private String program_category;
	
	public Program() {
	}

	public Program(int program_num, String program_code, String program_name, String program_status,
			String program_header_img_url_v2, String program_new_label, String program_hash_tag, Object time,
			String time_ment, String place, String program_content, int category_num, String category_name,
			String category_bg_url) {
		super();
		this.program_num = program_num;
		this.program_code = program_code;
		this.program_name = program_name;
		this.program_status = program_status;
		this.program_header_img_url_v2 = program_header_img_url_v2;
		this.program_new_label = program_new_label;
		this.program_hash_tag = program_hash_tag;
		this.time = time;
		this.time_ment = time_ment;
		this.place = place;
		this.program_content = program_content;
		this.category_num = category_num;
		this.category_name = category_name;
		this.category_bg_url = category_bg_url;
	}

	

	public Program(int program_num, String program_code, String program_name, String program_status,
			String program_header_img_url_v2, String program_new_label, String program_hash_tag, Object time,
			String time_ment, String place, String program_content, int category_num, String category_name,
			String category_bg_url, String program_category) {
		super();
		this.program_num = program_num;
		this.program_code = program_code;
		this.program_name = program_name;
		this.program_status = program_status;
		this.program_header_img_url_v2 = program_header_img_url_v2;
		this.program_new_label = program_new_label;
		this.program_hash_tag = program_hash_tag;
		this.time = time;
		this.time_ment = time_ment;
		this.place = place;
		this.program_content = program_content;
		this.category_num = category_num;
		this.category_name = category_name;
		this.category_bg_url = category_bg_url;
		this.program_category = program_category;
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

	public Object getTime() {
		return time;
	}

	public void setTime(Object time) {
		this.time = time;
	}

	public String getTime_ment() {
		return time_ment;
	}

	public void setTime_ment(String time_ment) {
		this.time_ment = time_ment;
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
	
	public String getProgram_category() {
		return program_category;
	}

	public void setProgram_category(String program_category) {
		this.program_category = program_category;
	}

	@Override
	public String toString() {
		return "Program [program_num=" + program_num + ", program_code=" + program_code + ", program_name="
				+ program_name + ", program_status=" + program_status + ", program_header_img_url_v2="
				+ program_header_img_url_v2 + ", program_new_label=" + program_new_label + ", program_hash_tag="
				+ program_hash_tag + ", time=" + time + ", time_ment=" + time_ment + ", place=" + place
				+ ", program_content=" + program_content + ", category_num=" + category_num + ", category_name="
				+ category_name + ", category_bg_url=" + category_bg_url + ", program_category=" + program_category
				+ "]";
	}

}

