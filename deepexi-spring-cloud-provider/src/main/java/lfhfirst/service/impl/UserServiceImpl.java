package lfhfirst.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lfhfirst.domain.entity.User;
import lfhfirst.model.dto.UserAndRoleIntermediateDTO;
import lfhfirst.model.dto.UserCreateDTO;
import lfhfirst.model.entity.UserAndRoleIntermediateDO;
import lfhfirst.model.entity.UserDO;
import lfhfirst.model.vo.UserAndRoleIntermediateVO;
import lfhfirst.model.vo.UserVO;
import lfhfirst.manager.UserManager;
import lfhfirst.model.dto.UserDTO;
import lfhfirst.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import static com.deepexi.pojo.converter.utils.ConverterUtils.convert;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManager userManager;

    @Override
    public Integer create(UserCreateDTO userDTO) {
        //判断该用户下是否有父ID
        //没有默认为1
        Integer userId = userManager
                .current()
                .create(userDTO);
        for (Integer roleId:userDTO.getRoleIds()){
            //插入用户-角色中间表
            userManager
                    .current()
                    .getUserAndRoleIntermediate()
                    .createUserAndRoleIntermediate(new UserAndRoleIntermediateDTO(userId,roleId));
        }
        return userId;
    }

    @Override
    public void delete(Integer userId) {
        //删除用户-角色中间表数据
        userManager
                .current()
                .getUserAndRoleIntermediate()
                .removeRoleAndAuthIntermediateByUserId(userId);

        //判断该用户是否有下一级 List<UserVO> = getUserListByParentId(userId);
        //List.size > 0 遍历，将这些用户的父ID改为1
        userManager
                .current()
                .delete(userId);
    }

    @Override
    public Integer update(UserDTO userDTO) {
        return userManager
                .current()
                .update(userDTO);
    }

    @Override
    public List<UserVO> getList(UserDTO userDTO) {
        return userManager.current().getList(userDTO);
    }

    @Override
    public UserVO getOne(Integer id) {
        return userManager.current().getOne(id);
    }

    @Override
    public UserVO NameAndUserMatch(UserDTO userDTO) {
        return userManager
                .current()
                .nameAndUserMatch(userDTO);
    }

}
