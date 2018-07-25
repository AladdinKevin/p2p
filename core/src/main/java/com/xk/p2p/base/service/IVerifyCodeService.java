package com.xk.p2p.base.service;

/**
 * Created by admin on 2018/6/21.
 */
public interface IVerifyCodeService {

    /**
     * 发送短信验证码
     * @param phoneNumber
     */
    void sendVerifyCode(String phoneNumber);
}
