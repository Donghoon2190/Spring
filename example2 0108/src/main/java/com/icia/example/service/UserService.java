package com.icia.example.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.example.dao.DataAccessObject;
import com.icia.example.dto.PageDto;
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
	private static final int PAGE_LIMIT = 5; // 현재 페이지에 보여질 글 갯수
	private static final int BLOCK_LIMIT = 5; // 한화면에 보여질 페이지 숫자 갯수 

	public ModelAndView getUserList(int page) {
		mav = new ModelAndView();
		
			// 전체 글 갯수 가져오기
			int userCount = dao.userCount();
			// 현재 페이지에 보여줘야 할 글 범위 지정
			int startRow = (page-1) * PAGE_LIMIT + 1; // 1페이지면 기준 1부터  =>  2페이지면 기준 4부터
			int endRow = page * PAGE_LIMIT;	 // 1페이지면 기준 3까지  =>  2페이지면 기준 6까지
			
			PageDto paging = new PageDto();
			paging.setStartRow(startRow);
			paging.setEndRow(endRow);
			System.out.println(paging.getStartRow());
			List<UserDto> list = dao.getUserList(paging);
			
			//ceil 소숫점이 있으면 무조건 올리는 함수
			int maxPage = (int)(Math.ceil((double)userCount/PAGE_LIMIT));
			int startPage = (((int)(Math.ceil((double)page/BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;
			int endPage = startPage + BLOCK_LIMIT -1;
			
			if (endPage > maxPage) {
				endPage = maxPage;
			}
			paging.setPage(page);
			paging.setStartPage(startPage);
			paging.setEndPage(endPage);
			paging.setMaxPage(maxPage);
			
			JSONObject ja;
			JSONArray jar = new JSONArray();;
			for (int i = 0; i < list.size(); i++) {
				ja = new JSONObject();
				ja.put("uid", list.get(i).getUid());
				ja.put("upwd", list.get(i).getUpwd());
				ja.put("uname", list.get(i).getUname());
				ja.put("ubirth", list.get(i).getUbirth());
				ja.put("ugender", list.get(i).getUgender());
				ja.put("uemail", list.get(i).getUemail());
				ja.put("uadd", list.get(i).getUadd());
				ja.put("uphone", list.get(i).getUphone());
				ja.put("uprofile", list.get(i).getUprofile());
				
				jar.add(i, ja);
			}
			System.out.println(jar);
			
		mav.addObject("paging", paging);
		mav.addObject("jlist", jar);
		mav.setViewName("userList");
		return mav;
	}

	public ModelAndView UserDelete(String uid) {
		mav = new ModelAndView();
		if (dao.UserDelete(uid)>0) {
			mav.addObject("value", "회원삭제가 완료되었습니다.");
			mav.setViewName("redirect:/getUserList");
		}else {
			mav.addObject("value", "회원삭제가 실패하였습니다.");
			mav.setViewName("redirect:/getUserList");
		}
		return mav;
	}

}










