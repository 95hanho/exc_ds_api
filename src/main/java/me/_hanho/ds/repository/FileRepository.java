package me._hanho.ds.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me._hanho.ds.mapper.FileMapper;
import me._hanho.ds.model.UploadFile;

@Repository
public class FileRepository {

	@Autowired
	private FileMapper fileMapper;
	
	public int createFile(UploadFile inFile, String type) {
		if(type.equals("notice")) {
			return fileMapper.createNoticeFile(inFile);
		} else if(type.equals("program")) {
			return fileMapper.createProgramFile(inFile);
		} else if(type.equals("popup")) {
			return fileMapper.createPopupFile(inFile);
		}
		return 0;
	}
	
	public int updateFile(UploadFile inFile, String type) {
		if(type.equals("notice")) {
			return fileMapper.updateNoticeFile(inFile);
		} else if(type.equals("program")) {
			return fileMapper.updateProgramFile(inFile);
		} else if(type.equals("popup")) {
			return fileMapper.updatePopupFile(inFile);
		}
		return 0;
	}
	
	public int deleteFile(int id, String type) {
		if(type.equals("notice")) {
			return fileMapper.deleteNoticeFile(id);
		} else if(type.equals("program")) {
			return fileMapper.deleteProgramFile(id);
		} else if(type.equals("popup")) {
			return fileMapper.deletePopupFile(id);
		}
		return 0;
	}

	public ArrayList<UploadFile> getFiles(int id, String type) {
		if(type.equals("notice")) {
			return fileMapper.getNoticeFiles(id);
		} else if(type.equals("program")) {
			return fileMapper.getProgramFiles(id);
		} else if(type.equals("popup")) {
			return fileMapper.getPopupFiles(id);
		}
		return null;
	}

	public List<String> getMainPopups() {
		return fileMapper.getMainPopups();
	}


}
