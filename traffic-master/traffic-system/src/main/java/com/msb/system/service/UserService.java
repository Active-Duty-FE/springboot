package com.msb.system.service;

import com.msb.api.entity.UserEntity;
import com.msb.system.dto.UserInfo;

import java.util.List;

public interface UserService {
    /**
     *
     * @param userEntity
     * @return true: 用户保存成功 false： 用户保存失败
     */
    public boolean addUser(UserEntity userEntity);
    public boolean deleteUserByIds(String ids);
    public boolean updateUser(UserEntity userEntity);
    public List<UserEntity> findAllUser();
    public List<UserEntity> findUserByWhere(UserEntity userEntity);
}
