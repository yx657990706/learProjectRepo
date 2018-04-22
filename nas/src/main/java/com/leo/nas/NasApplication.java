package com.leo.nas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //spring能够扫描到我们自己编写的servlet和filter,druid需要设置该项
@SpringBootApplication
public class NasApplication {

	public static void main(String[] args) {
		SpringApplication.run(NasApplication.class, args);
	}
}
