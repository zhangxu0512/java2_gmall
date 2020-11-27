package com.galaxy.gmall02.user.service;

import com.galaxy.gmall02.bean.UserAddress;
import com.galaxy.gmall02.bean.UserInfo;

import java.util.List;

/**
 * @author 裴一飞
 * @date 2020/11/23 - 14:56
 */
public interface IUserInfoService {
    List<UserInfo> getUserInfoList();

    /**
     * 根据用户Id查询用户的地址列表
     * @param userId 用户id
     * @return 返回地址列表
     */
    List<UserAddress> getUserAddressByUserId(String userId);
}
