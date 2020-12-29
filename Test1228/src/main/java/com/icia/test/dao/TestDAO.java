package com.icia.test.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.test.dto.TestDto;

@Repository
public class TestDAO {
	
	//bean에 등록된걸 쓰려면 Autowired를 써야함
	@Autowired
	private SqlSessionTemplate sql;
	// * SqlSessionTemplate - mybatis에서 제공하는 클래스
	
	public void insert(String data1) {
		sql.insert("Test.insertDB", data1);
		
	}

	public String select() {
		return sql.selectOne("Test.selectDB");
	}

	public void insertDB2(TestDto test) {
		sql.insert("Test.insertDB2", test);
		
	}
}
