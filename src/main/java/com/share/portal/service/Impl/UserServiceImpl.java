package com.share.portal.service.Impl;

import com.share.common.ResponseFormat;
import com.share.portal.dao.UserMapper;
import com.share.portal.pojo.User;
import com.share.portal.service.UserService;
import com.share.portal.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by  bin
 * Time： 2017/8/15.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseFormat<User> login(String userMessage, String password) {
        int resultCount = userMapper.checkUserMessage(userMessage);
        if(resultCount==0){
            return ResponseFormat.createByErrorMessage("嘿嘿，是不是您的大名或登录账号写错了呀！");
        }
        String md5Password = MD5Util.MD5EncodeUtf8(password);

        User user = userMapper.CheckPassword(userMessage,md5Password);
        if (user == null){
            return ResponseFormat.createByErrorMessage("真是遗憾，密码错了！");
        }

        //将密码置为空
        user.setPassword(StringUtils.EMPTY);
        return ResponseFormat.createBySuccess("登录成功",user);
    }
}
