package com.xk.p2p.base.util;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**登录检查拦截器
 * Created by admin on 2018/6/15.
 */
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
    /**
        HandlerInterceptorAdapter 是接口 HandlerInterceptor的适配器类
        当我们只需要实现 HandlerInterceptor 接口 某几个类的时候, 只需要
        继承 HandlerInterceptorAdapter 接口 并且复写需要的方法即可
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        //判断当前请求方法上面是否有requreLogin标签,如果有,但是当前没有用户登录,跳转到登录页面
        if (handler != null && handler instanceof HandlerMethod){
            HandlerMethod hm = (HandlerMethod) handler;
            if (hm.getMethodAnnotation(RequireLogin.class)!= null && UserContext.getCurrent()==null){
                response.sendRedirect("/login.html");
                return false;
            }
        }
        //否则放行
        return true;
    }
}
