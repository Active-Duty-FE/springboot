package com.msb.service.impl;

import com.msb.mapper.HobbyMapper;
import com.msb.pojo.Hobby;
import com.msb.service.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HobbyServiceImpl implements HobbyService {
    @Autowired
    private HobbyMapper hobbyMapper;
    @Override
    public List<Hobby> getAllHobby() {
        return hobbyMapper.getAllHobby();
    }
}
