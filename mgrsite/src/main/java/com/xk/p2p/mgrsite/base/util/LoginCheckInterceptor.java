package com.xk.p2p.mgrsite.base.util;

import com.xk.p2p.base.util.UserContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 后台 登录拦截器
 * Created by admin on 2018/6/15.
 */
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if (o!=null && o instanceof HandlerMethod){
            HandlerMethod hm = (HandlerMethod) o;
            if (hm.getMethodAnnotation(RequiredLogin.class)!=null && UserContext.getCurrent()==null){
                response.sendRedirect("/login.html");
                return false;
            }
        }
        //放行
        return true;
    }

}
