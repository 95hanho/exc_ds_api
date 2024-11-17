package me._hanho.ds.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cancel_log")
public class CancelLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String reason;
	private Date created_at;
	
	private String schedule_code;
	private String login_id;
	
	public CancelLog() {
		// TODO Auto-generated constructor stub
	}

	public CancelLog(int id, String reason, Date created_at, String schedule_code, String login_id) {
		super();
		this.id = id;
		this.reason = reason;
		this.created_at = created_at;
		this.schedule_code = schedule_code;
		this.login_id = login_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getSchedule_code() {
		return schedule_code;
	}

	public void setSchedule_code(String schedule_code) {
		this.schedule_code = schedule_code;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	@Override
	public String toString() {
		return "CancelLog [id=" + id + ", reason=" + reason + ", schedule_code=" + schedule_code + ", login_id="
				+ login_id + "]";
	}
}
