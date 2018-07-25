package com.xk.p2p.mgrsite.listeners;

import com.xk.p2p.base.service.ILogininfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/** 初始化管理员监听器
 * Created by admin on 2018/6/19.
 */
@Component
public class InitAdminListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ILogininfoService logininfoService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.logininfoService.initAdmin();
    }
}
