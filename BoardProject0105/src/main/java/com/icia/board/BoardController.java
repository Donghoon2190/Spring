package com.icia.board;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dto.boardDto;
import com.icia.board.service.boardService;

@Controller
public class BoardController {
	
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
	@RequestMapping(value = "pagingPage")// 페이지를 받는데 필수가 아니게 바꾸고 만약 페이지를 받아오지 않으면 default 1로
	public ModelAndView pagingPage(@RequestParam(value = "page", required = false,defaultValue = "1") int page) {
		mav = bs.pagingPage(page);
		return mav;
	}
	@RequestMapping(value = "Modifypage")
	public ModelAndView Modifypage(@ModelAttribute boardDto board) {
		mav = new ModelAndView();
		mav.addObject("bnum", board.getBnum());
		mav.addObject("btitle", board.getBtitle());
		mav.addObject("bcontents", board.getBcontents());
		mav.setViewName("Modifypage");
		return mav;
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
	}
	@RequestMapping(value = "boardDetail")
	public ModelAndView boardDetail(@ModelAttribute boardDto board,
			@RequestParam(value = "page", required = false,defaultValue = "1") int page) {
		System.out.println("컨트롤"+page);
		mav = bs.boardDetail(board,page);
		return mav;
	}
	
	@RequestMapping(value = "BoardModify" , method = RequestMethod.POST)
	public ModelAndView BoardModify(@ModelAttribute boardDto board) {
		mav = bs.BoardModify(board);
		return mav;
	}
	@RequestMapping(value = "BoardDelete")
	public ModelAndView BoardDelete(@RequestParam String bnum) {
		mav = bs.BoardDelete(bnum);
		return mav;
	}
	@RequestMapping(value = "replyreg")
	public @ResponseBody List<boardDto> replyreg(@ModelAttribute boardDto board) {
		return bs.replyreg(board);
	}
	//파일첨부 글쓰기
	@RequestMapping(value = "boardwritefile")
	public ModelAndView boardwritefile(@ModelAttribute boardDto board) throws IllegalStateException, IOException {
		mav = bs.boardwritefile(board);
		return mav;
	}
	
	// 검색처리 
	@RequestMapping(value = "boardsearch")
	public ModelAndView boardsearch(@RequestParam String searchtype, @RequestParam String keyword) {
		mav = bs.boardsearch(searchtype,keyword);
		return mav;
	}
}




















