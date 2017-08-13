package com.share.portal.dao;

import com.share.portal.pojo.ResourceFavorite;

public interface ResourceFavoriteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResourceFavorite record);

    int insertSelective(ResourceFavorite record);

    ResourceFavorite selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResourceFavorite record);

    int updateByPrimaryKey(ResourceFavorite record);
}