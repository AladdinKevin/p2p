package com.xk.p2p.mgrsite.base.controller;

import com.xk.p2p.base.domain.Logininfo;
import com.xk.p2p.base.service.ILogininfoService;
import com.xk.p2p.base.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/** 后台登录
 * Created by admin on 2018/6/19.
 */
@Controller
public class LoginController {
    @Autowired
    private ILogininfoService logininfoService;

    @RequestMapping(method = RequestMethod.POST,value = "login")
    @ResponseBody
    public AjaxResult login(String username, String password, HttpServletRequest request){
        AjaxResult result = new AjaxResult(true);
        Logininfo login = logininfoService.login(username, password, request.getRemoteAddr(), Logininfo.USERTYPE_MANAGER);
        if (login == null){
            result = new AjaxResult(false,"登录失败");
        }
        return result;
    }

}
