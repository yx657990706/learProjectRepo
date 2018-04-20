package com.leo.nas.coin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.leo.nas.coin.model.Coin;

@Mapper
public interface CoinMapper {

	/**
	 * 查询coin列表
	 * @return
	 */
	List<Coin> selectCoinList();
	
}
