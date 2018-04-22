package com.leo.nas.coin.domain;

import lombok.Data;

@Data
public class CoinDomain {

	private String shortName;
	private String name;
	private String zhName;
	private Double icoPrice;
	private Integer icoTotle;

	@Override
	public String toString() {
		return "Coin [shortname=" + shortName + ", name=" + name + ", zhName=" + zhName + ", icoPrice=" + icoPrice + ", icoTotle=" + icoTotle + "]";
	}

}
