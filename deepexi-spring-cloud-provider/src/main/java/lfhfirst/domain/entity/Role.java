package lfhfirst.domain.entity;

import lfhfirst.model.dto.RoleDTO;
import lfhfirst.model.entity.RoleDO;
import lfhfirst.model.vo.RoleVO;
import lfhfirst.repo.RoleRepository;

import static com.deepexi.pojo.converter.utils.ConverterUtils.convert;
import static com.deepexi.pojo.converter.utils.ConverterUtils.convertAll;

public class Role {

    private RoleRepository roleRepository;

    public RoleVO createRole(RoleDO roleDO) {
        roleRepository.create(roleDO);
        return convert(roleDO, RoleVO.class);
    }

    public void removeRole(Integer roleId) {
        roleRepository.removeById(roleId);
    }

    public RoleVO update(RoleDTO roleDTO) {
        RoleDTO newRoleDTO = roleRepository.update(convert(roleDTO, RoleDO.class));
        return  convert(newRoleDTO,RoleVO.class);
    }
}