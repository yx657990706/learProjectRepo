package com.leo.nas.coin.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.nas.coin.model.Coin;
import com.leo.nas.coin.propertis.NasPropertis;
import com.leo.nas.coin.service.CoinService;
import com.leo.nas.common.model.Result;
import com.leo.nas.common.utils.ResultUtil;

@RestController
public class CoinController {

	private Logger logger = LoggerFactory.getLogger(CoinController.class);

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

	/**
	 * 统一消息格式
	 * @param coin
	 * @param bindingResult
	 * @return
	 */
	@PostMapping(value="/coinInfo4")
	public Result outputCoinInfo4(@Valid Coin coin, BindingResult bindingResult) {
		logger.info("=================日志测试2======================");
		if(bindingResult.hasErrors()){
			logger.info("================={}======================",bindingResult.getFieldError().getDefaultMessage());
			return ResultUtil.error("0001", bindingResult.getFieldError().getDefaultMessage());
		}
		coinService.insertCoin(coin);
		return ResultUtil.success();
	}
	
	@GetMapping(value="/coinInfo5/{id}")
	public Result outputCoinInfo5(@PathVariable Integer id) throws Exception{
		logger.info("=================日志测试3======================");
		
		coinService.getCoin(id);
		return null;
	}
	
}
