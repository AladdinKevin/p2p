package com.xk.p2p.base.service;

/** 验证邮件相关服务
 * Created by admin on 2018/7/5.
 */
public interface IMailVerifyService {

    /**
     * 发送邮件
     * @param email
     */
    void sendEmail(String email);
}
