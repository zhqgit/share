package com.share.portal.controller;

import com.github.pagehelper.PageInfo;
import com.share.common.Const;
import com.share.common.ResponseFormat;
import com.share.portal.pojo.User;
import com.share.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.util.List;

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
        return ResponseFormat.createByErrorMessage("用户未登录，请先登录！");
    }

    @RequestMapping(value="change_password.do",method = RequestMethod.POST)
    @ResponseBody
    public ResponseFormat<String> changePassword(String identifyingCode, String passwordOld,String passwordNew,HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ResponseFormat.createByErrorMessage("用户未登录，请先登录！");
        }
        return userService.changePassword(identifyingCode,passwordOld,passwordNew,user);
    }

    @RequestMapping(value="get_identifying_Code.do",method = RequestMethod.GET)
    @ResponseBody
    public ResponseFormat<String> getIdentifyingCode(HttpSession session) throws MessagingException {
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ResponseFormat.createByErrorMessage("用户未登录，请先登录！");
        }
        return userService.getIdentifyingCode(user);
    }

    /*
    * 用户的收藏夹列表，包括资源列表和
    * */
    @RequestMapping(value="favorite.do",method = RequestMethod.GET)
    @ResponseBody
    public ResponseFormat<List<PageInfo>> resourceFavorite(HttpSession session) throws MessagingException {
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ResponseFormat.createByErrorMessage("用户未登录，请先登录！");
        }
        return userService.resourceFavorite(user.getId());
    }


}
