package lfhfirst.service;

import lfhfirst.model.dto.RoleDTO;
import lfhfirst.model.vo.RoleVO;

public interface RoleService {
    RoleVO create(RoleDTO roleDTO);

    void removeById(Integer roleId);

    RoleVO update(RoleDTO roleDTO);
}
