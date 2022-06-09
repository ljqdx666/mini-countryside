package com.miniapp.countryside;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = {"com.miniapp.countryside.mapper"})
public class CountrysideApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountrysideApplication.class, args);
    }

}
