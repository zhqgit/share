package com.share.portal.dao;

import com.share.portal.pojo.PersonalTopicsCategory;

public interface PersonalTopicsCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonalTopicsCategory record);

    int insertSelective(PersonalTopicsCategory record);

    PersonalTopicsCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonalTopicsCategory record);

    int updateByPrimaryKey(PersonalTopicsCategory record);
}