package me._hanho.ds.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	private String login_id;
	private String login_pwd;
	private int grant; // 90
	private String insa; // 관리자1
	private String name; // 관리자1
	private int type; // 3
	private String member_email;
	private String member_login_id;
	private String member_name;
	private String member_hp;
	private String member_insa_number;
	private int member_no;
	private String member_type;
	private String team_name;
	
	private int schedule_number;
	private Date schedule_start_date;
	
	private String program_name;
	
	private Date created_at;
	private String attendance_msg;
	private String attendance_description;
	
	public User() {}
	
	public User(String login_id, int grant, String insa, String name, int type) {
		super();
		this.login_id = login_id;
		this.grant = grant;
		this.insa = insa;
		this.name = name;
		this.type = type;
	}

	public User(String login_id, String login_pwd, int grant, String insa, String name, int type) {
		super();
		this.login_id = login_id;
		this.login_pwd = login_pwd;
		this.grant = grant;
		this.insa = insa;
		this.name = name;
		this.type = type;
	}

	public User(String login_id, String login_pwd, int grant, String insa, String name, int type,
			String member_login_id, String member_name, String member_hp, String member_insa_number, int member_no,
			String member_type, String team_name) {
		super();
		this.login_id = login_id;
		this.login_pwd = login_pwd;
		this.grant = grant;
		this.insa = insa;
		this.name = name;
		this.type = type;
		this.member_login_id = member_login_id;
		this.member_name = member_name;
		this.member_hp = member_hp;
		this.member_insa_number = member_insa_number;
		this.member_no = member_no;
		this.member_type = member_type;
		this.team_name = team_name;
	}
	
	public User(String login_id, String login_pwd, int grant, String insa, String name, int type,
			String member_login_id, String member_name, String member_hp, String member_insa_number, int member_no,
			String member_type, String team_name, int schedule_number, Date schedule_start_date, String program_name,
			Date created_at, String attendance_msg, String attendance_description) {
		super();
		this.login_id = login_id;
		this.login_pwd = login_pwd;
		this.grant = grant;
		this.insa = insa;
		this.name = name;
		this.type = type;
		this.member_login_id = member_login_id;
		this.member_name = member_name;
		this.member_hp = member_hp;
		this.member_insa_number = member_insa_number;
		this.member_no = member_no;
		this.member_type = member_type;
		this.team_name = team_name;
		this.schedule_number = schedule_number;
		this.schedule_start_date = schedule_start_date;
		this.program_name = program_name;
		this.created_at = created_at;
		this.attendance_msg = attendance_msg;
		this.attendance_description = attendance_description;
	}
	
	public User(String login_id, String login_pwd, int grant, String insa, String name, int type, String member_email,
			String member_login_id, String member_name, String member_hp, String member_insa_number, int member_no,
			String member_type, String team_name, int schedule_number, Date schedule_start_date, String program_name,
			Date created_at, String attendance_msg, String attendance_description) {
		super();
		this.login_id = login_id;
		this.login_pwd = login_pwd;
		this.grant = grant;
		this.insa = insa;
		this.name = name;
		this.type = type;
		this.member_email = member_email;
		this.member_login_id = member_login_id;
		this.member_name = member_name;
		this.member_hp = member_hp;
		this.member_insa_number = member_insa_number;
		this.member_no = member_no;
		this.member_type = member_type;
		this.team_name = team_name;
		this.schedule_number = schedule_number;
		this.schedule_start_date = schedule_start_date;
		this.program_name = program_name;
		this.created_at = created_at;
		this.attendance_msg = attendance_msg;
		this.attendance_description = attendance_description;
	}

	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getLogin_pwd() {
		return login_pwd;
	}
	public void setLogin_pwd(String login_pwd) {
		this.login_pwd = login_pwd;
	}
	public int getGrant() {
		return grant;
	}
	public void setGrant(int grant) {
		this.grant = grant;
	}
	public String getInsa() {
		return insa;
	}
	public void setInsa(String insa) {
		this.insa = insa;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
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

	
	public String getMember_login_id() {
		return member_login_id;
	}

	public void setMember_login_id(String member_login_id) {
		this.member_login_id = member_login_id;
	}
	
	public int getSchedule_number() {
		return schedule_number;
	}

	public void setSchedule_number(int schedule_number) {
		this.schedule_number = schedule_number;
	}

	public Date getSchedule_start_date() {
		return schedule_start_date;
	}

	public void setSchedule_start_date(Date schedule_start_date) {
		this.schedule_start_date = schedule_start_date;
	}

	public String getProgram_name() {
		return program_name;
	}

	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
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
	
	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	@Override
	public String toString() {
		return "User [login_id=" + login_id + ", login_pwd=" + login_pwd + ", grant=" + grant + ", insa=" + insa
				+ ", name=" + name + ", type=" + type + ", member_email=" + member_email + ", member_login_id="
				+ member_login_id + ", member_name=" + member_name + ", member_hp=" + member_hp
				+ ", member_insa_number=" + member_insa_number + ", member_no=" + member_no + ", member_type="
				+ member_type + ", team_name=" + team_name + ", schedule_number=" + schedule_number
				+ ", schedule_start_date=" + schedule_start_date + ", program_name=" + program_name + ", created_at="
				+ created_at + ", attendance_msg=" + attendance_msg + ", attendance_description="
				+ attendance_description + "]";
	}
	
}
