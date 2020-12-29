package com.icia.member;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icia.member.dto.memberDto;
import com.icia.member.service.memberService;

@Controller
public class HomeController {
	
	@Autowired
	private memberService ms;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	@RequestMapping(value = "regcontroll")
	public String regpage() {
		return "regpage";
	}
	@RequestMapping(value = "logincontroll")
	public String login() {
		
		return "regpage";
	}
	@RequestMapping(value = "regmember" ,method = RequestMethod.POST)
	public String regmember(@ModelAttribute memberDto md) {
		ms.memberReg(md);
		return "login";
	}
	
}









