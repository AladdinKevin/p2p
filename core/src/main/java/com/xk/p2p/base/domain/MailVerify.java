package com.xk.p2p.base.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by admin on 2018/6/27.
 */
@Setter
@Getter
public class MailVerify extends BaseDomain {
    private String uuid;
    private String email;
    private Date   sendTime;
    private long   userId;
}
