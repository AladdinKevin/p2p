package com.xk.p2p.base.util;

import com.xk.p2p.base.domain.Logininfo;
import com.xk.p2p.base.vo.VerifyCodeVO;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 2018/6/4.
 */
public class UserContext {
    public static final String USER_IN_SESSION = "logininfo";
    public static final String VERIFYCODE_IN_SESSION = "verifyCodeVO";
    private UserContext(){}
    public static HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
    public static void setCurrent(Logininfo logininfo){
        getRequest().getSession().setAttribute(USER_IN_SESSION,logininfo);
    }
    public static Logininfo getCurrent(){
      return (Logininfo) getRequest().getSession().getAttribute(USER_IN_SESSION);
    }

    public static void setVerifyCode(VerifyCodeVO vo){
        getRequest().getSession().setAttribute(VERIFYCODE_IN_SESSION,vo);
    }
    public static VerifyCodeVO getVerifyCode(){
        return (VerifyCodeVO) getRequest().getSession().getAttribute(VERIFYCODE_IN_SESSION);
    }
}
