package me._hanho.ds.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import me._hanho.ds.model.Comment;
import me._hanho.ds.model.Notice;
import me._hanho.ds.model.UploadFile;
import me._hanho.ds.model.User;
import me._hanho.ds.service.FileService;
import me._hanho.ds.service.NoticeService;
import me._hanho.ds.service.UserService;

@RestController
@RequestMapping("/v1/bbs/notice")
public class NoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private UserService userService;
	@Autowired
	private FileService fileService;

	// 공지QnA 리스트가져오기
	@GetMapping("/list")
	public ResponseEntity<Map<String, Object>> getNotices(@RequestParam("page") int page
			, @RequestParam("size") int size) {
		logger.info("getNotices");
		Map<String, Object> result = new HashMap<String, Object>();
		
		int notice_count = noticeService.getNoticeCount();
		int max_page = notice_count / size + 1;
		int offset = (page - 1) * size;
		if(max_page >= page) {
			List<Notice> noticeList = noticeService.getNotices(size, offset);
			
			Map<String, Object> dataResult = new HashMap<String, Object>();
			
			dataResult.put("list", noticeList);
			dataResult.put("page_list_size", size);
			dataResult.put("this_page", page);
			dataResult.put("total_pages", max_page);
			dataResult.put("total_record", notice_count);
			result.put("data", dataResult);
			result.put("msg", "success");
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}

	}
	// 공지QnA 상세조회
	@GetMapping("/detail/{id}")
	public ResponseEntity<Map<String, Object>> getNotice(@PathVariable("id") int id) {
		logger.info("getNotice");
		Map<String, Object> result = new HashMap<String, Object>();
		
		Notice notice = noticeService.getNotice(id);
		
		if(notice != null) {
			ArrayList<Comment> comment_list = noticeService.getComments(id);
			notice.setComment_list(comment_list);
			ArrayList<UploadFile> file_list = fileService.getFiles(id, "notice");
			notice.setFile_list(file_list);
			result.put("data", notice);
			result.put("msg", "success");
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			result.put("msg", "없음");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
	}
	// 공지QnA 작성
	@PostMapping("/write")
	public ResponseEntity<Map<String, Object>> addQna(@ModelAttribute Notice notice
			, @RequestAttribute("login_id") String login_id) {
		logger.info("addQna");
		Map<String, Object> result = new HashMap<String, Object>();
		
		User user = userService.getUser(login_id);
		notice.setWriter_login_id(login_id);
		notice.setWriter(user.getName());
		if(user.getGrant() == 90) {
			notice.setType("G");
			notice.setTop(1);
		} else {
			notice.setType("N");
			notice.setTop(0);
		}
		
		int create_count = noticeService.createNotice(notice);
		
		Notice resultNotice = noticeService.getNotice();
		
		if(create_count > 0) {
			result.put("msg", "success");
			result.put("data", resultNotice);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			result.put("msg", "fail");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	// 공지QnA 수정
	@PutMapping("/write")
	public ResponseEntity<Map<String, Object>> updateNoticeQna(@ModelAttribute Notice notice
			, @RequestAttribute("login_id") String login_id) {
		logger.info("updateNoticeQna");
		Map<String, Object> result = new HashMap<String, Object>();
		
		User user = userService.getUser(login_id);
		notice.setWriter_login_id(login_id);
		notice.setWriter(user.getName());
		if(user.getGrant() == 90) {
			notice.setType("G");
			notice.setTop(1);
		} else {
			notice.setType("N");
			notice.setTop(0);
		}
		int update_count = noticeService.updateNotice(notice);
		
		Notice curNotice = noticeService.getNotice(notice.getId());
		
		if(update_count > 0) {
			result.put("data", curNotice);
			result.put("msg", "success");
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			result.put("msg", "fail");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	// 공지QnA 삭제
	@DeleteMapping("/write/{id}")
	public ResponseEntity<Map<String, Object>> deleteNoticeQna(@PathVariable("id") int id) {
		logger.info("deleteNoticeQna");
		Map<String, Object> result = new HashMap<String, Object>();
		
		int delete_result = noticeService.deleteNotice(id);
		
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 공지QnA 파일업로드
	@PostMapping("/file")
	public ResponseEntity<Map<String, Object>> noticeFileUpload(@RequestParam(value="file", required=false) MultipartFile file
			, @RequestParam("id") int id) {
		logger.info("noticeFileUpload");
		Map<String, Object> result = new HashMap<String, Object>();
		
		UploadFile inFile = new UploadFile();
		inFile.setName(file.getOriginalFilename());
		inFile.setNotice_id(id);
		
		int file_result = fileService.createNoticeFile(inFile, file);
		
		if(file_result > 0) {
			result.put("msg", "success");
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			result.put("msg", "fail");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
	// 공지QnA 파일삭제요청
	@DeleteMapping("/file/{id}")
	public ResponseEntity<Map<String, Object>> noticeFileDelete(@PathVariable("id") int id) {
		logger.info("noticeFileDelete");
		Map<String, Object> result = new HashMap<String, Object>();
		
		ArrayList<UploadFile> file_list = fileService.getFiles(id, "notice");
		
		int delete_result = fileService.deleteFile(id, file_list.get(0), "notice");
		
		if(delete_result > 0) {
			result.put("msg", "success");
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			result.put("msg", "fail");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
	}
	// 공지/QnA 조회수
	@PutMapping("/detail/count/{id}")
	public ResponseEntity<Map<String, Object>> noticeQnaUpHit(@PathVariable("id") int id) {
		logger.info("noticeQnaUpHit");
		Map<String, Object> result = new HashMap<String, Object>();
		
		int hit_result = noticeService.noticeUpHit(id);

		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 답글작성
	@PostMapping("/comment/write")
	public ResponseEntity<Map<String, Object>> createQnaComment(@ModelAttribute Comment comment
			, @RequestAttribute("login_id") String login_id) {
		logger.info("createQnaComment");
		Map<String, Object> result = new HashMap<String, Object>();
		
		User user = userService.getUser(login_id);
		comment.setNotice_id(comment.getId());
		comment.setWriter(user.getName());
		comment.setWriter_login_id(login_id);
		int create_result = noticeService.createComment(comment);
		
		Comment res_comment = noticeService.getComment();
		noticeService.updateNoticeManagerLatest(res_comment.getNotice_id(), user.getGrant() == 90);
		
		result.put("data", res_comment);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 답글수정
	@PutMapping("/comment/write")
	public ResponseEntity<Map<String, Object>> updateQnaComment(@ModelAttribute Comment comment) {
		logger.info("updateQnaComment");
		Map<String, Object> result = new HashMap<String, Object>();
		
		int update_result = noticeService.updateComment(comment);
		
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 답글 삭제
	@DeleteMapping("/comment/write/{id}")
	public ResponseEntity<Map<String, Object>> deleteQnaComment(@PathVariable("id") int id) {
		logger.info("deleteQnaComment");
		Map<String, Object> result = new HashMap<String, Object>();
		
		int delete_result = noticeService.deleteComment(id);
		
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
