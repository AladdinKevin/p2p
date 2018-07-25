package com.xk.p2p.base.service.impl;

import com.xk.p2p.base.domain.MailVerify;
import com.xk.p2p.base.domain.Userinfo;
import com.xk.p2p.base.mapper.MailverifyMapper;
import com.xk.p2p.base.service.IMailVerifyService;
import com.xk.p2p.base.service.IUserinfoService;
import com.xk.p2p.base.util.BidConst;
import com.xk.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by admin on 2018/7/5.
 */
@Service
public class MailVerifyServiceImpl implements IMailVerifyService {
    @Autowired
    private MailverifyMapper mailverifyMapper;
    @Autowired
    private IUserinfoService userinfoService;
    @Value("${mail.hostUrl}")
    private String applicationHost;
    /**
     * 发送邮件
     * @param email
     */
    @Override
    public void sendEmail(String email) {
        //判断用户没有绑定邮箱
        Userinfo current = this.userinfoService.get(UserContext.getCurrent().getId());
        if (!current.getHasBindEmail()){
            //创建一个邮件的内容
            String uuid = UUID.randomUUID().toString();
            StringBuilder content = new StringBuilder(100).append("点击<a href '").append(applicationHost).append("bindEmail.do?uuid=").append(uuid).append("'>这里完成邮箱绑定,有效期为").append(BidConst.VERIFYMAIL_VALIDATE_DAY);
            //发送邮件
            System.out.println(content);
            //创建一个mv对象
            MailVerify mv = new MailVerify();
            mv.setEmail(email);
            mv.setSendTime(new Date());
            mv.setUserId(UserContext.getCurrent().getId());
            mv.setUuid(uuid);
            //保存
            this.mailverifyMapper.insert(mv);
        }
    }
}
