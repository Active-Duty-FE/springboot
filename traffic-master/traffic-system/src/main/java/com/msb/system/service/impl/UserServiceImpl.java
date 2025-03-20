package com.msb.system.service.impl;

import com.msb.api.common.SystemUtils;
import com.msb.api.entity.UserEntity;
import com.msb.system.dto.UserInfo;
import com.msb.system.repository.UserRepository;
import com.msb.system.service.UserService;
import com.msb.system.utils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * @param userEntity
     * @return ture: 用户保存成功 false: 用户保存失败
     */
    public boolean addUser(UserEntity userEntity) {
        UserInfo userInfo = ConvertUtils.UserEntityConvertUserInfo(userEntity);
        UserInfo user = userRepository.save(userInfo);
        if (!SystemUtils.isNull(user) && userEntity.getUid() != 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUserByIds(String ids) {
        if (SystemUtils.isNullOrEmpty(ids)) {
            return false;
        }
        String[] splitIds = ids.split(",");
        if (splitIds.length == 1) {
            try {
                Long id = Long.parseLong(splitIds[0]);
                UserInfo userInfo = userRepository.findById(id).get();
                userInfo.setUstatus(1);
                userRepository.save(userInfo);
                return true;
            } catch (Exception e) {
                return false;
            }

        } else {
            Set<Long> longs = new HashSet<>();
            for (String id : splitIds) {
                longs.add(Long.parseLong(id));
            }
            int i = userRepository.deleteUserByIds(longs);
            if (i > 0) {
                return true;
            }
            return false;
        }
    }

    public List<UserInfo> findAllUser() {
        return userRepository.findAll();
    }
}
