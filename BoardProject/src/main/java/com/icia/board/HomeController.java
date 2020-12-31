package com.icia.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dto.boardDto;
import com.icia.board.service.boardService;

@Controller
public class HomeController {
	
	private ModelAndView mav;
	
	@Autowired
	private boardService bs;
	
	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}
	@RequestMapping(value = "boardWrite")
	public String boardWrite() {
		
		return "boardWrite";
	}
	
	@RequestMapping(value = "boardWriter" , method = RequestMethod.POST)
	public ModelAndView boardWriter(@ModelAttribute boardDto board) {
		mav = bs.boardWrite(board);
		return mav;
	}
	@RequestMapping(value = "boardlist")
	public ModelAndView boardlist() {
		mav = bs.boardlist();
		
		return mav;
	}@RequestMapping(value = "boardDetail")
	public ModelAndView boardDetail(@ModelAttribute boardDto board) {
		mav = bs.boardDetail(board);
		return mav;
	}
	
}




















