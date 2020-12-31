package com.icia.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dao.boardDao;
import com.icia.board.dto.boardDto;

@Service
public class boardService {
		
	private ModelAndView mav;
	
		@Autowired
		private boardDao dao;
	
	public ModelAndView boardWrite(boardDto board) {
		mav = new ModelAndView();
		int result = dao.boardWrite(board);
		if (result>0) {
			mav.setViewName("redirect:/boardlist");
		}else {
			mav.setViewName("home");
		}
		
		return mav;
	}

	public ModelAndView boardlist() {
		mav = new ModelAndView();
		List<boardDto> list = dao.boardlist();
		mav.addObject("list", list);
		mav.setViewName("boardlist");
		return mav;
	}

	public ModelAndView boardDetail(boardDto board) {
		mav = new ModelAndView();
		dao.boardDetail(board);
		mav.addObject("board", board);
		mav.setViewName("boardDetail");
		return mav;
	}

}












