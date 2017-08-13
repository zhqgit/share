package com.share.portal.dao;

import com.share.portal.pojo.PersonalResourceCategory;

public interface PersonalResourceCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonalResourceCategory record);

    int insertSelective(PersonalResourceCategory record);

    PersonalResourceCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonalResourceCategory record);

    int updateByPrimaryKey(PersonalResourceCategory record);
}