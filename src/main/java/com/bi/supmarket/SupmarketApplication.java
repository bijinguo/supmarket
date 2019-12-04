package com.bi.supmarket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.bi.supmarket.mapper")
@SpringBootApplication
public class SupmarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupmarketApplication.class, args);
	}

}
