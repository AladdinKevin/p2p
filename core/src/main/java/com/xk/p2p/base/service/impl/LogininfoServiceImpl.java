package com.xk.p2p.base.service.impl;

import com.xk.p2p.base.domain.Account;
import com.xk.p2p.base.domain.Iplog;
import com.xk.p2p.base.domain.Logininfo;
import com.xk.p2p.base.domain.Userinfo;
import com.xk.p2p.base.mapper.IplogMapper;
import com.xk.p2p.base.mapper.LogininfoMapper;
import com.xk.p2p.base.service.IAccountService;
import com.xk.p2p.base.service.ILogininfoService;
import com.xk.p2p.base.service.IUserinfoService;
import com.xk.p2p.base.util.MD5;
import com.xk.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.management.LockInfo;
import java.util.Date;

/** day01 - 07
 * Created by kevin on 2017/12/25.
 */
@Service
public class LogininfoServiceImpl implements ILogininfoService {

    @Autowired
    private LogininfoMapper logininfoMapper;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IUserinfoService userinfoService;
    @Autowired
    private IplogMapper iplogMapper;
    @Override
    public Logininfo register(String username, String password) {
        //1.判断用户名是否重复
        Long count = logininfoMapper.selectCountByUsername(username);
        //2.如果重复,抛出异常,提示用户名已存在
        if (count > 0) {
            throw new RuntimeException("当前用户名已存在!");
        }
        //3.如果不存在,保存对象入库
        Logininfo logininfo = new Logininfo();
        logininfo.setUsername(username);
        logininfo.setPassword(MD5.encode(password));
        logininfo.setState(Logininfo.STATE_NORMAL);
        //设置前台用户
        logininfo.setUserType(Logininfo.USERTYPE_NORMAL);
        int insertCount = logininfoMapper.insert(logininfo);

        //初始化account和userinfo
        Account account = new Account();
        account.setId(logininfo.getId());
        this.accountService.save(account);
        Userinfo userinfo = new Userinfo();
        userinfo.setId(logininfo.getId());
        this.userinfoService.save(userinfo);
        return logininfo;
    }

    @Override
    public Logininfo login(String username, String password,String ip, int userType) {
        //创建一个登录日志对象
        Iplog log = new Iplog();
        log.setIp(ip);
        log.setLoginTime(new Date());
        log.setUsername(username);
        log.setUserType(userType);

        Logininfo logininfo = logininfoMapper.login(username,MD5.encode(password),userType);
        if (null == logininfo){
            log.setState(Iplog.STATE_FAILED);
        }else {
            //将对象放到session中
            log.setState(Iplog.STATE_SUCCESS);
            UserContext.setCurrent(logininfo);
        }
        this.iplogMapper.insert(log);
        return logininfo;
    }

    @Override
    public Boolean checkUsername(String username) {
        return this.logininfoMapper.selectCountByUsername(username) > 0;
    }

    @Override
    public void initAdmin() {
        //检查管理员的个数
        int count = this.logininfoMapper.selectCountByUserType(Logininfo.USERTYPE_MANAGER);
        //如果没有管理员,创建第一个管理员
        if (count <= 0){
            Logininfo admin = new Logininfo();
            admin.setUsername("admin");
            admin.setPassword(MD5.encode("1111"));
            admin.setState(Logininfo.STATE_NORMAL);
            admin.setUserType(Logininfo.USERTYPE_MANAGER);
            this.logininfoMapper.insert(admin);
        }
    }
}
