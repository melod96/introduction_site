package com.introsite.main.service;

import com.introsite.main.mapper.MainMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

	@Autowired
    public MainMapper mainMapper;
    
    public String selectOneUserId() {
        System.out.println("service 진입");
        return mainMapper.selectOneUserId();
    }

    
}