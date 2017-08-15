package com.share.portal.dao;

import com.share.portal.pojo.TopicsReport;

public interface TopicsReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TopicsReport record);

    int insertSelective(TopicsReport record);

    TopicsReport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TopicsReport record);

    int updateByPrimaryKeyWithBLOBs(TopicsReport record);

    int updateByPrimaryKey(TopicsReport record);
}