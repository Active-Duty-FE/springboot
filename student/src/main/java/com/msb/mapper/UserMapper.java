package com.msb.mapper;

import com.msb.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
public interface UserMapper {
    List<User> selectAllUsers();
    int addUser(User user);
    int deleteUser(int id);
    int updateUser(User user);
}
