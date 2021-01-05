package com.icia.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board.dto.PageDto;
import com.icia.board.dto.boardDto;

@Repository
public class boardDao {

	@Autowired
	private SqlSessionTemplate st;
		
	
	public int boardWrite(boardDto board) {
		return st.insert("Board.boardWriteFile", board);
	}


	public List<boardDto> boardlist() {
		return st.selectList("Board.boardlist");
	}


	public boardDto boardDetail(boardDto board) {
		st.update("Board.boardDetail", board);
		return board;
		
	}


	public int BoardModify(boardDto board) {
		return st.update("Board.boardModify", board);
		
	}


	public int BoardDelete(String bnum) {
		return st.delete("Board.boardDelete", bnum);
		
	}


	public List<boardDto> replyreg(boardDto board) {
		st.insert("Board.replyreg",board);
		
		return st.selectList("Board.getreply");
		
	}


	public int boardWriteFile(boardDto board) {
		System.out.println(board);
		return st.insert("Board.boardWriteFile",board);
	}


	public int listCount() {
		
		return st.selectOne("Board.listCount");
	}


	public List<boardDto> pagingList(PageDto paging) {
		return st.selectList("Board.pagingList", paging);
	}


	public List<boardDto> boardsearch(String searchtype, String keyword) {
		Map<String,String> searchMap = new HashMap<String,String>(); 
		searchMap.put("type", searchtype);
		searchMap.put("word", keyword);
		System.out.println(searchMap);
		return st.selectList("Board.boardSearch",searchMap);
	}



}






