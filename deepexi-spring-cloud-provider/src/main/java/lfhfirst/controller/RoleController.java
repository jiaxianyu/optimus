package lfhfirst.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lfhfirst.model.dto.RoleDTO;
import lfhfirst.model.vo.RoleVO;
import lfhfirst.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/roles")
@Payload
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "添加添加")
    @PostMapping
    public RoleVO create(@ApiParam(value = "角色信息") @RequestBody @Valid RoleDTO roleDTO){
        return roleService.create(roleDTO);
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("/{roleId}")
    public void removeById(@ApiParam(value = "角色编号") @PathVariable Integer roleId){
        roleService.removeById(roleId);
    }

    @ApiOperation(value = "更新角色信息")
    @PutMapping
    public RoleVO update(@ApiParam(value = "角色信息") @RequestBody RoleDTO roleDTO){
        return roleService.update(roleDTO);
    }

    @ApiOperation(value = "获取某个角色的详细信息")
    @GetMapping("/{roleId}")
    public List<RoleVO> getList(@ApiParam(value = "角色ID")@PathVariable Integer roleId){
        return roleService.getList(roleId);
    }

}
