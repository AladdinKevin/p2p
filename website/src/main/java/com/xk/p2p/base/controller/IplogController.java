package com.xk.p2p.base.controller;

import com.xk.p2p.base.query.IplogQueryObject;
import com.xk.p2p.base.service.IIplogService;
import com.xk.p2p.base.util.RequireLogin;
import com.xk.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**前台登录日志查看
 * Created by admin on 2018/6/15.
 */
@Controller
public class IplogController {

    @Autowired
    private IIplogService iplogService;

    @RequireLogin
    @RequestMapping("/ipLog")
    public String ipLog(@ModelAttribute("qo") IplogQueryObject qo, Model model){
        qo.setUsername(UserContext.getCurrent().getUsername());
        model.addAttribute("pageResult",this.iplogService.query(qo));
        return "iplog_list";
    }
}
