package com.icia.example.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.example.dto.PageDto;
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

	public List<UserDto> getUserList(PageDto paging) {
		return st.selectList("User.getUserList",paging);
	}

	public int userCount() {
		return st.selectOne("User.userCount");
	}

	public int UserDelete(String uid) {
		return st.delete("User.userDel", uid);
	}

}











