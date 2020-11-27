package com.galaxy.gmall02.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 裴一飞
 * @date 2020/11/23 - 14:59
 */
@SpringBootApplication
@MapperScan(basePackages = "com.galaxy.gmall02.user.mapper")
public class GmallUserManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(GmallUserManageApplication.class,args);
    }
}
