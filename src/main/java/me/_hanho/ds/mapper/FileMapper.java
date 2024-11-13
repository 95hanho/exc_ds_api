package me._hanho.ds.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import me._hanho.ds.model.UploadFile;

@Mapper
public interface FileMapper {

	int createFile(UploadFile inFile);

	ArrayList<UploadFile> getFiles(int id);

}
