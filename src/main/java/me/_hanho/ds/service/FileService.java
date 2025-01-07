package me._hanho.ds.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import me._hanho.ds.model.UploadFile;

public interface FileService {

	int createNoticeFile(UploadFile inFile, MultipartFile file);
	
	void createProgramFile(int programe_num, MultipartFile file);

	void createPopupFile(MultipartFile file, int type);
	
	int deleteFile(int id, UploadFile uploadFile, String type);

	ArrayList<UploadFile> getFiles(int id, String type);

	List<String> getMainPopups();
}
