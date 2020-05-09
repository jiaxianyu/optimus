package lfhfirst.domain.entity;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lfhfirst.manager.UserManager;
import lfhfirst.model.dto.RoleDTO;
import lfhfirst.model.dto.UserAndRoleIntermediateDTO;
import lfhfirst.model.dto.UserDTO;
import lfhfirst.model.entity.RoleDO;
import lfhfirst.model.entity.UserAndRoleIntermediateDO;
import lfhfirst.model.entity.UserDO;
import lfhfirst.model.vo.RoleVO;
import lfhfirst.model.vo.UserVO;
import lfhfirst.repo.RoleRepository;
import lfhfirst.repo.UserAndRoleIntermediateRepository;
import lfhfirst.repo.UserRepository;
import lfhfirst.service.RoleService;
import lombok.Data;
import org.bouncycastle.asn1.cms.ecc.MQVuserKeyingMaterial;

import java.util.List;

import static com.deepexi.pojo.converter.utils.ConverterUtils.convert;

public class User {

    private UserRepository userRepository;

    public User(UserRepository repository) {
        this.userRepository = repository;
    }

    public Integer createCus(UserCreate vo) {
        return userRepository.create(convert(vo, UserDO.class));
    }

    public UserVO update(UserCreate vo) {
        return null;
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
                .eq("pawword",userDTO.getPassword());
        return convert(userRepository.nameAndUserMatch(queryWrapper),UserVO.class);
    }

    public Role getRole() {
        return new Role();
    }
    public UserAndRoleIntermediate getUserAndRoleIntermediate() {
        return new UserAndRoleIntermediate();
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
