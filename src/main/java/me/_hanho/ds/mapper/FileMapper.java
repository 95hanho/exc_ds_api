package me._hanho.ds.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import me._hanho.ds.model.UploadFile;

@Mapper
public interface FileMapper {

	int createNoticeFile(UploadFile inFile);
	
	int createProgramFile(UploadFile inFile);
	
	int createPopupFile(UploadFile inFile);

	int updateNoticeFile(UploadFile inFile);
	
	int updateProgramFile(UploadFile inFile);
	
	int updatePopupFile(UploadFile inFile);

	int deleteNoticeFile(int id);
	
	int deleteProgramFile(int id);
	
	int deletePopupFile(int id);

	ArrayList<UploadFile> getNoticeFiles(int id);

	ArrayList<UploadFile> getProgramFiles(int id);

	ArrayList<UploadFile> getPopupFiles(int id);

	UploadFile selectLatestFile();

	List<String> getMainPopups();

}
