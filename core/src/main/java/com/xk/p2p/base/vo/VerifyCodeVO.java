package com.xk.p2p.base.vo;

import java.util.Date;

/**用于临时存放验证码发送相关信息的值对象
 * Created by admin on 2018/6/21.
 */
public class VerifyCodeVO {

    private String phoneNumber;
    private String verifyCode;
    private Date   sendTime;

    public VerifyCodeVO(String phoneNumber, String verifyCode, Date sendTime) {
        this.phoneNumber = phoneNumber;
        this.verifyCode = verifyCode;
        this.sendTime = sendTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
