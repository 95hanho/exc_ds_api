package me._hanho.ds.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import me._hanho.ds.model.CancelLog;
import me._hanho.ds.model.Enroll;
import me._hanho.ds.model.Popup;
import me._hanho.ds.model.Program;
import me._hanho.ds.model.ProgramCategory;
import me._hanho.ds.model.Review;
import me._hanho.ds.model.Schedule;
import me._hanho.ds.model.User;

@Mapper
public interface AdminMapper {

	ArrayList<Schedule> getAdminSchedules();
	Schedule getAdminSchedule(String schedule_code);
	Schedule getAdminSchedule2(int enroll_id);
	
	Schedule getScheduleLatest();
	
	void setSchedule(Schedule schedule);

	void updateSchedule(Schedule schedule);
	void updateProgramTime(Schedule schedule);

	int updateScheduleStatus(@Param("schedule_codes") List<String> schedule_codes);

	int updateScheduleOpenStatus(@Param("schedule_codes") List<String> schedule_codes);

	ArrayList<Enroll> getAdminStudents(String schedule_code);
	
	List<User> getStudents(@Param("schedule_codes") List<String> schedule_codes);
	List<User> getStudentsWithoutWait(@Param("schedule_codes") List<String> schedule_codes);

	int updatePresent(@Param("member_nos") List<String> member_nos, @Param("schedule_code") String schedule_code,
			@Param("type") String type, @Param("description") String description, @Param("msg") String msg);

	int getMember_no(int enroll_id);
	
	void deleteStudent(@Param("enroll_id") int enroll_id, @Param("member_no") int member_no);
	
	void deleteStudent2(@Param("schedule_code") String schedule_code, @Param("member_no") int member_no);
	
	void createCancelLog(CancelLog cancel_log);
	
	void createCancelLog2(@Param("enroll_id") int enroll_id, @Param("member_no") int member_no,
			@Param("login_id") String login_id, @Param("flag") String flag);
	
	void updateStudent(@Param("enroll_id") int enroll_id, @Param("member_no") int member_no);

	/* */
	
	List<User> userSearch(@Param("type") String type, @Param("keyword") String keyword);
	
	List<CancelLog> getLogs(int member_no);
	
	List<Enroll> getEnrolls(int member_no);
	
	void updateUser(User user);
	
	/* */
	
	ArrayList<ProgramCategory> getProgramCategory();
	ArrayList<Program> getPrograms2(int cate_num);
	
	Program getProgramLatest();
	
	void createProgram(Program program);
	int getLatestProgram();
	void updateProgramImgUrl(@Param("program_num") int program_num, @Param("fileUrl") String fileUrl);
	
	void updateProgram(Program program);
	
	void updateProgram_status(String program_code);
	
	/* */
	List<CancelLog> getCancels();
	
	List<Popup> getPopups();
	
	void updatePopup(@Param("file_status") Boolean file_status, @Param("type") int type);
	
	void createReview(Review review);
	
	
}
