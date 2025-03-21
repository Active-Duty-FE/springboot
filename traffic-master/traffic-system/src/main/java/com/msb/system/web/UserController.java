package com.msb.system.web;

import com.msb.api.code.SystemCode;
import com.msb.api.common.ResponseResult;
import com.msb.api.common.ResponseResultFactory;
import com.msb.api.common.SystemUtils;
import com.msb.api.entity.UserEntity;
import com.msb.system.dto.UserInfo;
import com.msb.system.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class UserController {
    final Logger logger = LoggerFactory.getLogger(UserController.class);
    final int NAME_LENGTH = 3;
    final int ACCOUNT_LENGTH = 3;
    final int PASS_LENGTH = 3;
    @Autowired
    private UserServiceImpl userService;
    @PostMapping("/user")
    public ResponseResult addUser(@RequestBody UserEntity userEntity) {
        ResponseResult responseResult;
        if(SystemUtils.isNull(userEntity)) {
            logger.error("system user addUser UserEntity is null");
            responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_PARAM_NULL);
            logger.info("system user addUser return msg : " + responseResult);
            return responseResult;
        }
        if (SystemUtils.isNullOrEmpty(userEntity.getUname())) {
            logger.error("system user addUser uname is null");
            responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_NAME_NULL, SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_NAME_NULL_MSG);
            return responseResult;
        }
        if (SystemUtils.isNullOrEmpty(userEntity.getUaccount())) {
            responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_ACCOUNT_NULL);
            return responseResult;
        }
        if(SystemUtils.isNullOrEmpty(userEntity.getUpass())) {
            responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_PASS_NULL);
            return responseResult;
        }
        if(SystemUtils.isNullOrEmpty(userEntity.getUmail())) {
            responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_PHONE_NULL);
            return responseResult;
        }
        if(userEntity.getUname().trim().length() <= NAME_LENGTH) {
            responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_NAME_SIZE);
            return responseResult;
        }
        if(userEntity.getUaccount().trim().length() <= ACCOUNT_LENGTH) {
            responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_ACCOUNT_SIZE);
            return responseResult;
        }
        if(userEntity.getUpass().trim().length() <= PASS_LENGTH) {
            responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL_PASS_SIZE);
            return responseResult;
        }
        userEntity.setUpass(DigestUtils.md5DigestAsHex(userEntity.getUpass().getBytes()));
        boolean flag = userService.addUser(userEntity);
        if (flag) {
            responseResult = ResponseResultFactory.buildResponseResult(SystemCode.TRAFFIC_SYSTEM_SUCCESS, "success", userEntity);
            return responseResult;
        } else {
            responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_ADD_FAIL);
        }
        return responseResult;
    }

    @DeleteMapping("/user")
    public ResponseResult deleteUserByIds(@RequestParam String ids ) {
        ResponseResult responseResult;
        if(SystemUtils.isNullOrEmpty(ids)) {
            responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_DELETE_USER_FAIL_PARAM_NULL, SystemCode.SYSTEM_USER_ERROR_DELETE_USER_FAIL_PARAM_NULL_MSG);
            return responseResult;
        }
        boolean b = userService.deleteUserByIds(ids);
        if (b) {
            responseResult = ResponseResultFactory.buildResponseResult(SystemCode.TRAFFIC_SYSTEM_SUCCESS, "success");
        } else  {
            responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_DELETE_USER_FAIL, SystemCode.SYSTEM_USER_ERROR_DELETE_USER_FAIL_MSG);
        }
        return responseResult;
    }
    @PutMapping("/user")
    public ResponseResult updateUser(@RequestBody UserEntity userEntity ) {
        ResponseResult responseResult;
        if(SystemUtils.isNull(userEntity.getUid()) || userEntity.getUid() == 0) {
            responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_UPD_FAIL_USER_ID_NULL, SystemCode.SYSTEM_USER_ERROR_UPD_FAIL_USER_ID_NULL_MSG);
            return responseResult;
        }
        boolean b = userService.updateUser(userEntity);
        if (b) {
            responseResult = ResponseResultFactory.buildResponseResult(SystemCode.TRAFFIC_SYSTEM_SUCCESS, "success");
        } else  {
            responseResult = ResponseResultFactory.buildResponseResult(SystemCode.SYSTEM_USER_ERROR_UPD_USER_FAIL, SystemCode.SYSTEM_USER_ERROR_UPD_USER_FAIL_MSG);
        }
        return responseResult;
    }
    @GetMapping("/user")
    public ResponseResult findUserByWhere(@RequestParam(required = false) String name, String phone, String email, String account, String startDate, String endDate) {
        ResponseResult responseResult;
        if(SystemUtils.isNullOrEmpty(name) && SystemUtils.isNullOrEmpty(phone) && SystemUtils.isNullOrEmpty(email) && SystemUtils.isNullOrEmpty(account) && SystemUtils.isNullOrEmpty(startDate) && SystemUtils.isNullOrEmpty(endDate)) {
            List<UserEntity> data = userService.findAllUser();
            responseResult = ResponseResultFactory.buildResponseResult(SystemCode.TRAFFIC_SYSTEM_SUCCESS, "success", data);
        } else  {
            UserEntity userEntity = new UserEntity();
            userEntity.setUaccount(account);
            userEntity.setUphone(phone);
            userEntity.setUmail(email);
            userEntity.setUname(name);
            userEntity.setStartDate(startDate);
            userEntity.setEndDate(endDate);
            List<UserEntity> userByWhere = userService.findUserByWhere(userEntity);
            responseResult = ResponseResultFactory.buildResponseResult(SystemCode.TRAFFIC_SYSTEM_SUCCESS, userByWhere);
        }
        return responseResult;
    }

}
