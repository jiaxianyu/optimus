package lfhfirst.repo;

import lfhfirst.mapper.RoleMapper;
import lfhfirst.model.dto.RoleDTO;
import lfhfirst.model.entity.RoleDO;
import lfhfirst.model.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RoleRepository {

    @Autowired
    private RoleMapper roleMapper;

    public void create(RoleDO roleDO) {
        roleMapper.insert(roleDO);
    }

    public void removeById(Integer roleId) {
        roleMapper.deleteById(roleId);
    }

    public RoleDTO update(RoleDO roleDO) {
        return null;
    }
}
