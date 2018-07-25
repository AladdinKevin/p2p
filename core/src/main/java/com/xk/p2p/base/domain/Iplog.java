package com.xk.p2p.base.domain;

import java.util.Date;

/** 登录日志
 * Created by admin on 2018/6/14.
 */
public class Iplog extends BaseDomain {

    public static final int STATE_SUCCESS = 0;
    public static final int STATE_FAILED = 1;

    private String ip;
    private Date   loginTime;
    private String username;
    private int    state;
    private int    userType;//登录用户的类型

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateDisplay(){
        return state==STATE_SUCCESS?"登陆成功":"登录失败";
    }

    public String getUserTypeDisplay(){
        return this.userType==Logininfo.USERTYPE_MANAGER ? "管理员" : "用户";
    }
}
