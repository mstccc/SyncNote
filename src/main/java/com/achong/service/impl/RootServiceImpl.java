package com.achong.service.impl;

import com.achong.bean.Url;
import com.achong.mapper.RootMapper;
import com.achong.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RootServiceImpl implements RootService {

    @Autowired
    RootMapper rootMapper;

    @Override
    public Url queryUrl(String url) {

        return rootMapper.queryUrl(url);
    }

    @Override
    public int insertUrl(Url url) {
        return rootMapper.insertUrl(url);
    }

    @Override
    public int updateUrl(Url url) {
        return rootMapper.updateUrl(url);
    }
}
