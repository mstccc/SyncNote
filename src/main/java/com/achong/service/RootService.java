package com.achong.service;

import com.achong.bean.Url;


public interface RootService {

    //查询数据库有无尾巴
    Url queryUrl(String url);

    int insertUrl(Url url);

    int updateUrl(Url url);

}
