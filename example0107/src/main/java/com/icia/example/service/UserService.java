package com.icia.example.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.example.dao.DataAccessObject;
import com.icia.example.dto.UserDto;

@Service
public class UserService {

	@Autowired
	private DataAccessObject dao;
	
	private ModelAndView mav;
	
	@Autowired
	private HttpSession hs;
	
	public String CheckId(String uid) {
		return dao.CheckId(uid);
		
	}

	public String userReg(UserDto user) throws IllegalStateException, IOException {
		String result = "";
		MultipartFile bfile = user.getFile();
		String bfilename = bfile.getOriginalFilename();
		bfilename = System.currentTimeMillis() + "_" + bfilename;
		// 파일 이름에 숫자가 들어가면 
		String savePath = "D:/javaspace/Spring/example2/src/main/webapp/resources/uploadFile/"
				+ bfilename;
		
		if (!bfile.isEmpty()) {
			bfile.transferTo(new File(savePath));
		}
		
		user.setUprofile(bfilename);
		
		if (dao.userReg(user)>0) {
			result = "loginPage";
		}else {
			result = "./";
		}
		return result;
	}

	public ModelAndView Login(UserDto user) {
		mav = new ModelAndView();
		
		if (dao.CheckId(user.getUid())!=null) {
			if (dao.CheckPwd(user)>0) {
				
				user = dao.getUserinfo(user.getUid());
				hs.setAttribute("id", user.getUid());
				mav.addObject("user", user);
				mav.setViewName("main");
				
			}else {
				mav.addObject("pwd", "비밀번호가 일치하지 않습니다.");
				mav.setViewName("loginPage");
				}
		}else {
			mav.addObject("id", "아이디가 일치하지 않습니다.");
		mav.setViewName("loginPage");
		}
		return mav;
	}

	public UserDto myPage(String uid) {
		return dao.getUserinfo(uid);
	}

	public ModelAndView modify(UserDto user) throws IllegalStateException, IOException {
		mav = new ModelAndView();
		System.out.println(user.getFile());
			MultipartFile bfile = user.getFile();
			String bfilename = bfile.getOriginalFilename();
			bfilename = System.currentTimeMillis() + "_" + bfilename;
			// 파일 이름에 숫자가 들어가면 
			String savePath = "D:/javaspace/Spring/example2/src/main/webapp/resources/uploadFile/"
					+ bfilename;
			
			if (!bfile.isEmpty()) {
				bfile.transferTo(new File(savePath));
			}
			
			user.setUprofile(bfilename);
			if (user.getUprofile().split("_").length==1) {
				user.setUprofile(null);
			}
			System.out.println(user.getUprofile());
		if (dao.userMod(user)>0) {
			mav.addObject("value", "<script>alert('정상적으로 수정되었습니다.')</script>");
			mav.setViewName("main");
		}else {
			mav.addObject("value", "<script>alert('수정하는데 실패했습니다.')</script>");
			mav.setViewName("main");
		}
		
		user.setUprofile(null);
		return mav;
	}

}










