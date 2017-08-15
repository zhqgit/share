package com.share.portal.dao;

import com.share.portal.pojo.ResourceReport;

public interface ResourceReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResourceReport record);

    int insertSelective(ResourceReport record);

    ResourceReport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResourceReport record);

    int updateByPrimaryKeyWithBLOBs(ResourceReport record);

    int updateByPrimaryKey(ResourceReport record);
}