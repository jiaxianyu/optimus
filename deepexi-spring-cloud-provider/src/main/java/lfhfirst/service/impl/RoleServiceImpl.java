package lfhfirst.service.impl;

import lfhfirst.manager.UserManager;
import lfhfirst.model.dto.RoleDTO;
import lfhfirst.model.entity.RoleDO;
import lfhfirst.model.vo.PermissionVO;
import lfhfirst.model.vo.RoleVO;
import lfhfirst.model.vo.UserVO;
import lfhfirst.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.deepexi.pojo.converter.utils.ConverterUtils.convert;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private UserManager userManager;

    @Override
    public RoleVO create(RoleDTO roleDTO) {
        //检查是否已存在同名角色
        //不存在就创建
        return userManager
                .current()
                .getRole()
                .createRole(convert(roleDTO, RoleDO.class));
    }

    @Override
    public void removeById(Integer roleId) {
        userManager
                .current()
                .getUserAndRoleIntermediate()
                .removeUserAndRoleIntermediateByRoleId(roleId);

        userManager
                .current()
                .getUserAndRoleIntermediate()
                .removeRoleAndAuthIntermediateByRoleId(roleId);

        userManager
                .current()
                .getRole()
                .removeRole(roleId);
    }

    @Override
    public RoleVO update(RoleDTO roleDTO) {
        userManager
                .current()
                .getRole()
                .update(roleDTO);
        return convert(roleDTO,RoleVO.class);
    }

    @Override
    public List<RoleVO> getList(Integer roleId) {
        //获取角色下所有用户
        List<UserVO> userVOS = userManager
                .current()
                .getUserAndRoleIntermediate()
                .getListByRoleId(roleId);
        //获取该角色下的所有权限
        List<PermissionVO> permissionVOS = userManager
                .current()
                .getRoleAndPermissionIntermediate()
                .getListByRoleId(roleId);
        //封装信息返回
        return null;
    }


}
