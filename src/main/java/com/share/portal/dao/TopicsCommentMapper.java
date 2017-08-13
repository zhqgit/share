package com.share.portal.dao;

import com.share.portal.pojo.TopicsComment;

public interface TopicsCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TopicsComment record);

    int insertSelective(TopicsComment record);

    TopicsComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TopicsComment record);

    int updateByPrimaryKey(TopicsComment record);
}