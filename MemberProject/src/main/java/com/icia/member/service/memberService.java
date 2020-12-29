package com.icia.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.member.dao.memberDao;
import com.icia.member.dto.memberDto;

@Service
public class memberService {

	@Autowired
	private memberDao ma;
	
	public void memberReg(memberDto md) {
		ma.memberReg(md);
	}

}
