package me._hanho.ds.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me._hanho.ds.model.Notice;
import me._hanho.ds.model.User;
import me._hanho.ds.service.NoticeService;
import me._hanho.ds.service.UserService;

@RestController
@RequestMapping("/v1/bbs/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private UserService userService;

	// 공지QnA 리스트가져오기
	@GetMapping("/list")
	public ResponseEntity<Map<String, Object>> getNotices() {
		System.out.println("getNotices");
		Map<String, Object> result = new HashMap<String, Object>();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 공지QnA 상세조회
	@GetMapping("/detail/{id}")
	public ResponseEntity<Map<String, Object>> getNotice() {
		System.out.println("getNotice");
		Map<String, Object> result = new HashMap<String, Object>();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 공지QnA 작성
	@PostMapping("/write")
	public ResponseEntity<Map<String, Object>> addQna(@ModelAttribute Notice notice
			, @RequestAttribute("login_id") String login_id) {
		System.out.println("addQna");
		Map<String, Object> result = new HashMap<String, Object>();
		
		System.out.println(notice);
		User user = userService.getUser(login_id);
		notice.setWriter_login_id(login_id);
		notice.setWriter(user.getName());
		if(notice.getSecret() == null) {
			notice.setType("G");
			notice.setTop(1);
		} else {
			notice.setType("N");
			notice.setTop(0);
		}
		
		int create_count = noticeService.createNotice(notice);
		
		System.out.println(create_count);
		
		Notice resultNotice = noticeService.getNotice();
		
		System.out.println(resultNotice);
		
		if(create_count > 0) {
			result.put("msg", "success");
			result.put("data", resultNotice);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			result.put("msg", "fail");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
	}
	// 공지QnA 파일업로드
	@PostMapping("/file")
	public ResponseEntity<Map<String, Object>> noticeFileUpload() {
		System.out.println("noticeFileUpload");
		Map<String, Object> result = new HashMap<String, Object>();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 공지QnA 수정
	@PutMapping("/write")
	public ResponseEntity<Map<String, Object>> updateNoticeQna() {
		System.out.println("updateNoticeQna");
		Map<String, Object> result = new HashMap<String, Object>();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 공지QnA 파일삭제요청
	@DeleteMapping("/file/{id}")
	public ResponseEntity<Map<String, Object>> noticeFileDelete() {
		System.out.println("noticeFileDelete");
		Map<String, Object> result = new HashMap<String, Object>();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 공지QnA 삭제
	@DeleteMapping("/write/{id}")
	public ResponseEntity<Map<String, Object>> deleteNoticeQna() {
		System.out.println("deleteNoticeQna");
		Map<String, Object> result = new HashMap<String, Object>();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 공지QnA 조회수
	@DeleteMapping("/detail/count/{id}")
	public ResponseEntity<Map<String, Object>> noticeQnaUpHit() {
		System.out.println("noticeQnaUpHit");
		Map<String, Object> result = new HashMap<String, Object>();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 답글작성
	@PostMapping("/comment/write")
	public ResponseEntity<Map<String, Object>> createQnaComment() {
		System.out.println("createQnaComment");
		Map<String, Object> result = new HashMap<String, Object>();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 답글수정
	@PutMapping("/comment/write")
	public ResponseEntity<Map<String, Object>> updateQnaComment() {
		System.out.println("updateQnaComment");
		Map<String, Object> result = new HashMap<String, Object>();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	// 답글 삭제
	@DeleteMapping("/comment/write/{id}")
	public ResponseEntity<Map<String, Object>> deleteQnaComment() {
		System.out.println("deleteQnaComment");
		Map<String, Object> result = new HashMap<String, Object>();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
