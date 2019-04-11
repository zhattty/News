package com.qiafan.web4j.qiafan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.qiafan.web4j.qiafan.mapper")
public class QiafanApplication {

    public static void main(String[] args) {
        SpringApplication.run(QiafanApplication.class, args);
    }

}
