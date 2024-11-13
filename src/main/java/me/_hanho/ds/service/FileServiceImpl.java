package me._hanho.ds.service;

import java.io.File;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.jsonwebtoken.io.IOException;
import me._hanho.ds.model.UploadFile;
import me._hanho.ds.repository.FileRepository;

@Service
public class FileServiceImpl implements FileService{

	@Value("${spring.servlet.multipart.location}")
    private String uploadDir;
	
	@Autowired
	private FileRepository fileDAO;
	
	@Override
	public int createFile(UploadFile inFile, MultipartFile file) {
		Boolean result = saveFile(file);
		if(result) {
			return fileDAO.createFile(inFile);
		} else {
			return 0;
		}
	}
	
	public boolean saveFile(MultipartFile file) throws IOException {
		// 파일명 설정
		String originalFileName = file.getOriginalFilename();
		String storedFileName = System.currentTimeMillis() + "_" + originalFileName;
		File dest = new File(storedFileName);
		
		// 파일 저장
		try {
			file.transferTo(dest);
		} catch (IllegalStateException | java.io.IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public ArrayList<UploadFile> getFiles(int id) {
		ArrayList<UploadFile> files = fileDAO.getFiles(id);
		
		files.stream().forEach(file -> {
			file.setUrl(uploadDir + "/" + file.getName());
		});
		
		return files;
	}

}
