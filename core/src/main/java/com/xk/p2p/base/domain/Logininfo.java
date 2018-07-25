package com.xk.p2p.base.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by kevin on 2017/12/25.
 */
@Setter
@Getter
public class Logininfo extends BaseDomain{
    public static final int STATE_NORMAL = 0;
    public static final int STATE_LOCK = 1;

    public static final int USERTYPE_NORMAL=0;//普通用户
    public static final int USERTYPE_MANAGER=1;//后台管理员
    private String username;
    private String password;
    private int state;
    private int userType;
}
