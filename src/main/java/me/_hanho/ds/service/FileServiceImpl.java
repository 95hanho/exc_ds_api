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
		// 파일명 설정
		String originalFileName = file.getOriginalFilename();
		String storedFileName = System.currentTimeMillis() + "_" + originalFileName;
		inFile.setFileName(storedFileName);
		Boolean result = true;
		
		ArrayList<UploadFile> file_list = getFiles(inFile.getNotice_id());
		if(file_list.size() > 0) {
			result = deleteFile(file_list.get(0).getFileName());
			Boolean result2 = saveFile(file, storedFileName);
			if(result && result2) {
				return fileDAO.updateFile(inFile);
			}
		} else {
			result = saveFile(file, storedFileName);
			if(result) {
				return fileDAO.createFile(inFile);
			}
		}
		
		return 0;
		
	}
	
	@Override
	public ArrayList<UploadFile> getFiles(int id) {
		ArrayList<UploadFile> files = fileDAO.getFiles(id);
		
		files.stream().forEach(file -> {
			file.setUrl(uploadDir + "/" + file.getName());
		});
		
		return files;
	}
	
	@Override
	public int deleteFile(int id, UploadFile file) {
		Boolean delete_result = deleteFile(file.getFileName());
		if(delete_result) {
			return fileDAO.deleteFile(id);
		} return 0;
	}
	
	public boolean saveFile(MultipartFile file, String storedFileName) throws IOException {
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
	
	public boolean deleteFile(String fileName) throws IOException {
		String filePath = uploadDir + "/" + fileName;
		File file = new File(filePath);

        // 파일 존재 여부 확인
        if (file.exists()) {
            // 파일 삭제
            boolean deleted = file.delete();
            if (deleted) {
                System.out.println("파일 삭제 성공: " + filePath);
            } else {
                System.out.println("파일 삭제 실패: " + filePath);
            }
            return deleted;
        } else {
            System.out.println("파일이 존재하지 않습니다: " + filePath);
            return false;
        }
	}





}
