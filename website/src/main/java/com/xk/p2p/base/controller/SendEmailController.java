package com.xk.p2p.base.controller;

import com.xk.p2p.base.service.IMailVerifyService;
import com.xk.p2p.base.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 发送验证邮件控制器
 * Created by admin on 2018/6/29.
 */
@Controller
public class SendEmailController {
    @Autowired
    private IMailVerifyService mailVerifyService;
      /*
    * 绑定邮箱
    */
    @RequestMapping("sendEmail")
    @ResponseBody
    public AjaxResult sendEmail(String email){
        AjaxResult result = new AjaxResult(true);
        try {
            this.mailVerifyService.sendEmail(email);
        }catch (Exception e){
            result = new AjaxResult(false,e.getMessage());
        }
        return result;
    }


}
