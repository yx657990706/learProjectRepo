package com.leo.nas.coin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leo.nas.coin.dao.CoinMapper;
import com.leo.nas.coin.model.Coin;
import com.leo.nas.common.enums.ResltEnum;
import com.leo.nas.common.exception.MyException;

@Service
public class CoinService {

	@Autowired
	private CoinMapper coinMapper;

	public List<Coin> selectCoinList() {
		List<Coin> list = coinMapper.selectCoinList();
		return list;
	}

	public void insertCoin(Coin coin) {
		coinMapper.insertCoin(coin);
	}

	public void getCoin(Integer id) throws Exception {
		Coin coin = coinMapper.selectCoinById(id);
		Integer icoTotal = coin.getIcoTotle();
		if (icoTotal < 10000000) {
			throw new MyException(ResltEnum.ERROR_LOW);
		} else if (icoTotal > 90000000) {
			throw new MyException(ResltEnum.ERROR_HIGHT);
		}
	}

	/**
	 * 
	 *@Title: selectCoinList
	 *@Description: 分页查询
	 *
	 * @param page
	 * @param rows
	 * @return
	 */
	public PageInfo<Coin> selectCoinList(int pageNum, int pageSize) {
		//核心要点
		PageHelper.startPage(pageNum, pageSize);
		List<Coin> list = coinMapper.selectCoinList();
		
		//封装pageInfo对象,便于页面处理
		PageInfo<Coin> pageInfo = new PageInfo<Coin>(list);

		return pageInfo;
	}

}
