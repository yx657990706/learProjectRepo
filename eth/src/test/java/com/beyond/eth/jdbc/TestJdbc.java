package com.beyond.eth.jdbc;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.beyond.eth.BaseJunitTest;
import com.beyond.eth.jdbc.dao.JdbcTest;

public class TestJdbc extends BaseJunitTest {

	@Autowired
	private JdbcTest s;
	
	@Test
	public void testCount() {
		int num = s.countNum();
		System.out.println("总数:"+num);
	}
}
