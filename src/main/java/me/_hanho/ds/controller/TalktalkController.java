package me._hanho.ds.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import me._hanho.ds.model.Comment;
import me._hanho.ds.model.Notice;
import me._hanho.ds.model.Talktalk;
import me._hanho.ds.model.UploadFile;
import me._hanho.ds.model.User;
import me._hanho.ds.service.TalktalkService;
import me._hanho.ds.service.UserService;


@RestController
@RequestMapping("/v1/bbs/talk")
public class TalktalkController {
	
	@Autowired
	private TalktalkService talktalkService;
	
	@Autowired
	private UserService userService;

	// 톡톡 리스트가져오기
    @GetMapping("/list")
	public ResponseEntity<Map<String, Object>> getTalks(@RequestParam("page") int page
			, @RequestParam("size") int size, @RequestParam(value = "program_code", required = false) String program_code) {
		System.out.println("getTalks/" + page + "/" + size + "/" + program_code);
		Map<String, Object> result = new HashMap<String, Object>();
		
		int notice_count = talktalkService.getTalktalkCount();
		int max_page = notice_count / size + 1;
		int offset = (page - 1) * size;
		if(max_page >= page) {
			List<Talktalk> noticeList = talktalkService.getTalktalks(size, offset, program_code);
			
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
	    
	// 톡톡 상세조회
    @GetMapping("/detail/{id}")
	public ResponseEntity<Map<String, Object>> getTalk(@PathVariable("id") int id) {
		System.out.println("getTalk");
		Map<String, Object> result = new HashMap<String, Object>();
		
		Talktalk talktalk = talktalkService.getTalktalk(id);
		
		System.out.println(talktalk);
		
		if(talktalk != null) {
			ArrayList<Comment> comment_list = talktalkService.getComments(id);
			talktalk.setComment_list(comment_list);
			result.put("data", talktalk);
			result.put("msg", "success");
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			result.put("msg", "없음");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
	}
    
	// 톡톡 작성
    @PostMapping("/write")
   	public ResponseEntity<Map<String, Object>> setTalk(@ModelAttribute Talktalk talktalk
			, @RequestAttribute("login_id") String login_id) {
   		System.out.println("setTalk");
   		Map<String, Object> result = new HashMap<String, Object>();
   		
   		System.out.println(talktalk);
		User user = userService.getUser(login_id);
		talktalk.setWriter_login_id(login_id);
		talktalk.setWriter(user.getName());
		
		int create_count = talktalkService.createTalktalk(talktalk);
		
		Talktalk resultNotice = talktalkService.getTalktalk();
		
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
    
	// 톡톡 수정
    @PutMapping("/write")
   	public ResponseEntity<Map<String, Object>> updateTalk(@ModelAttribute Talktalk talktalk
			, @RequestAttribute("login_id") String login_id) {
   		System.out.println("updateTalk");
   		Map<String, Object> result = new HashMap<String, Object>();
   		
   		User user = userService.getUser(login_id);
   		talktalk.setWriter_login_id(login_id);
   		talktalk.setWriter(user.getName());
		System.out.println(talktalk);
		
		int update_count = talktalkService.updateTalktalk(talktalk);
		
		Talktalk curTalktalk = talktalkService.getTalktalk(talktalk.getId());
		
		if(update_count > 0) {
			result.put("data", curTalktalk);
			result.put("msg", "success");
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			result.put("msg", "fail");
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
   	}
	// 톡톡 삭제
    @DeleteMapping("/write/{id}")
   	public ResponseEntity<Map<String, Object>> delete_normal(@PathVariable("id") int id) {
   		System.out.println("delete_normal");
   		Map<String, Object> result = new HashMap<String, Object>();
   		
   		int delete_result = talktalkService.deleteTalktalk(id);
		
		System.out.println(delete_result);
		
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
   	}
	// 톡톡 조회수
    @PutMapping("/detail/count/{id}")
   	public ResponseEntity<Map<String, Object>> talkUpHit(@PathVariable("id") int id) {
   		System.out.println("talkUpHit");
   		Map<String, Object> result = new HashMap<String, Object>();
   		
   		int hit_result = talktalkService.talktalkUpHit(id);

		System.out.println(hit_result);
		
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
   	}
	// 댓글작성
    @PostMapping("/comment/write")
   	public ResponseEntity<Map<String, Object>> createTalkComment(@ModelAttribute Comment comment
			, @RequestAttribute("login_id") String login_id) {
   		System.out.println("createTalkComment");
   		Map<String, Object> result = new HashMap<String, Object>();
   		
   		User user = userService.getUser(login_id);
		comment.setTalktalk_id(comment.getId());
		comment.setWriter(user.getName());
		comment.setWriter_login_id(login_id);
		int create_result = talktalkService.createComment(comment);
		
		Comment res_comment = talktalkService.getComment();
		
		System.out.println(res_comment);
		
		result.put("data", res_comment);
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
   	}
	// 댓글수정
    @PutMapping("/comment/write")
	public ResponseEntity<Map<String, Object>> updateTalkComment(@ModelAttribute Comment comment) {
   		System.out.println("updateTalkComment");
   		Map<String, Object> result = new HashMap<String, Object>();
   		
   		System.out.println(comment);
		
		int update_result = talktalkService.updateComment(comment);
		
		System.out.println(update_result);
		
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
   	}
	// 댓글 삭제
    @DeleteMapping("/comment/write/{id}")
	public ResponseEntity<Map<String, Object>> deleteTalkComment(@PathVariable("id") int id) {
   		System.out.println("deleteTalkComment");
   		Map<String, Object> result = new HashMap<String, Object>();
   		
   		int delete_result = talktalkService.deleteComment(id);
		
		System.out.println(delete_result);
		
		result.put("msg", "success");
		return new ResponseEntity<>(result, HttpStatus.OK);
   	}

	
}