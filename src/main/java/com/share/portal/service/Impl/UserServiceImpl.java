package com.share.portal.service.Impl;

import com.github.pagehelper.PageInfo;
import com.share.common.Const;
import com.share.common.ResponseFormat;
import com.share.portal.dao.ResourceFavoriteMapper;
import com.share.portal.dao.ResourceMapper;
import com.share.portal.dao.TopicsMapper;
import com.share.portal.dao.UserMapper;
import com.share.portal.pojo.Resource;
import com.share.portal.pojo.ResourceFavorite;
import com.share.portal.pojo.User;
import com.share.portal.service.UserService;
import com.share.portal.util.EmailUtil;
import com.share.portal.util.IdentifyingCodeUtil;
import com.share.portal.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import static com.share.portal.util.EmailUtil.SMTP_163;

/**
 * Created by  bin
 * Time： 2017/8/15.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private TopicsMapper topicsMapper;

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

    @Override
    public ResponseFormat<String> changePassword(String identifyingCode, String passwordOld, String passwordNew, User user) {
        return null;
    }

    @Override
    public ResponseFormat<String> getIdentifyingCode(User user) throws MessagingException{
        EmailUtil emailUtil = new EmailUtil();
        String identifyingCode = new IdentifyingCodeUtil().NumberAndLetter(6);
        String UserEmail = userMapper.getUserEmail(user.getId());
        EmailUtil.config(SMTP_163(false), "fight_share@163.com", "share123456");
        emailUtil.subject("重置密码信息验证")
                 .from("职业教育学院资源共享品台")
                 .to("jwyb2014@163.com")
                 .text("你重置密码的验证码为："+identifyingCode)
                 .send();
        return ResponseFormat.createBySuccess(identifyingCode);
    }

    public ResponseFormat<List<PageInfo>> resourceFavorite(int userId){

        List<ResourceFavorite> resourceFavoriteList = resourceMapper.selectResourceFavoriteById(userId);
        PageInfo pageInfoResource = new PageInfo(resourceFavoriteList);

        List<ResourceFavorite> topicsFavoriteList = topicsMapper.selectTopicsFavoriteById(userId);
        PageInfo pageInfoTopics = new PageInfo(topicsFavoriteList);

        List<PageInfo> favoriteList = new ArrayList<>();
        favoriteList.add(pageInfoResource);
        favoriteList.add(pageInfoTopics);
        return ResponseFormat.createBySuccess(favoriteList);


    }
}
