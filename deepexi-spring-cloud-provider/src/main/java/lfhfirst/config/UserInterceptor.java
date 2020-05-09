package lfhfirst.config;

import lfhfirst.model.dto.UserDTO;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
        //获取该用户下的角色
        //获取该用户下的角色所拥有的权限
        //对比是否获取该权限，没有获取权限抛出异常
        //有返回true，否则返回false
        return false;
    }
}
