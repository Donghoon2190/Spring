package com.icia.member;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dto.memberDto;
import com.icia.member.service.memberService;

@Controller
public class HomeController {
	
	private ModelAndView mav;
	@Autowired
	private memberService ms;
	
	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}
	@RequestMapping(value = "regcontroll")
	public String regpage() {
		return "regpage";
	}
	@RequestMapping(value = "loginpage")
	public String login() {
		return "login";
	}
	@RequestMapping(value = "logincontroll", method = RequestMethod.POST )
	public ModelAndView login(@ModelAttribute memberDto member ) {
		mav=ms.login(member);
		return mav;
	}
	@RequestMapping(value = "regmember" ,method = RequestMethod.POST)
	public ModelAndView regmember(@ModelAttribute memberDto md) {
		mav = ms.memberReg(md);
		return mav;
	}
	@RequestMapping(value = "memberList")
	public ModelAndView regmember() {
		mav = ms.memberList();
		return mav;
	}
	@RequestMapping(value = "memberdetail")
	public ModelAndView memberdetail(@RequestParam String id) {
		mav = ms.memberdetail(id);
		return mav;
	}
	@RequestMapping(value = "memberdelete")
	public ModelAndView memberdelete(@RequestParam String id) {
		mav = ms.memberdelete(id);
		return mav;
	}
	@RequestMapping(value = "memberUpdate")
	public ModelAndView memberUpdate(@RequestParam String id) {
		mav = ms.memberUpdate(id);
		return mav;
	}
	@RequestMapping(value = "memberModify" , method = RequestMethod.POST)
	public ModelAndView memberModify(@ModelAttribute memberDto member) {
		
		mav = ms.memberModify(member);
		return mav;
	}
}









