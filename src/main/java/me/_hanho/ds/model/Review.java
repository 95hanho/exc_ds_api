package me._hanho.ds.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int review_num;
	private int rate;
	private String contents;
	private Date regdate;
	private String writer;
	
	private int program_num;
	
	private String program_code;
	private String review_content;
	private String review_enrol_date;
	private String review_name;
	private int review_ring_rate;
	
	public Review() {
	}

	public Review(int review_num, int rate, String contents, Date regdate, String writer, int program_num) {
		super();
		this.review_num = review_num;
		this.rate = rate;
		this.contents = contents;
		this.regdate = regdate;
		this.writer = writer;
		this.program_num = program_num;
	}
	
	public Review(String program_code, String review_content, String review_enrol_date, String review_name,
			int review_ring_rate) {
		super();
		this.program_code = program_code;
		this.review_content = review_content;
		this.review_enrol_date = review_enrol_date;
		this.review_name = review_name;
		this.review_ring_rate = review_ring_rate;
	}

	public int getReview_num() {
		return review_num;
	}

	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public String getReview_enrol_date() {
		return review_enrol_date;
	}

	public void setReview_enrol_date(String review_enrol_date) {
		this.review_enrol_date = review_enrol_date;
	}

	public String getReview_name() {
		return review_name;
	}

	public void setReview_name(String review_name) {
		this.review_name = review_name;
	}

	public int getReview_ring_rate() {
		return review_ring_rate;
	}

	public void setReview_ring_rate(int review_ring_rate) {
		this.review_ring_rate = review_ring_rate;
	}

	@Override
	public String toString() {
		return "Review [review_num=" + review_num + ", rate=" + rate + ", contents=" + contents + ", regdate=" + regdate
				+ ", writer=" + writer + ", program_num=" + program_num + ", program_code=" + program_code
				+ ", review_content=" + review_content + ", review_enrol_date=" + review_enrol_date + ", review_name="
				+ review_name + ", review_ring_rate=" + review_ring_rate + "]";
	}

}
