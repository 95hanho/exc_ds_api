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
	private int enrol_rank;
	private int enrol_waiting_rank;
	private Date enrol_regdate;
	private Boolean enrol_waiting_status;
	private String attendance_type;
	private String attendance_msg;
	private String attendance_description;
	
	private int schedule_id;
	private String schedule_code;
	private Date schedule_start_Date;
	
	private String login_id;
	private String member_login_id;
	private String member_name;
	private String member_email;
	private String member_hp;
	private String member_insa_number;
	private int member_no;
	private String member_type;
	private String team_name;
	
	private String title;
	
	
	public Enroll() {
		// TODO Auto-generated constructor stub
	}

	

	public Enroll(int enrol_id, int enrol_rank, int enrol_waiting_rank, Date enrol_regdate,
			Boolean enrol_waiting_status, String attendance_type, String attendance_msg, String attendance_description,
			int schedule_id, String schedule_code, Date schedule_start_Date, String login_id, String member_login_id,
			String member_name, String member_email, String member_hp, String member_insa_number, int member_no,
			String member_type, String team_name, String title) {
		super();
		this.enrol_id = enrol_id;
		this.enrol_rank = enrol_rank;
		this.enrol_waiting_rank = enrol_waiting_rank;
		this.enrol_regdate = enrol_regdate;
		this.enrol_waiting_status = enrol_waiting_status;
		this.attendance_type = attendance_type;
		this.attendance_msg = attendance_msg;
		this.attendance_description = attendance_description;
		this.schedule_id = schedule_id;
		this.schedule_code = schedule_code;
		this.schedule_start_Date = schedule_start_Date;
		this.login_id = login_id;
		this.member_login_id = member_login_id;
		this.member_name = member_name;
		this.member_email = member_email;
		this.member_hp = member_hp;
		this.member_insa_number = member_insa_number;
		this.member_no = member_no;
		this.member_type = member_type;
		this.team_name = team_name;
		this.title = title;
	}



	public int getEnrol_id() {
		return enrol_id;
	}


	public void setEnrol_id(int enrol_id) {
		this.enrol_id = enrol_id;
	}
	
	


	public int getEnrol_rank() {
		return enrol_rank;
	}



	public void setEnrol_rank(int enrol_rank) {
		this.enrol_rank = enrol_rank;
	}



	public int getEnrol_waiting_rank() {
		return enrol_waiting_rank;
	}


	public void setEnrol_waiting_rank(int enrol_waiting_rank) {
		this.enrol_waiting_rank = enrol_waiting_rank;
	}


	public Date getEnrol_regdate() {
		return enrol_regdate;
	}


	public void setEnrol_regdate(Date enrol_regdate) {
		this.enrol_regdate = enrol_regdate;
	}


	public Boolean getEnrol_waiting_status() {
		return enrol_waiting_status;
	}


	public void setEnrol_waiting_status(Boolean enrol_waiting_status) {
		this.enrol_waiting_status = enrol_waiting_status;
	}


	public String getAttendance_type() {
		return attendance_type;
	}


	public void setAttendance_type(String attendance_type) {
		this.attendance_type = attendance_type;
	}


	public String getAttendance_msg() {
		return attendance_msg;
	}


	public void setAttendance_msg(String attendance_msg) {
		this.attendance_msg = attendance_msg;
	}


	public String getAttendance_description() {
		return attendance_description;
	}


	public void setAttendance_description(String attendance_description) {
		this.attendance_description = attendance_description;
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


	public String getMember_login_id() {
		return member_login_id;
	}


	public void setMember_login_id(String member_login_id) {
		this.member_login_id = member_login_id;
	}


	public String getMember_name() {
		return member_name;
	}


	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}


	public String getMember_email() {
		return member_email;
	}


	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}


	public String getMember_hp() {
		return member_hp;
	}


	public void setMember_hp(String member_hp) {
		this.member_hp = member_hp;
	}


	public String getMember_insa_number() {
		return member_insa_number;
	}


	public void setMember_insa_number(String member_insa_number) {
		this.member_insa_number = member_insa_number;
	}


	public int getMember_no() {
		return member_no;
	}


	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}


	public String getMember_type() {
		return member_type;
	}


	public void setMember_type(String member_type) {
		this.member_type = member_type;
	}


	public String getTeam_name() {
		return team_name;
	}


	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Enroll [enrol_id=" + enrol_id + ", enrol_rank=" + enrol_rank + ", enrol_waiting_rank="
				+ enrol_waiting_rank + ", enrol_regdate=" + enrol_regdate + ", enrol_waiting_status="
				+ enrol_waiting_status + ", attendance_type=" + attendance_type + ", attendance_msg=" + attendance_msg
				+ ", attendance_description=" + attendance_description + ", schedule_id=" + schedule_id
				+ ", schedule_code=" + schedule_code + ", schedule_start_Date=" + schedule_start_Date + ", login_id="
				+ login_id + ", member_login_id=" + member_login_id + ", member_name=" + member_name + ", member_email="
				+ member_email + ", member_hp=" + member_hp + ", member_insa_number=" + member_insa_number
				+ ", member_no=" + member_no + ", member_type=" + member_type + ", team_name=" + team_name + ", title="
				+ title + "]";
	}


}