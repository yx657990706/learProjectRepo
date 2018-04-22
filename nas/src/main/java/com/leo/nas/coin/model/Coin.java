package com.leo.nas.coin.model;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class Coin {

	private String shortName;
	private String name;
	private String zhName;

	@Min(value = 20,message = "ICO价格太低了")
	private Double icoPrice;
	private Integer icoTotle;

	@Override
	public String toString() {
		return "Coin [shortname=" + shortName + ", name=" + name + ", zhName=" + zhName + ", icoPrice=" + icoPrice + ", icoTotle=" + icoTotle + "]";
	}

}
