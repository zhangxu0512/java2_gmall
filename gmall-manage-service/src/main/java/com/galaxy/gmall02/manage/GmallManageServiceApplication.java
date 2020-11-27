package com.galaxy.gmall02.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 裴一飞
 * @date 2020/11/25 - 10:29
 */
@SpringBootApplication
@MapperScan(basePackages = "com.galaxy.gmall02.manage.mapper")
@EnableTransactionManagement
public class GmallManageServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GmallManageServiceApplication.class,args);
    }
}
