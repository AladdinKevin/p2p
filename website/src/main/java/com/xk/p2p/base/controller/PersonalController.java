package com.xk.p2p.base.controller;

import com.xk.p2p.base.domain.Logininfo;
import com.xk.p2p.base.service.IAccountService;
import com.xk.p2p.base.service.IUserinfoService;
import com.xk.p2p.base.util.AjaxResult;
import com.xk.p2p.base.util.RequireLogin;
import com.xk.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 个人中心控制器
 * Created by admin on 2018/6/14.
 */
@Controller
public class PersonalController {
    @Autowired
    private IUserinfoService userinfoService;
    @Autowired
    private IAccountService accountService;

    /**
     * 个人中心首页
     * @param model
     * @return
     */
    @RequireLogin
    @RequestMapping("personal")
    public String personal(Model model){
        Logininfo current = UserContext.getCurrent();
        model.addAttribute("account",this.accountService.get(current.getId()));
        model.addAttribute("userinfo",this.userinfoService.get(current.getId()));
        return "personal";
    }

    /**
     * 绑定手机
     */
    @RequestMapping("bindPhone")
    @ResponseBody
    public AjaxResult bindPhone(String phoneNumber, String verifyCode){
        AjaxResult result = new AjaxResult(true);
        try {
            this.userinfoService.bindPhone(phoneNumber,verifyCode);
        }catch (RuntimeException e){
            result = new AjaxResult(false,e.getMessage());
        }
        return result;
    }

    /**
     * 绑定邮箱
     * @param uuid
     * @return
     */
    @RequestMapping("bindEmail")
    public String bindEmail(String uuid,Model model){
        try {
            this.userinfoService.bindEmail(uuid);
            model.addAttribute("success",true);
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("success",false);
            model.addAttribute("msg",e.getMessage());
        }
        return "checkmail_result";
    }

}
