package com.dave.springbootdemo1;

import com.dave.bean.SystemConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScans({
        @ComponentScan(value ="com.dave.controller")
        ,@ComponentScan(value ="com.dave.service")
        ,@ComponentScan(value ="com.dave.bean")
        ,@ComponentScan(value ="com.dave.common")})
@MapperScan("com.dave.dao")
public class Springbootdemo1Application {
    public static void main(String[] args) {
        SpringApplication.run(Springbootdemo1Application.class, args);

    }

}
