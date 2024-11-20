package me._hanho.ds.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import me._hanho.ds.model.Program;
import me._hanho.ds.model.UploadFile;

public interface FileService {

	int createNoticeFile(UploadFile inFile, MultipartFile file);
	
	int deleteFile(int id, UploadFile uploadFile, String type);

	ArrayList<UploadFile> getFiles(int id, String type);

	void createProgramFile(int programe_num, MultipartFile file);

}
