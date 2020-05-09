package lfhfirst.service.impl;

import lfhfirst.manager.UserManager;
import lfhfirst.model.dto.RoleDTO;
import lfhfirst.model.entity.RoleDO;
import lfhfirst.model.vo.RoleVO;
import lfhfirst.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.deepexi.pojo.converter.utils.ConverterUtils.convert;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private UserManager userManager;

    @Override
    public RoleVO create(RoleDTO roleDTO) {
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
}
