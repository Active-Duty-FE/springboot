package com.msb.service;

import com.msb.pojo.Clazz;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ClazzService {
    List<Clazz> selectAllClazz();
    int insertClazz(Clazz clazz);
    int updateClazz(Clazz clazz);
}
