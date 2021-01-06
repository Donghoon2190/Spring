package com.icia.example.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.example.dto.UserDto;

@Repository
public class DataAccessObject {
	
	@Autowired
	private SqlSessionTemplate st;
	
	public String CheckId(String uid) {
		return st.selectOne("User.CheckId",uid);
	}

	public int userReg(UserDto user) {
		return st.insert("User.userReg", user);
		
	}

}
