package com.xk.p2p.base.service.impl;

import com.xk.p2p.base.domain.MailVerify;
import com.xk.p2p.base.domain.Userinfo;
import com.xk.p2p.base.mapper.MailverifyMapper;
import com.xk.p2p.base.mapper.UserinfoMapper;
import com.xk.p2p.base.service.IMailVerifyService;
import com.xk.p2p.base.service.IUserinfoService;
import com.xk.p2p.base.util.BidConst;
import com.xk.p2p.base.util.BitStatesUtils;
import com.xk.p2p.base.util.DateUtil;
import com.xk.p2p.base.util.UserContext;
import com.xk.p2p.base.vo.VerifyCodeVO;
import org.omg.CORBA.ULongLongSeqHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by admin on 2018/6/13.
 */
@Service
public class UserinfoServiceImpl implements IUserinfoService {
    @Autowired
    private UserinfoMapper userinfoMapper;
    @Autowired
    private MailverifyMapper mailverifyMapper;

    @Override
    public void update(Userinfo userinfo) {
        int count = this.userinfoMapper.updateByPrimaryKey(userinfo);
        if (count<=0){
            throw new RuntimeException("乐观锁失败,Userinfo:" +userinfo.getId());
        }
    }

    @Override
    public void save(Userinfo userinfo) {
        this.userinfoMapper.insert(userinfo);
    }

    @Override
    public Userinfo get(Long id) {
        return this.userinfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void bindPhone(String phoneNumber, String verifyCode) {
        Userinfo current = this.get(UserContext.getCurrent().getId());
        VerifyCodeVO vo = UserContext.getVerifyCode();
        //1.用户是否绑定了手机
        if (!current.getHasBindPhone()
                && vo!= null
                && vo.getVerifyCode().equalsIgnoreCase(verifyCode)//2.验证码相同
                && vo.getPhoneNumber().equalsIgnoreCase(phoneNumber)//3.手机号码相同
                && DateUtil.getSecondsBetween(vo.getSendTime(),new Date())<= BidConst.VERIFYCODE_VALIDATE_MIN*3600//4.验证码没有过期
                ){
            //5.给用户添加一个绑定手机状态码,并设置phoneNumber
            current.setBitState(BitStatesUtils.addState(current.getBitState(),BitStatesUtils.OP_BIND_PHONE));
            current.setPhoneNumber(phoneNumber);
            this.update(current);
        }else {
            throw new RuntimeException("绑定手机失败!");
        }
    }

    /**
     * 绑定邮箱
     * @param uuid
     */
    @Override
    public void bindEmail(String uuid) {
        //查询邮件验证对象
        MailVerify mv = this.mailverifyMapper.selectByUUID(uuid);
        if (null!=mv){
            //判断:
            Userinfo uf = this.userinfoMapper.selectByPrimaryKey(mv.getUserId());
            if (!uf.getHasBindEmail()  //1.用户没有绑定邮箱
                    && DateUtil.getSecondsBetween(mv.getSendTime(),new Date()) < BidConst.VERIFYMAIL_VALIDATE_DAY*24*3600){
                //2.在有效期之内
                //给用户添加状态码
                uf.setBitState(BitStatesUtils.addState(uf.getBitState(),BitStatesUtils.OP_BIND_EMAIL));
                //设置用户的email属性
                uf.setEmail(mv.getEmail());
                this.update(uf);
                return;
            }else {
                throw new RuntimeException("邮箱验证失败!");
            }

        }

    }


}
