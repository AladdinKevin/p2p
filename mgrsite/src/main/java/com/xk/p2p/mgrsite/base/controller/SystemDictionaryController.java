package com.xk.p2p.mgrsite.base.controller;

import com.xk.p2p.base.domain.SystemDictionary;
import com.xk.p2p.base.domain.SystemDictionaryItem;
import com.xk.p2p.base.query.SystemDictionaryQueryObject;
import com.xk.p2p.base.service.ISystemDictionaryService;
import com.xk.p2p.base.util.AjaxResult;
import com.xk.p2p.mgrsite.base.util.RequiredLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("systemDictionary_update")
    @ResponseBody
    public AjaxResult updateDic(SystemDictionary dic){
        this.dictionaryService.saveOrUpdateDic(dic);
        return new AjaxResult(true);
    }

    /**
     * 数据字典明细
     */
    @RequestMapping("systemDictionaryItem_list")
    @RequiredLogin
    public String listDicItems(@ModelAttribute("qo")SystemDictionaryQueryObject qo, Model model){
        model.addAttribute("pageResult",this.dictionaryService.queryDicItems(qo));
        model.addAttribute("systemDictionaryGroups",this.dictionaryService.queryDicsListAll());
        return "systemdic/systemDictionaryItem_list";
    }

    /**
     * 添加/修改数据字典明细
     */
    @RequestMapping("systemDictionaryItem_update")
    @ResponseBody
    public AjaxResult updateItems(SystemDictionaryItem item){
        this.dictionaryService.saveOrUpdateDicItem(item);
        return new AjaxResult(true);
    }

}
