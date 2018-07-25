package com.xk.p2p.mgrsite.base.controller;

import com.xk.p2p.base.query.IplogQueryObject;
import com.xk.p2p.base.service.IIplogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/** 后台登录日志
 * Created by admin on 2018/6/19.
 */
@Controller
public class IpLogController {

    @Autowired
    private IIplogService iplogService;

    @RequestMapping(value = "ipLog")
    private String ipLog(@ModelAttribute("qo")IplogQueryObject qo, Model model){
        model.addAttribute("pageResult",this.iplogService.query(qo));
        return "ipLog/list";
    }

    /**
     * zhu页面
     */
    @RequestMapping("index")
    public String index(){
        return "main";
    }

}
