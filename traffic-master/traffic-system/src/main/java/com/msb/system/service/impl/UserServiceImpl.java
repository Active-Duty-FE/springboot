package com.msb.system.service.impl;

import com.msb.api.common.SystemUtils;
import com.msb.api.entity.UserEntity;
import com.msb.system.dto.UserInfo;
import com.msb.system.repository.UserRepository;
import com.msb.system.service.UserService;
import com.msb.system.utils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public boolean updateUser(UserEntity userEntity) {
        try {
            if (SystemUtils.isNull(userEntity.getUid()) || userEntity.getUid() == 0) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        UserInfo userInfo = userRepository.findById(userEntity.getUid()).get();
        if (!SystemUtils.isNull(userEntity.getUname())) {
            userInfo.setUname(userEntity.getUname());
        }
        if (!SystemUtils.isNull(userEntity.getUaccount())) {
            userInfo.setUaccount(userEntity.getUaccount());
        }
        if (!SystemUtils.isNull(userEntity.getUmail())) {
            userInfo.setUmail(userEntity.getUmail());
        }
        if (!SystemUtils.isNull(userEntity.getUphone())) {
            userInfo.setUphone(userEntity.getUphone());
        }
        if (!SystemUtils.isNull(userEntity.getUdesc())) {
            userInfo.setUdesc(userEntity.getUdesc());
        }
        userRepository.save(userInfo);
        return true;
    }
    @Override
    public List<UserEntity>  findAllUser() {
        List<UserInfo> userInfos = userRepository.findAll();
        List<UserEntity> list = new ArrayList<>();
        for (UserInfo u : userInfos) {
            UserEntity userEntity = ConvertUtils.UserInfoConvertUserEntity(u);
            list.add(userEntity);
        }
        return list;
    }

    @Override
    public List<UserEntity> findUserByWhere(UserEntity userEntity) {
        UserInfo userInfo = ConvertUtils.UserEntityConvertUserInfo(userEntity);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = formatter.parse(userEntity.getStartDate());
            endDate = formatter.parse(userEntity.getEndDate());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("uphone",m->m.contains())
                .withMatcher("uname",m->m.contains())
                .withIgnorePaths("uid")
                .withIgnorePaths("ustatus");
        Example example = Example.of(userInfo, matcher);
        List<UserInfo> userInfos = userRepository.findAll(example);
        List<UserInfo> allByUtimeBetween = userRepository.findAllByUtimeIsBetween(startDate, endDate);
        List<UserInfo> userInfoListlist = userInfos.stream().filter(allByUtimeBetween::contains).collect(Collectors.toList());
        ArrayList<UserEntity> list = new ArrayList<>();
        for (UserInfo u : userInfoListlist) {
            list.add(ConvertUtils.UserInfoConvertUserEntity(u));
        }
        return list;
    }
}
