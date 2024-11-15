package me._hanho.ds.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "enroll")
public class Enroll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enrol_id;
	private String title;
	private int enrol_waiting_rank;
	
	private int schedule_id;
	private String schedule_code;
	private Date schedule_start_Date;
	
	private String login_id;
	
	public Enroll() {
		// TODO Auto-generated constructor stub
	}

	public Enroll(int enrol_id, String title, int enrol_waiting_rank, int schedule_id, String schedule_code,
			Date schedule_start_Date, String login_id) {
		super();
		this.enrol_id = enrol_id;
		this.title = title;
		this.enrol_waiting_rank = enrol_waiting_rank;
		this.schedule_id = schedule_id;
		this.schedule_code = schedule_code;
		this.schedule_start_Date = schedule_start_Date;
		this.login_id = login_id;
	}

	public int getEnrol_id() {
		return enrol_id;
	}

	public void setEnrol_id(int enrol_id) {
		this.enrol_id = enrol_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getEnrol_waiting_rank() {
		return enrol_waiting_rank;
	}

	public void setEnrol_waiting_rank(int enrol_waiting_rank) {
		this.enrol_waiting_rank = enrol_waiting_rank;
	}

	public int getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}

	public String getSchedule_code() {
		return schedule_code;
	}

	public void setSchedule_code(String schedule_code) {
		this.schedule_code = schedule_code;
	}

	public Date getSchedule_start_Date() {
		return schedule_start_Date;
	}

	public void setSchedule_start_Date(Date schedule_start_Date) {
		this.schedule_start_Date = schedule_start_Date;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	@Override
	public String toString() {
		return "Enroll [enrol_id=" + enrol_id + ", title=" + title + ", enrol_waiting_rank=" + enrol_waiting_rank
				+ ", schedule_id=" + schedule_id + ", schedule_code=" + schedule_code + ", schedule_start_Date="
				+ schedule_start_Date + ", login_id=" + login_id + "]";
	}
	
	
	
}