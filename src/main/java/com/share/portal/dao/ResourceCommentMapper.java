package com.share.portal.dao;

import com.share.portal.pojo.ResourceComment;

public interface ResourceCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResourceComment record);

    int insertSelective(ResourceComment record);

    ResourceComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResourceComment record);

    int updateByPrimaryKey(ResourceComment record);
}