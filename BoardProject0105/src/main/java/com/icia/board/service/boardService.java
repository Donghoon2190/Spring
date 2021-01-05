package com.icia.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dao.boardDao;
import com.icia.board.dto.PageDto;
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
		System.out.println(list);
		mav.addObject("list", list);
		mav.setViewName("boardlist");
		return mav;
	}

	public ModelAndView boardDetail(boardDto board, int page) {
		mav = new ModelAndView();
		dao.boardDetail(board);
		System.out.println("서비스"+page);
		mav.addObject("board", board);
		mav.addObject("page", page);
		mav.setViewName("boardDetail");
		return mav;
	}

	public ModelAndView BoardModify(boardDto board) {
		mav = new ModelAndView();
		int result = dao.BoardModify(board);
		if (result>0) {
			mav.setViewName("redirect:/boardlist");
		}else {
			mav.setViewName("./");
		}
		
		return mav;
	}

	public ModelAndView BoardDelete(String bnum) {
		mav = new ModelAndView();
		int result = dao.BoardDelete(bnum);
		if (result>0) {
			mav.setViewName("redirect:/boardlist");
		}else {
			mav.setViewName("./");
		}
		return mav;
	}

	public List<boardDto> replyreg(boardDto board) {
		System.out.println("서비스");
		return dao.replyreg(board);
	}

	public ModelAndView boardwritefile(boardDto board) throws IllegalStateException, IOException {
		mav = new ModelAndView();
		MultipartFile bfile = board.getBfile();
		String bfilename = bfile.getOriginalFilename();
		bfilename = System.currentTimeMillis() + "_" + bfilename;
		// 파일 이름에 숫자가 들어가면 
		String savePath = "D:/javaspace/Spring/BoardProject/src/main/webapp/resources/uploadFile/"
				+ bfilename;
		
		if (!bfile.isEmpty()) {
			bfile.transferTo(new File(savePath));
		}
		
		board.setBfilename(bfilename);
		
		int result = dao.boardWriteFile(board);
		if (result>0) {
			mav.setViewName("redirect:/boardlist");
		}else {
			mav.setViewName("./");
		}
		return mav;
	}
	
	// 페이징 처리용 상수 선언
	private static final int PAGE_LIMIT = 3; // 현재 페이지에 보여질 글 갯수
	private static final int BLOCK_LIMIT = 3; // 한화면에 보여질 페이지 숫자 갯수 

	public ModelAndView pagingPage(int page) {
		mav = new ModelAndView();
		// 전체 글 갯수 가져오기
		int listCount = dao.listCount();
		// 현재 페이지에 보여줘야 할 글 범위 지정
		int startRow = (page-1) * PAGE_LIMIT + 1; // 1페이지면 기준 1부터  =>  2페이지면 기준 4부터
		int endRow = page * PAGE_LIMIT;	 // 1페이지면 기준 3까지  =>  2페이지면 기준 6까지
		
		PageDto paging = new PageDto();
		paging.setStartRow(startRow);
		paging.setEndRow(endRow);
		List<boardDto> list = dao.pagingList(paging);
		
		//ceil 소숫점이 있으면 무조건 올리는 함수
		int maxPage = (int)(Math.ceil((double)listCount/PAGE_LIMIT));
		int startPage = (((int)(Math.ceil((double)page/BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;
		int endPage = startPage + BLOCK_LIMIT -1;
		
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		
		mav.addObject("paging", paging);
		mav.addObject("list", list);
		mav.setViewName("pagingPage");
		
		return mav;
	}

	public ModelAndView boardsearch(String searchtype, String keyword) {
		mav = new ModelAndView();
		List<boardDto> list = dao.boardsearch(searchtype,keyword);
		mav.addObject("list", list);
		mav.setViewName("pagingPage");
		return mav;
	}

}












