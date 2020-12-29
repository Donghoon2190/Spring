package com.icia.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.test.dao.TestDAO;
import com.icia.test.dto.TestDto;

@Service
public class TestService {
	
	@Autowired
	private TestDAO td;
	
	private ModelAndView mav;
	
	public void insert(String data1) {
		td.insert(data1);
	}

	public ModelAndView select() {
		String result = td.select();
		
		mav = new ModelAndView();
		
		mav.addObject("result",result);
		mav.setViewName("result");
		return mav;
	}

	public ModelAndView insertDB2(TestDto test) {
		mav = new ModelAndView();

		td.insertDB2(test);
		mav.setViewName("home");
		return mav;
	}
	
}
















