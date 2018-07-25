package com.xk.p2p.base.util;

import java.math.BigDecimal;

/**
 * 系统中的全局常量
 * Created by admin on 2018/6/14.
 */
public class BidConst {
    /*
    * 显示精度
    */
    public static int DISPLAY_SCALE = 2;
    /*
    * 存储精度
    */
    public static int STORE_SCALE = 4;
    /*
    * 计算精度(一般都是存储精度的2倍)
    */
    public static int CAL_SCALE = 8;
    /*
    * 定义系统中的0
    */
    public static BigDecimal ZERO = new BigDecimal("0.0000");
    /*
    * 用户初始信用额度
    */
    public static BigDecimal INIT_BORROW_LIMIT = new BigDecimal("3000.0000");
    /**
     * 发送短信验证码的间隔时间
     */
    public static final int SEND_VERIFYCODE_INTERVAL = 90;
    /**
     * 验证码的有效期(分钟)
     */
    public static final int VERIFYCODE_VALIDATE_MIN = 3;
    /**
     * 验证邮件的有效期(天)
     */
    public static final int VERIFYMAIL_VALIDATE_DAY = 5;

    /**
     * 能够信用借款的风控材料基本分数
     */
    public static final int BORROW_SCORE_LIMIT = 30;
}
