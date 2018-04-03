package com.beyond.eth.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.beyond.eth.jdbc.dao.JdbcTest;

@Controller
@RequestMapping(value="/jdbc")
public class MyJDBCTestController {

	@Autowired
	private JdbcTest s;
	
	@RequestMapping(value="num")
	@ResponseBody
	public String ssw(ModelAndView model) {
		return s.countNum()+"";
	}
}
