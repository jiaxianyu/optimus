package lfhfirst.util;

import lfhfirst.model.dto.UserDTO;
import lfhfirst.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class UserInfoUtils {

    @Autowired
    private RoleService roleService;

    public static boolean checkPermission(HttpServletRequest request,String requestUrl){
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");
        //获取该用户下的角色
        //获取该用户下的角色所拥有的权限
        //有返回true，否则返回false
        return false;
    }

}
