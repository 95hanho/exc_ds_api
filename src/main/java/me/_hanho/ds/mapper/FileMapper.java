package me._hanho.ds.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import me._hanho.ds.model.UploadFile;

@Mapper
public interface FileMapper {

	int createFile(UploadFile inFile);

	int updateFile(UploadFile inFile);

	int deleteFile(int id);

	ArrayList<UploadFile> getFiles(int id);

}
