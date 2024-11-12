package me._hanho.ds.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/bbs/notice")
public class NoticeController {

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
	public ResponseEntity<Map<String, Object>> addQna() {
		System.out.println("addQna");
		Map<String, Object> result = new HashMap<String, Object>();
		return new ResponseEntity<>(result, HttpStatus.OK);
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
