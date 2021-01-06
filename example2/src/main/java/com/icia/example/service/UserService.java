package com.icia.example.service;

import java.io.File;
import java.io.IOException;

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
	
	public String CheckId(String uid) {
		return dao.CheckId(uid);
		
	}

	public String userReg(UserDto user) throws IllegalStateException, IOException {
		String result = "";
		System.out.println(user.getUbirth());
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

}
