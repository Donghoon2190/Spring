package com.icia.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.member.dto.memberDto;

@Repository
public class memberDao {
	
	@Autowired
	private SqlSessionTemplate st;
	
	public void memberReg(memberDto md) {
		st.insert("Member.memberReg", md);
		
	}

}
