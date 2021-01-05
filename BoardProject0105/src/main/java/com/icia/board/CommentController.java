package com.icia.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.board.dto.CommentDto;
import com.icia.board.service.CommentService;

@Controller
@RequestMapping("/comment/*")
// comment/ 로 시작하는 모든 파일들을 여기로 부름. (폴더 만드는형식과 비슷)
public class CommentController {

	@Autowired
	private CommentService cs;
	
	@RequestMapping(value = "commentwrite")
	public @ResponseBody List<CommentDto> commentWrite(@ModelAttribute CommentDto comment){
		System.out.println(comment);
		List<CommentDto> list = cs.commentWrite(comment);
		return list;
	}@RequestMapping(value = "getcomment")
	public @ResponseBody List<CommentDto> getcomment(@ModelAttribute CommentDto comment){
		List<CommentDto> list =cs.getcomment(comment) ;  
		return list;
	}
}



























