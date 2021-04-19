package com.kwin.db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

//MapperScan批量扫描所有的mapper接口
@SpringBootApplication
@EnableScheduling
//@MapperScan("com.kwin.db")
public class DbApplication extends SpringBootServletInitializer{//extends SpringBootServletInitializer

    public static void main(String[] args) {
        SpringApplication.run(DbApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DbApplication.class);
    }

}
