package lfhfirst.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lfhfirst.domain.entity.User;
import lfhfirst.model.dto.UserAndRoleIntermediateDTO;
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
    public Integer create(UserDTO userDTO) {
        Integer userId = userManager
                .current()
                .createCus(convert(userDTO, User.UserCreate.class));
        for (Integer roleId:userDTO.getRoleIds()){
            //插入用户-角色中间表
            userManager
                    .current()
                    .createUserAndRoleIntermediate(new UserAndRoleIntermediateDTO(userId,roleId));
        }
        return userId;
    }

    @Override
    public void delete(Integer userId) {
        userManager
                .current()
                .removeRoleAndAuthIntermediateByUserId(userId);

        userManager
                .current()
                .delete(userId);
    }

    @Override
    public UserVO update(UserDTO userDTO) {
        return null;
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
    public UserVO nameAndUserMatch(UserDTO userDTO) {
        return userManager
                .current()
                .nameAndUserMatch(userDTO);
    }

}
