package com.icia.example;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.example.dto.UserDto;
import com.icia.example.service.UserService;

@Controller
public class HomeController {
	
	private ModelAndView mav;
	
	@Autowired
	private UserService us;
	
	@RequestMapping(value = "/")
	public String home() {
		
		return "home";
	}
	@RequestMapping(value = "LoginPage")
	public String LoginPage() {
		
		return "loginPage";
	}
	@RequestMapping(value = "Main")
	public String Main() {
		
		return "main";
	}
	@RequestMapping(value = "modifyPage")
	public String myPage(){
		return "modifyPage";
	}
	@RequestMapping(value = "CheckId")
	public @ResponseBody String CheckId(@RequestParam String uid) {
		return us.CheckId(uid);
	}
	@RequestMapping(value = "userReg")
	public String userReg(@ModelAttribute UserDto user) throws IllegalStateException, IOException {
		return us.userReg(user);
	}
	@RequestMapping(value = "modify")
	public ModelAndView modify(@ModelAttribute UserDto user) throws IllegalStateException, IOException {
		 mav = us.modify(user);
		return mav;
	}
	
	@RequestMapping(value = "Login")
	public ModelAndView Login(@ModelAttribute UserDto user){
		mav = us.Login(user);
		return mav;
	}
	@RequestMapping(value = "myPage")
	public @ResponseBody UserDto myPage(@RequestParam String uid){
		return us.myPage(uid);
	}
	
	
	
}














