package com.leo.nas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //spring能够扫描到我们自己编写的servlet和filter
@SpringBootApplication
//这里是扫描dao接口的包用于识别mybatis
//@MapperScan(basePackages="com.leo.nas.*.dao")
public class NasApplication {

	public static void main(String[] args) {
		SpringApplication.run(NasApplication.class, args);
	}
}
