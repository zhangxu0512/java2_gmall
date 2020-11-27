package com.galaxy.gmall02.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.galaxy.gmall02.bean.UserAddress;
import com.galaxy.gmall02.bean.UserInfo;
import com.galaxy.gmall02.user.mapper.UserAddressMapper;
import com.galaxy.gmall02.user.mapper.UserInfoMapper;
import com.galaxy.gmall02.user.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 裴一飞
 * @date 2020/11/23 - 14:56
 */
@Service
//<dubbo:service interface="IUserInfoService全路径" ref="userInfoServiceImpl">
//<bean id="userInfoServiceImpl" class="实现类的全路径">
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserAddressMapper userAddressMapper;
    @Override
    public List<UserInfo> getUserInfoList() {
        return userInfoMapper.selectAll();
    }

    @Override
    public List<UserAddress> getUserAddressByUserId(String userId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setId(userId);
        //select * from user_address where user_id = #{userId}
        return userAddressMapper.select(userAddress);
    }
}
