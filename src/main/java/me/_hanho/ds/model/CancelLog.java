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
	private String cancel_msg;
	private Date created_at;
	private Date change_date;
	private String flag;
	
	private String schedule_code;
	private String program_name;
	private String title;
	private int schedule_index;
	private Date schedule_start_Date;
	
	private String login_id;
	private int member_no;
	private String executor;
	
	public CancelLog() {
		// TODO Auto-generated constructor stub
	}
	
	public CancelLog(String reason, String flag, String schedule_code, String login_id) {
		super();
		this.reason = reason;
		this.flag = flag;
		this.schedule_code = schedule_code;
		this.login_id = login_id;
	}

	public CancelLog(int id, String reason, String cancel_msg, Date created_at, Date change_date, String flag,
			String schedule_code, String program_name, int schedule_index, Date schedule_start_Date, String login_id,
			int member_no, String executor) {
		super();
		this.id = id;
		this.reason = reason;
		this.cancel_msg = cancel_msg;
		this.created_at = created_at;
		this.change_date = change_date;
		this.flag = flag;
		this.schedule_code = schedule_code;
		this.program_name = program_name;
		this.schedule_index = schedule_index;
		this.schedule_start_Date = schedule_start_Date;
		this.login_id = login_id;
		this.member_no = member_no;
		this.executor = executor;
	}

	public CancelLog(int id, String reason, String cancel_msg, Date created_at, Date change_date, String flag,
			String schedule_code, String program_name, String title, int schedule_index, Date schedule_start_Date,
			String login_id, int member_no, String executor) {
		super();
		this.id = id;
		this.reason = reason;
		this.cancel_msg = cancel_msg;
		this.created_at = created_at;
		this.change_date = change_date;
		this.flag = flag;
		this.schedule_code = schedule_code;
		this.program_name = program_name;
		this.title = title;
		this.schedule_index = schedule_index;
		this.schedule_start_Date = schedule_start_Date;
		this.login_id = login_id;
		this.member_no = member_no;
		this.executor = executor;
	}
	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getCancel_msg() {
		return cancel_msg;
	}

	public void setCancel_msg(String cancel_msg) {
		this.cancel_msg = cancel_msg;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getChange_date() {
		return change_date;
	}

	public void setChange_date(Date change_date) {
		this.change_date = change_date;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getSchedule_code() {
		return schedule_code;
	}

	public void setSchedule_code(String schedule_code) {
		this.schedule_code = schedule_code;
	}

	public String getProgram_name() {
		return program_name;
	}

	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}

	public int getSchedule_index() {
		return schedule_index;
	}

	public void setSchedule_index(int schedule_index) {
		this.schedule_index = schedule_index;
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

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getExecutor() {
		return executor;
	}

	public void setExecutor(String executor) {
		this.executor = executor;
	}

	@Override
	public String toString() {
		return "CancelLog [id=" + id + ", reason=" + reason + ", cancel_msg=" + cancel_msg + ", created_at="
				+ created_at + ", change_date=" + change_date + ", flag=" + flag + ", schedule_code=" + schedule_code
				+ ", program_name=" + program_name + ", title=" + title + ", schedule_index=" + schedule_index
				+ ", schedule_start_Date=" + schedule_start_Date + ", login_id=" + login_id + ", member_no=" + member_no
				+ ", executor=" + executor + "]";
	}
	
}
