package com.cw.pinki;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@MapperScan(basePackages = {"com.cw.pinki.**.dao"})
public class PinkiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PinkiApplication.class, args);
    }

}
