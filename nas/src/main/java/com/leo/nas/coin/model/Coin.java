package com.leo.nas.coin.model;

import lombok.Data;

@Data
public class Coin {

	private String shortName;
	private String name;
	private String zhName;
	private Double icoPrice;
	private Integer icoTotle;

	@Override
	public String toString() {
		return "Coin [shortName=" + shortName + ", name=" + name + ", zhName=" + zhName + ", icoPrice=" + icoPrice + ", icoTotle=" + icoTotle + "]";
	}

}
