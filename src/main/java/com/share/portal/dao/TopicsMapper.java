package com.share.portal.dao;

import com.share.portal.pojo.Topics;

public interface TopicsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Topics record);

    int insertSelective(Topics record);

    Topics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Topics record);

    int updateByPrimaryKey(Topics record);
}