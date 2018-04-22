package com.leo.nas.coin.controller;

import java.util.List;

import com.leo.nas.coin.service.CoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.leo.nas.coin.dao.CoinMapper;
import com.leo.nas.coin.model.Coin;
import com.leo.nas.coin.propertis.NasPropertis;

import javax.validation.Valid;

@RestController
public class coinContoller {

	private Logger logger = LoggerFactory.getLogger(coinContoller.class);

	@Autowired
	private NasPropertis nasPropertis;//以类的结构形式引入properties的值
	
	@Value("${coin.zhName}")
	private String zhName;
	
//	@Autowired
//	private CoinMapper  coinMapper;

	@Autowired
	private CoinService coinService;
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
		logger.info("=================日志测试======================");
		List<Coin> list = coinService.selectCoinList();
		return list.size()+"";
	}

	@PostMapping(value="/coinInfo4")
	public String outputCoinInfo4(@Valid Coin coin, BindingResult bindingResult) {
		logger.info("=================日志测试2======================");
		if(bindingResult.hasErrors()){
			logger.info("================={}======================",bindingResult.getFieldError().getDefaultMessage());
			return null;
		}
		coinService.insertCoin(coin);
		return "ok";
	}
	
}
