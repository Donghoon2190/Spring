package com.icia.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board.dto.CommentDto;

@Repository
public class CommentDao {

	
	@Autowired
	private SqlSessionTemplate st;
	public int commentWrite(CommentDto comment) {
		System.out.println(comment.getCbnumber());
		return st.insert("Comment.commentWrite",comment);
	}
	public List<CommentDto> commentList(int cbnumber) {
		return st.selectList("Comment.commentList",cbnumber);
	}
	public List<CommentDto> getcomment(CommentDto comment) {
		
		return st.selectList("Comment.getcomment",comment);
	}

}
