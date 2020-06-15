package com.danicoz.pagehelptest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.danicoz.pagehelptest.*")
@MapperScan("com.danicoz.pagehelptest.mapper")
public class PagehelpTestApplication {


	public static void main(String[] args) {

		SpringApplication.run(PagehelpTestApplication.class, args);

	}

}
