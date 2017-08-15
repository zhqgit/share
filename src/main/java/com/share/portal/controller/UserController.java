package com.share.portal.controller;

import com.share.common.Const;
import com.share.common.ResponseFormat;
import com.share.portal.pojo.User;
import com.share.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by  bin
 * Time： 2017/8/15.
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="login.do",method = RequestMethod.POST)
    @ResponseBody
    public ResponseFormat<User> login(String userMessage, String password, HttpSession session){
        ResponseFormat<User> response = userService.login(userMessage,password);
        if(response.isSuccess()){

            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

    @RequestMapping(value="get_user_info.do",method = RequestMethod.POST)
    @ResponseBody
    public ResponseFormat<User> geUserInfo(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user!=null){
            return ResponseFormat.createBySuccess(user);
        }
        //test
        return ResponseFormat.createByErrorMessage("用户未登录，获取用户信息失败");
    }
}
