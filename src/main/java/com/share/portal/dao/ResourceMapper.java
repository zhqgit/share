package com.share.portal.dao;

import com.share.portal.pojo.Resource;
import com.share.portal.pojo.ResourceFavorite;

import java.util.List;

public interface ResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    List<ResourceFavorite> selectResourceFavoriteById(int userId);
}