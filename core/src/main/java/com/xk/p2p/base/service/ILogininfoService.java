package com.xk.p2p.base.service;

import com.xk.p2p.base.domain.Logininfo;

/**
 * Created by kevin on 2017/12/25.
 */
public interface ILogininfoService {

    /**
     * 注册用户
     * @param username
     * @param password
     * @return
     */
    Logininfo register (String username,String password);

    Logininfo login(String username, String password,String ip, int userType);

    Boolean checkUsername(String username);

    /**
     * 初始化第一个管理员
     */
    void initAdmin();
}
