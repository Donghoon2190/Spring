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

	public int CheckPwd(UserDto user) {
		return st.selectOne("User.CheckPwd",user);
	}

	public UserDto getUserinfo(String uid) {
		return st.selectOne("User.userInfo",uid);
		
	}

	public int userMod(UserDto user) {
		return st.update("User.userMod", user);
	}

}











