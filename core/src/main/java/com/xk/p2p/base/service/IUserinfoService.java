package com.xk.p2p.base.service;

import com.xk.p2p.base.domain.Userinfo;

/**
 * Created by admin on 2018/6/13.
 */
public interface IUserinfoService {
    void update(Userinfo userinfo);

    void save(Userinfo userinfo);

    Userinfo get(Long id);

    /**
     * 绑定手机
     * @param phoneNumber
     * @param verifyCode
     */
    void bindPhone(String phoneNumber, String verifyCode);

    /**
     * 绑定邮箱
     * @param uuid
     */
    void bindEmail(String uuid);
}
