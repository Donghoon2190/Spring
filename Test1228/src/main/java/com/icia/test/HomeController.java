package com.icia.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.test.dto.TestDto;
import com.icia.test.service.TestService;
// main - 클래스들만 모아두는곳 resource - 데이터베이스 test - 테스트공간
@Controller
public class HomeController {
	//어떤 jsp에 어떤 데이터를 출력하고자 할때 사용하는 클래스
	ModelAndView mav;
	
	// 주입(injection) 기능 활용 - new를 해줄 필요가 없음 
	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	// 스프링 프로젝트를 처음 실행하면 기본주소값(/)으로 지정된 메소드를 실행함
	// 현재 프로젝트의 기본 주소값 메소드 내용은 home.jsp를 출력 하라는 내용
	// RequestMapping 어노테이션이 어떤 주소에 대해 처리를 할 건지 지정함
	public String home() {
		return "home"; //home.jsp로 가라는 뜻.r
		//<beans:property name="suffix" value=".jsp" /> servlet-context에서 설정해놔서 알아서 인식됨.
	}
	
	// rest 방식 : get, post, put(patch), delete
	// 링크를 타고 왔기 때문에 get방식밖에 안됨.
	// method를 안쓰면 get,post 모두 받을 수 있음.
	@RequestMapping(value = "test")
	public String test() {
		return "test";
	}
	
	//form 태그로 전송된 값 출력하기
//	@RequestMapping(value = "param")
//	public ModelAndView paramTest(@RequestParam("param1") String param1,@RequestParam("param2") String param2) {
//		
//		// param1, param2를 가지고test2.jsp로 이동하기
//		mav = new ModelAndView();
//		// mav에 파라미터 담기
//		mav.addObject("pa1",param1);
//		mav.addObject("pa2",param2);
//		// mav에 목적지(출력할 jsp) 지정
//		mav.setViewName("test2");
//		return mav;
//	}
	@RequestMapping(value = "param")
	public ModelAndView paramTest(@ModelAttribute TestDto test) {
		System.out.println("paramTest메소드");
		System.out.println(test.getParam1());
		System.out.println(test.getParam2());
		mav = testService.insertDB2(test);
		return mav;
	}
	// comtroller에서 값을 담아 화면으로 가져가기
	// 화면에 값을 출력하려면 어떤방식으로 이동을 하나요?
	// dispatch, redirect
	
	@RequestMapping(value = "insert")
	public String insert(@RequestParam("data1") String data1) {
		// TestService 클래스가 가지고 있는 메소드 호출
		testService.insert(data1);
		return "home";
	}
	
	@RequestMapping(value = "selectDB")
	public ModelAndView select() {
		// TestService 클래스가 가지고 있는 메소드 호출
		mav = testService.select();
		
		return mav;
	}
}















