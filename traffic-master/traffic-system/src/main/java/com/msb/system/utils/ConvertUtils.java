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
        userInfo.setStartDate(userEntity.getStartDate());
        userInfo.setEndDate(userEntity.getEndDate());
        return userInfo;
    }
    public static UserEntity UserInfoConvertUserEntity(UserInfo userInfo) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUid(userInfo.getUid());
        userEntity.setT1(userInfo.getT1());
        userEntity.setUaccount(userInfo.getUaccount());
        userEntity.setUdesc(userInfo.getUdesc());
        userEntity.setUmail(userInfo.getUmail());
        userEntity.setUpass(userInfo.getUpass());
        userEntity.setUname(userInfo.getUname());
        userEntity.setUphone(userInfo.getUphone());
        userEntity.setStartDate(userInfo.getStartDate());
        userEntity.setEndDate(userInfo.getEndDate());
        return userEntity;
    }
}
