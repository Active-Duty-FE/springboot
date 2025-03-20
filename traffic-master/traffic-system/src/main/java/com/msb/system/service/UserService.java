package com.msb.system.service;

import com.msb.api.entity.UserEntity;

public interface UserService {
    /**
     *
     * @param userEntity
     * @return true: 用户保存成功 false： 用户保存失败
     */
    public boolean addUser(UserEntity userEntity);
    public boolean deleteUserByIds(String ids);
}
