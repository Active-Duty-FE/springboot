package com.msb.service.impl;

import com.msb.mapper.ClazzMapper;
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
    public List<Clazz> getAllClazz() {
        return clazzMapper.getAllClazz();
    }
}
