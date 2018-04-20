package com.leo.nas.coin.propertis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "coin") // 读取以coin开头的属性
@Data
public class NasPropertis {

	private String name;
	private String shortName;
	private String zhName;
	private Integer icoPrice;
	private Integer icoTotal;

	@Override
	public String toString() {
		return "nasPropertis [name=" + name + ", shortName=" + shortName + ", zhName=" + zhName + ", icoPrice=" + icoPrice + ", icoTotal=" + icoTotal + "]";
	}

}
