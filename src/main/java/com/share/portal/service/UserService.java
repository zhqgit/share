package com.share.portal.service;

import com.share.common.ResponseFormat;
import com.share.portal.pojo.User;

/**
 * Created by  bin
 * Time： 2017/8/15.
 */
public interface UserService {
    ResponseFormat<User> login(String userMessage, String password);

}
