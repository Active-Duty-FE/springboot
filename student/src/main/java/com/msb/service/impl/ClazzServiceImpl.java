package com.msb.service.impl;

import com.msb.mapper.ClazzMapper;
import com.msb.mapper.UserMapper;
import com.msb.pojo.Clazz;
import com.msb.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    @Override
    public List<Clazz> selectAllClazz() {
        return clazzMapper.selectAllClazz();
    }

    @Override
    public int insertClazz(Clazz clazz) {
        return clazzMapper.insertClazz(clazz);
    }

    @Override
    public int updateClazz(Clazz clazz) {
        return clazzMapper.updateClazz(clazz);
    }
}
