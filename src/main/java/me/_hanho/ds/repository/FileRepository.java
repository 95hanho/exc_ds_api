package me._hanho.ds.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me._hanho.ds.mapper.FileMapper;
import me._hanho.ds.model.UploadFile;

@Repository
public class FileRepository {

	@Autowired
	private FileMapper fileMapper;
	
	public int createFile(UploadFile inFile) {
		return fileMapper.createFile(inFile);
	}

	public ArrayList<UploadFile> getFiles(int id) {
		return fileMapper.getFiles(id);
	}

}
