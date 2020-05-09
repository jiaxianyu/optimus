package lfhfirst.domain.entity;

import lfhfirst.model.vo.PermissionVO;
import lfhfirst.model.vo.RoleVO;
import lfhfirst.repo.RoleAndPermissionIntermediateRepository;

import java.util.List;

public class RoleAndPermissionIntermediate {
    private RoleAndPermissionIntermediateRepository roleAndPermissionIntermediateRepository;


    public List<PermissionVO> getListByRoleId(Integer roleId) {
        return null;
    }
}
