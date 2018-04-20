package com.leo.nas.coin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.nas.coin.dao.CoinMapper;
import com.leo.nas.coin.model.Coin;
import com.leo.nas.coin.propertis.NasPropertis;

@RestController
public class coinContoller {

	@Autowired
	private NasPropertis nasPropertis;//以类的结构形式引入properties的值
	
	@Value("${coin.zhName}")
	private String zhName;
	
	@Autowired
	private CoinMapper  coinMapper;
	/**
	 * 测试配置文件读取
	 * @return
	 */
	@GetMapping(value="/coinInfo")
	public String outputCoinInfo() {
		
		return zhName+"的属性:"+nasPropertis.toString();
	}
	
	/**
	 * 测试thymeleaf模版<br>
	 * 
	 * 类的注解需要换成@Controller
	 * @return
	 */
	@GetMapping(value="/coinInfo2")
	public String outputCoinInfo2() {
		return "coin/coinInfo";
	}
	
	
	/**
	 * 测试mybatis和连接池
	 * 
	 * @return
	 */
	@GetMapping(value="/coinInfo3")
	public String outputCoinInfo3() {
		List<Coin> list = coinMapper.selectCoinList();
		return list.size()+"";
	}
	
	
	
}
