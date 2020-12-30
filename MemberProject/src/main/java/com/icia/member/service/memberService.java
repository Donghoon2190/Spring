package com.icia.member.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dao.memberDao;
import com.icia.member.dto.memberDto;

@Service
public class memberService {

	private ModelAndView mav;
	@Autowired
	private memberDao ma;
	
	@Autowired
	private HttpSession hs;
	
	public ModelAndView memberReg(memberDto md) {
		mav = new ModelAndView();
		int result = ma.memberReg(md);
		if (result>0) {
			mav.setViewName("login");
		}else {
			mav.setViewName("home");
		}
		return mav;
	}

	public ModelAndView login(memberDto member) {
		mav = new ModelAndView();
		memberDto result = null;
		if (ma.idCheck(member)>0) {
			if (ma.pwdCheck(member)>0) {
				result = ma.minfo(member);
				hs.setAttribute("mid", result.getMid());
				mav.setViewName("main");
			} else {
				mav.addObject("value", "비밀번호가 일치하지 않습니다");
				mav.setViewName("login");
			}
		}else {
			mav.addObject("value", "아이디가 일치하지 않습니다.");
			mav.setViewName("login");
		}
		return mav;
	}

	public ModelAndView memberList() {
		mav = new ModelAndView();
		List<memberDto> list;
		list = ma.memberList();
		
		list.sort(new Comparator<memberDto>() {
			@Override
			public int compare(memberDto arg0, memberDto arg1) {
				// TODO Auto-generated method stub
				if (arg0.getMid().equals("ADMIN")) { return -1;
				}else if (arg1.getMid().equals("ADMIN")) { return 0;
				}else { return Integer.parseInt(arg0.getMid())-Integer.parseInt(arg1.getMid());
				}
			}
		});

		mav.addObject("memberList", list);
		mav.setViewName("MemberList");
		return mav;
	}

	public ModelAndView memberdetail(String id) {
		mav = new ModelAndView();
		memberDto member;
		member = ma.memberdetail(id);
		mav.addObject("member", member);
		mav.setViewName("memberdetail");
		return mav;
	}

	public ModelAndView memberdelete(String id) {
		mav = new ModelAndView();
		int result = ma.memberdelete(id);
		
		if (result>0) {
			mav.setViewName("redirect:/memberList");
		}else {
			mav.setViewName("memberList");	
		}
		return mav;
	}

	public ModelAndView memberUpdate(String id) {
		mav = new ModelAndView();
		memberDto member;
		member = ma.memberdetail(id);
		mav.addObject("member", member);
		mav.setViewName("memberUpdate");
		return mav;
	}

	public ModelAndView memberModify(memberDto member) {
		mav = new ModelAndView();
		String id = (String)hs.getAttribute("mid");
		int result = ma.memberModify(member);
		if (result>0) {
			if (id.equals("ADMIN")) {
				mav.setViewName("redirect:/memberList");
			}else {
				mav.setViewName("main");
			}
		}else {
			mav.setViewName("memberList");	
		}
		
		return mav;
	}

}















