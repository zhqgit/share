package com.share.portal.dao;

import com.share.portal.pojo.TopicsFavorite;

public interface TopicsFavoriteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TopicsFavorite record);

    int insertSelective(TopicsFavorite record);

    TopicsFavorite selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TopicsFavorite record);

    int updateByPrimaryKey(TopicsFavorite record);
}