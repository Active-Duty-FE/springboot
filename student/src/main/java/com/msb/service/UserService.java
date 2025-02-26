package com.msb.service;

import com.msb.pojo.User;

import java.util.List;

public interface UserService {
    List<User> selectAllUsers();
    int addUser(User user);
    int deleteUser(int id);
    int updateUser(User user);
}
