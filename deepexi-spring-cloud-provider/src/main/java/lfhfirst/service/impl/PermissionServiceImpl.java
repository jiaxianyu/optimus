package lfhfirst.service.impl;

import lfhfirst.manager.UserManager;
import lfhfirst.model.vo.PermissionVO;
import lfhfirst.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private UserManager userManager;

    public List<PermissionVO> getListByRoleIds(List<Integer> roleIds){
        return null;
    }

}
