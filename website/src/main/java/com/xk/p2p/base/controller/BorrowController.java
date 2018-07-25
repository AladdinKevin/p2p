package com.xk.p2p.base.controller;

import com.xk.p2p.base.domain.Logininfo;
import com.xk.p2p.base.service.IAccountService;
import com.xk.p2p.base.service.IUserinfoService;
import com.xk.p2p.base.util.BidConst;
import com.xk.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/** 借款相关控制器
 * Created by admin on 2018/7/12.
 */
@Controller
public class BorrowController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IUserinfoService userinfoService;
    /**
     * 我要借款的首页
     */
    @RequestMapping("borrow")
    public String borrowIndex(Model model){
        if (UserContext.getCurrent()==null){
            //没有登录直接重定向到borrow.html
            return "redirect:/borrow.html";
        }else {
            //已经登录,跳转到borrow.ftl
            //查询用户account
            Logininfo current = UserContext.getCurrent();
            model.addAttribute("account",this.accountService.get(current.getId()));
            //查询用户信息userinfo
            model.addAttribute("userinfo",this.userinfoService.get(current.getId()));
            //creditBorrowScore基本信用分数的常量
            model.addAttribute("creditBorrowScore", BidConst.BORROW_SCORE_LIMIT);
            return "borrow";
        }
    }

}
