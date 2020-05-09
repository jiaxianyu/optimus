package lfhfirst.domain.entity;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lfhfirst.manager.UserManager;
import lfhfirst.model.dto.UserCreateDTO;
import lfhfirst.model.dto.UserDTO;
import lfhfirst.model.entity.UserDO;
import lfhfirst.model.vo.UserVO;
import lfhfirst.repo.UserRepository;
import lombok.Data;

import java.util.List;

import static com.deepexi.pojo.converter.utils.ConverterUtils.convert;

public class User {

    private UserRepository userRepository;

    public User(UserRepository repository) {
        this.userRepository = repository;
    }

    public Integer update(UserDTO userDTO) {
        return userRepository.update(convert(userDTO,UserDO.class));
    }

    public void delete(Integer id) {
        userRepository.delete(id);
    }

    public UserVO getOne(Integer id) {
        return convert(userRepository.getOne(id), UserVO.class);
    }

    public List<UserVO> getList(UserDTO userDTO) {
        UserManager.UserQuery userQuery = new UserManager.UserQuery();
        userQuery.setName(userDTO.getName());
        userQuery.setTel(userDTO.getTel());
        List<UserDO> list = userRepository.getList(userQuery);
        return null;

    }



    public UserVO nameAndUserMatch(UserDTO userDTO) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",userDTO.getName())
                .eq("password",userDTO.getPassword());
        return convert(userRepository.nameAndUserMatch(queryWrapper),UserVO.class);
    }

    public Integer create(UserCreateDTO userCreateDTO) {
        return  userRepository.create(convert(userCreateDTO,UserDO.class));
    }

    public Role getRole() {
        return new Role();
    }
    public UserAndRoleIntermediate getUserAndRoleIntermediate() {
        return new UserAndRoleIntermediate();
    }

    public RoleAndPermissionIntermediate getRoleAndPermissionIntermediate() {
        return  new RoleAndPermissionIntermediate();
    }

    @Data
    public static class UserCreate {

        private Integer id;
        private String password;
        private String name;
        private String tel;
    }

    @Data
    public static class update {
        private Integer id;
        private String password;
        private String name;
        private String tel;
    }

    @Data
    public static class UserData{
        private Integer id;
        private String password;
        private String name;
        private String tel;
    }
}
