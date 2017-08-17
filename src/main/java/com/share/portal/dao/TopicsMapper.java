package com.share.portal.dao;

import com.share.portal.pojo.ResourceFavorite;
import com.share.portal.pojo.Topics;

import java.util.List;

public interface TopicsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Topics record);

    int insertSelective(Topics record);

    Topics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Topics record);

    int updateByPrimaryKey(Topics record);

    List<ResourceFavorite> selectTopicsFavoriteById(int userId);
}