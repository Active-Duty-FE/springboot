package com.msb.system.utils;

import com.msb.api.entity.UserEntity;
import com.msb.system.dto.UserInfo;
import org.springframework.beans.BeanUtils;

public class ConvertUtils {
    public static UserInfo UserEntityConvertUserInfo(UserEntity userEntity) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUid(userEntity.getUid());
        userInfo.setT1(userEntity.getT1());
        userInfo.setUaccount(userEntity.getUaccount());
        userInfo.setUdesc(userEntity.getUdesc());
        userInfo.setUmail(userEntity.getUmail());
        userInfo.setUpass(userEntity.getUpass());
        userInfo.setUname(userEntity.getUname());
        userInfo.setUphone(userEntity.getUphone());
        return userInfo;
    }
}
