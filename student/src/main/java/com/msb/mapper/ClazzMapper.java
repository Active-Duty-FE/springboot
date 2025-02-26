package com.msb.mapper;

import com.msb.pojo.Clazz;

import java.util.List;

public interface ClazzMapper {
    List<Clazz> selectAllClazz();
    int insertClazz(Clazz clazz);
    int updateClazz(Clazz clazz);
}
