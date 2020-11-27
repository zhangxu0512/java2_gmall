package com.galaxy.gmall02.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.galaxy.gmall02.bean.UserAddress;
import com.galaxy.gmall02.user.service.IUserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 裴一飞
 * @date 2020/11/23 - 15:21
 */
@RestController
public class OrderController {
    @Reference//<dubbo:reference>
    private IUserInfoService userInfoService;
    @GetMapping("trade")
    public List<UserAddress> trade(String userId){
        return userInfoService.getUserAddressByUserId(userId);
    }
}
