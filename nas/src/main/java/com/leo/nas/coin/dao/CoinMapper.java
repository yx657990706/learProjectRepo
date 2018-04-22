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
	public List<Coin> selectCoinList();

	/**
	 * 插入信息
	 * @param coin
	 */
	public void insertCoin(Coin coin);
	
	/**
	 * 根据id查询币种信息
	 * @param id
	 * @return
	 */
	public Coin selectCoinById(Integer id);
}
