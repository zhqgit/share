package com.share.portal.dao;

import com.share.portal.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUserMessage(String userMessage);

    User CheckPassword(@Param("userMessage")String userMessage,@Param("md5Password")String md5Password);

    String getUserEmail(int userId);
}