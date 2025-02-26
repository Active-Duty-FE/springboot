package com.msb.mapper;

import com.msb.pojo.User;

import java.util.List;
public interface UserMapper {
    List<User> selectAllUsers();
    int addUser(User user);
    int deleteUserById(int id);
    int updateUser(User user);
}
