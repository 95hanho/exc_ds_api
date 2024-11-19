package me._hanho.ds.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int s_id;
	private String schedule_code;
	private Date create_at;
	private Date schedule_enrol_start_date;
	private Date schedule_enrol_end_date;
	private Date schedule_start_date;
	private Date schedule_start_date_add_date;
	private List<Date> schedule_after_date;
	private String schedule_after_date_JSON;
	private int time;
	private char online;
	private String part_type;
	private int enrol_limit;
	private int enrol_count;
	private int my_enrol_status;
	private Boolean schedule_status;
	private Boolean open_status;
	private int schedule_group_num;
	private int schedule_number;
	
	
	private int program_num;
	private String title;
	private String program_code;
	private String group_title;
	
	private int attendance_count;
	
	public Schedule() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Schedule(int s_id, String schedule_code, Date create_at, Date schedule_enrol_start_date,
			Date schedule_enrol_end_date, Date schedule_start_date, Date schedule_start_date_add_date,
			List<Date> schedule_after_date, String schedule_after_date_JSON, int time, char online, String part_type,
			int enrol_limit, int enrol_count, int my_enrol_status, Boolean schedule_status, Boolean open_status,
			int schedule_group_num, int schedule_number, int program_num, String title, String program_code,
			String group_title, int attendance_count) {
		super();
		this.s_id = s_id;
		this.schedule_code = schedule_code;
		this.create_at = create_at;
		this.schedule_enrol_start_date = schedule_enrol_start_date;
		this.schedule_enrol_end_date = schedule_enrol_end_date;
		this.schedule_start_date = schedule_start_date;
		this.schedule_start_date_add_date = schedule_start_date_add_date;
		this.schedule_after_date = schedule_after_date;
		this.schedule_after_date_JSON = schedule_after_date_JSON;
		this.time = time;
		this.online = online;
		this.part_type = part_type;
		this.enrol_limit = enrol_limit;
		this.enrol_count = enrol_count;
		this.my_enrol_status = my_enrol_status;
		this.schedule_status = schedule_status;
		this.open_status = open_status;
		this.schedule_group_num = schedule_group_num;
		this.schedule_number = schedule_number;
		this.program_num = program_num;
		this.title = title;
		this.program_code = program_code;
		this.group_title = group_title;
		this.attendance_count = attendance_count;
	}



	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getSchedule_code() {
		return schedule_code;
	}

	public void setSchedule_code(String schedule_code) {
		this.schedule_code = schedule_code;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public Date getSchedule_enrol_start_date() {
		return schedule_enrol_start_date;
	}

	public void setSchedule_enrol_start_date(Date schedule_enrol_start_date) {
		this.schedule_enrol_start_date = schedule_enrol_start_date;
	}

	public Date getSchedule_enrol_end_date() {
		return schedule_enrol_end_date;
	}

	public void setSchedule_enrol_end_date(Date schedule_enrol_end_date) {
		this.schedule_enrol_end_date = schedule_enrol_end_date;
	}

	public Date getSchedule_start_date() {
		return schedule_start_date;
	}

	public void setSchedule_start_date(Date schedule_start_date) {
		this.schedule_start_date = schedule_start_date;
	}

	public Date getSchedule_start_date_add_date() {
		return schedule_start_date_add_date;
	}

	public void setSchedule_start_date_add_date(Date schedule_start_date_add_date) {
		this.schedule_start_date_add_date = schedule_start_date_add_date;
	}

	public List<Date> getSchedule_after_date() {
		return schedule_after_date;
	}

	public void setSchedule_after_date(List<Date> schedule_after_date) {
		this.schedule_after_date = schedule_after_date;
	}

	public String getSchedule_after_date_JSON() {
		return schedule_after_date_JSON;
	}

	public void setSchedule_after_date_JSON(String schedule_after_date_JSON) {
		this.schedule_after_date_JSON = schedule_after_date_JSON;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public char getOnline() {
		return online;
	}

	public void setOnline(char online) {
		this.online = online;
	}

	public String getPart_type() {
		return part_type;
	}

	public void setPart_type(String part_type) {
		this.part_type = part_type;
	}

	public int getEnrol_limit() {
		return enrol_limit;
	}

	public void setEnrol_limit(int enrol_limit) {
		this.enrol_limit = enrol_limit;
	}

	public int getEnrol_count() {
		return enrol_count;
	}

	public void setEnrol_count(int enrol_count) {
		this.enrol_count = enrol_count;
	}

	public int getMy_enrol_status() {
		return my_enrol_status;
	}

	public void setMy_enrol_status(int my_enrol_status) {
		this.my_enrol_status = my_enrol_status;
	}

	public Boolean getSchedule_status() {
		return schedule_status;
	}

	public void setSchedule_status(Boolean schedule_status) {
		this.schedule_status = schedule_status;
	}
	
	

	public Boolean getOpen_status() {
		return open_status;
	}



	public void setOpen_status(Boolean open_status) {
		this.open_status = open_status;
	}



	public int getSchedule_group_num() {
		return schedule_group_num;
	}

	public void setSchedule_group_num(int schedule_group_num) {
		this.schedule_group_num = schedule_group_num;
	}

	public int getSchedule_number() {
		return schedule_number;
	}

	public void setSchedule_number(int schedule_number) {
		this.schedule_number = schedule_number;
	}

	public int getProgram_num() {
		return program_num;
	}

	public void setProgram_num(int program_num) {
		this.program_num = program_num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProgram_code() {
		return program_code;
	}

	public void setProgram_code(String program_code) {
		this.program_code = program_code;
	}

	public String getGroup_title() {
		return group_title;
	}

	public void setGroup_title(String group_title) {
		this.group_title = group_title;
	}

	public int getAttendance_count() {
		return attendance_count;
	}

	public void setAttendance_count(int attendance_count) {
		this.attendance_count = attendance_count;
	}



	@Override
	public String toString() {
		return "Schedule [s_id=" + s_id + ", schedule_code=" + schedule_code + ", create_at=" + create_at
				+ ", schedule_enrol_start_date=" + schedule_enrol_start_date + ", schedule_enrol_end_date="
				+ schedule_enrol_end_date + ", schedule_start_date=" + schedule_start_date
				+ ", schedule_start_date_add_date=" + schedule_start_date_add_date + ", schedule_after_date="
				+ schedule_after_date + ", schedule_after_date_JSON=" + schedule_after_date_JSON + ", time=" + time
				+ ", online=" + online + ", part_type=" + part_type + ", enrol_limit=" + enrol_limit + ", enrol_count="
				+ enrol_count + ", my_enrol_status=" + my_enrol_status + ", schedule_status=" + schedule_status
				+ ", open_status=" + open_status + ", schedule_group_num=" + schedule_group_num + ", schedule_number="
				+ schedule_number + ", program_num=" + program_num + ", title=" + title + ", program_code="
				+ program_code + ", group_title=" + group_title + ", attendance_count=" + attendance_count + "]";
	}
	
}
