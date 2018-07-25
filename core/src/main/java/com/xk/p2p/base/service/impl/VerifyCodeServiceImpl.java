package com.xk.p2p.base.service.impl;

import com.xk.p2p.base.service.IVerifyCodeService;
import com.xk.p2p.base.util.BidConst;
import com.xk.p2p.base.util.DateUtil;
import com.xk.p2p.base.util.UserContext;
import com.xk.p2p.base.vo.VerifyCodeVO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by admin on 2018/6/21.
 */
@Service
public class VerifyCodeServiceImpl implements IVerifyCodeService {
    @Override
    public void sendVerifyCode(String phoneNumber) {
        VerifyCodeVO vo = UserContext.getVerifyCode();
        //判断:vo==null 或者 vo 的最后发送时间间隔在90秒以上
        if (vo == null || DateUtil.getSecondsBetween(vo.getSendTime(),new Date())> BidConst.SEND_VERIFYCODE_INTERVAL) {
            //发送
            //生成一个验证码
            String code = UUID.randomUUID().toString().substring(0,4);
            StringBuilder content =new StringBuilder(100).append("验证码是:").append(code).append(",请在").append(BidConst.VERIFYCODE_VALIDATE_MIN)
                    .append("分钟内使用");
            System.out.println("发送短信:"+content);
            //创建一个vo并存放到session中
            vo = new VerifyCodeVO(phoneNumber,code,new Date());
            UserContext.setVerifyCode(vo);
        }else {
            //否则抛出一个发送过于频繁的异常
            throw new RuntimeException("发送过于频繁");
        }
    }
}
