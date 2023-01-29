package com.achong.mapper;

import com.achong.bean.Url;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RootMapper {

    //根据url查询有无,返回封装的实体类
    Url queryUrl(String url);

    //插入数据
    int insertUrl(Url url);

    //更新数据
    int updateUrl(Url url);

}
