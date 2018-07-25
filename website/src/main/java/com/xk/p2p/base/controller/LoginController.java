package com.xk.p2p.base.controller;

import com.xk.p2p.base.domain.Logininfo;
import com.xk.p2p.base.service.ILogininfoService;
import com.xk.p2p.base.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 2018/6/4.
 */
@Controller
public class LoginController {
    @Autowired
    private ILogininfoService logininfoService;
    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "login")
    @ResponseBody
    public AjaxResult login(String username, String password, HttpServletRequest request){
        AjaxResult result = new AjaxResult(true);
            Logininfo logininfo = logininfoService.login(username,password,request.getRemoteAddr(),Logininfo.USERTYPE_NORMAL);
            if (logininfo==null){
                result=new AjaxResult("用户名或密码错误");
            }
        return result;
    }
}
