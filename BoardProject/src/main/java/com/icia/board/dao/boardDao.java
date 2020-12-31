package com.icia.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board.dto.boardDto;

@Repository
public class boardDao {

	@Autowired
	private SqlSessionTemplate st;
		
	
	public int boardWrite(boardDto board) {
		return st.insert("Board.boardWrite", board);
	}


	public List<boardDto> boardlist() {
		return st.selectList("Board.boardlist");
	}


	public boardDto boardDetail(boardDto board) {
		System.out.println(board.getBnum());
		st.update("Board.boardDetail", board);
		return board;
		
	}

}






