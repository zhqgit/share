package com.share.portal.service;

import com.github.pagehelper.PageInfo;
import com.share.common.ResponseFormat;
import com.share.portal.pojo.User;

import javax.mail.MessagingException;
import java.util.List;

/**
 * Created by  bin
 * Time： 2017/8/15.
 */
public interface UserService {
    ResponseFormat<User> login(String userMessage, String password);

    ResponseFormat<String> changePassword(String identifyingCode, String passwordOld, String passwordNew, User user);

    ResponseFormat<String> getIdentifyingCode(User user) throws MessagingException;

    ResponseFormat<List<PageInfo>> resourceFavorite(int userId);
}
