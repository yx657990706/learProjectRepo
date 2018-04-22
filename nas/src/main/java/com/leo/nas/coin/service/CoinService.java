package com.leo.nas.coin.service;

import com.leo.nas.coin.dao.CoinMapper;
import com.leo.nas.coin.model.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinService {

    @Autowired
    private CoinMapper coinMapper;

    public List<Coin> selectCoinList(){
        List<Coin> list = coinMapper.selectCoinList();
        return list;
    }



    public void insertCoin(Coin coin){
        coinMapper.insertCoin(coin);
    }
}
