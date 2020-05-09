package lfhfirst.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lfhfirst.exception.NotPermissionException;
import lfhfirst.model.dto.UserDTO;
import lfhfirst.model.vo.UserVO;
import lfhfirst.service.UserService;
import lfhfirst.util.UserInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/users")
@Payload
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加用户")
    @PostMapping
    public Integer create(@ApiParam(value = "用户信息") @RequestBody @Valid UserDTO userDTO,
                          HttpServletRequest request){
        if(UserInfoUtils.checkPermission(request,"users:create")){
            return userService.create(userDTO);
        }else {
            throw new NotPermissionException("没有权限进行此操作");
        }
    }

    @ApiOperation(value = "根据条件获取用户信息")
    @GetMapping
    public UserVO login(@ApiParam(value = "用户信息")  UserDTO userDTO,
                        HttpServletRequest  httpRequest){
        UserVO userVO = userService.nameAndUserMatch(userDTO);
        httpRequest.getSession().setAttribute("user",userVO);
        return userVO;
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping(value = "/{id}")
    public void DeleteById(@ApiParam(value = "用户编号") @PathVariable Integer id,
                           HttpServletRequest request){
        //判断是否有访问该请求的权限
        if(UserInfoUtils.checkPermission(request,"users:create")){
            userService.delete(id);
        }else {
            throw new NotPermissionException("没有权限进行此操作");
        }
    }

    @ApiOperation(value = "修改用户")
    @PutMapping(value = "/{id}")
    public UserVO Update(@ApiParam(value = "用户信息") @RequestBody @Valid UserDTO UserDTO,
                         HttpServletRequest request){
        if(UserInfoUtils.checkPermission(request,"users:update")){
            return userService.update(UserDTO);
        }else {
            throw new NotPermissionException("没有权限进行此操作");
        }
   }

    @ApiOperation(value = "根据条件获取用户信息")
    @GetMapping
    public List<UserVO> getlist(@ApiParam(value = "用户信息") UserDTO UserDTO,
                             HttpServletRequest request){
        if(UserInfoUtils.checkPermission(request,"users:getlist")){
            return userService.getList(UserDTO);
        }else {
            throw new NotPermissionException("没有权限进行此操作");
        }
    }


    @ApiOperation(value = "根据ID获取用户信息")
    @GetMapping("/{id}")
    public UserVO getOne(@ApiParam(value = "用户ID") @PathVariable Integer id,
                         HttpServletRequest request){
        if(UserInfoUtils.checkPermission(request,"users:getOne")){
            return userService.getOne(id);
        }else {
            throw new NotPermissionException("没有权限进行此操作");
        }
    }

}
