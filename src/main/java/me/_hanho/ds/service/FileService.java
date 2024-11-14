package me._hanho.ds.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import me._hanho.ds.model.UploadFile;

public interface FileService {

	int createFile(UploadFile inFile, MultipartFile file);
	
	int deleteFile(int id, UploadFile uploadFile);

	ArrayList<UploadFile> getFiles(int id);

}
