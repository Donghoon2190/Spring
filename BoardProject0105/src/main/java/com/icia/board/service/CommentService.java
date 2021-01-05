package com.icia.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.board.dao.CommentDao;
import com.icia.board.dto.CommentDto;

@Service
public class CommentService {
	
	@Autowired
	private CommentDao dao;
	
	public List<CommentDto> commentWrite(CommentDto comment) {
		int result = dao.commentWrite(comment);
		
		List<CommentDto> commentList = new ArrayList<CommentDto>();
		if (result>0) {
			commentList = dao.commentList(comment.getCbnumber());
		}else {
			commentList = null;
		}
		return commentList;
	}

	public List<CommentDto> getcomment(CommentDto comment) {
		List<CommentDto> list =  dao.getcomment(comment);
		
		System.out.println(list);
		return list;
	}

}











