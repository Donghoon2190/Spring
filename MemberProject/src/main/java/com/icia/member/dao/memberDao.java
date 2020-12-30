package com.icia.member.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.member.dto.memberDto;

@Repository
public class memberDao {
	
	@Autowired
	private SqlSessionTemplate st;
	
	public int memberReg(memberDto md) {
		return st.insert("Member.memberReg", md);
		
	}

	public int idCheck(memberDto member) {
		int result =st.selectOne("Member.idCheck",member);
		return result;
	}

	public int pwdCheck(memberDto member) {
		int result = st.selectOne("Member.pwdCheck",member);
		return result;
	}

	public memberDto minfo(memberDto member) {
		return st.selectOne("Member.minfo",member);	
		}

	public List<memberDto> memberList() {
		return st.selectList("Member.memberList");
	}

	public memberDto memberdetail(String id) {
		return st.selectOne("Member.memberdetail",id);
		
	}

	public int memberdelete(String id) {
		return st.delete("Member.memberdelete",id);
	}

	public int memberModify(memberDto member) {
		return st.update("Member.memberModify", member);
		
	}

}








