package com.xk.p2p.base.controller;

import com.xk.p2p.base.domain.Logininfo;
import com.xk.p2p.base.service.ILogininfoService;
import com.xk.p2p.base.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by kevin on 2017/12/27.
 */
@Controller
public class RegisterController {

    @Autowired
    private ILogininfoService logininfoService;

    @RequestMapping("register")
    @ResponseBody
    public AjaxResult register(String username, String password){
        AjaxResult result = null;
        try {
            Logininfo register = logininfoService.register(username, password);
            if (register!=null) {
                result = new AjaxResult(true,"注册成功");
                System.out.println("test");
            }else {
                result = new AjaxResult(false,"注册失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            result = new AjaxResult(false,e.getMessage());
        }
        return result;
    }

    @RequestMapping("checkUsername")
    @ResponseBody
    public Boolean checkUsername(String username){
        return !this.logininfoService.checkUsername(username);
    }
}
