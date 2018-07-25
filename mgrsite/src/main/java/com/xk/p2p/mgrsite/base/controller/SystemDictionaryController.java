package com.xk.p2p.mgrsite.base.controller;

import com.xk.p2p.base.query.SystemDictionaryQueryObject;
import com.xk.p2p.base.service.ISystemDictionaryService;
import com.xk.p2p.mgrsite.base.util.RequiredLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/** 系统数据字典控制器
 * Created by admin on 2018/7/16.
 */
@Controller
public class SystemDictionaryController {

    @Autowired
    private ISystemDictionaryService dictionaryService;

    @RequestMapping("systemDictionary_list")
    @RequiredLogin
    public String listDics(@ModelAttribute("qo")SystemDictionaryQueryObject qo, Model model){
       model.addAttribute("pageResult",this.dictionaryService.queryDics(qo));
       return "systemdic/systemDictionary_list";
    }
}
