package com.xk.p2p.base.query;

import com.xk.p2p.base.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import java.util.Date;

/** 登录日志查询对象
 * Created by admin on 2018/6/15.
 */
public class IplogQueryObject extends QueryObject {

    private Date beginDate;
    private Date endDate;
    private int  state = -1;
    private String username;
    private int userType = -1;

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate == null ? null : DateUtil.getLastTimeOfTheDay(endDate);
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUsername() {
        return StringUtils.hasLength(username) ? username :null;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
