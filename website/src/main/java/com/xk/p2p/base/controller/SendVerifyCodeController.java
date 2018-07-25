package com.xk.p2p.base.controller;

import com.xk.p2p.base.service.IVerifyCodeService;
import com.xk.p2p.base.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/** 发送短信验证码
 * Created by admin on 2018/6/21.
 */
@Controller
public class SendVerifyCodeController {

    @Autowired
    private IVerifyCodeService verifyCodeService;

    @RequestMapping(method = RequestMethod.POST,value = "sendVerifyCode")
    @ResponseBody
    public AjaxResult SendVerifyCode(String phoneNumber){
        AjaxResult result = new AjaxResult(true);
        try {
            this.verifyCodeService.sendVerifyCode(phoneNumber);
        }catch (Exception e){
            result = new AjaxResult(false, e.getMessage());
        }
        return result;
    }



}
