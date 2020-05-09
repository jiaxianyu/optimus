package lfhfirst.domain.entity;

import lfhfirst.model.dto.UserAndRoleIntermediateDTO;
import lfhfirst.model.entity.UserAndRoleIntermediateDO;
import lfhfirst.model.vo.RoleVO;
import lfhfirst.model.vo.UserVO;
import lfhfirst.repo.UserAndRoleIntermediateRepository;

import java.util.List;

import static com.deepexi.pojo.converter.utils.ConverterUtils.convert;

public class UserAndRoleIntermediate {
    private UserAndRoleIntermediateRepository userAndRoleIntermediateRepository;

    public void removeUserAndRoleIntermediateByRoleId(Integer roleId) {
        userAndRoleIntermediateRepository.removeByRoleId(roleId);
    }


    public void removeRoleAndAuthIntermediateByRoleId(Integer roleId) {
        userAndRoleIntermediateRepository.removeByRoleId(roleId);
    }

    public void createUserAndRoleIntermediate(UserAndRoleIntermediateDTO userAndRoleIntermediateDTO) {
        userAndRoleIntermediateRepository.create(convert(userAndRoleIntermediateDTO, UserAndRoleIntermediateDO.class));
    }

    public void removeRoleAndAuthIntermediateByUserId(Integer userId) {
        userAndRoleIntermediateRepository.removeByUserId(userId);
    }

    public List<UserVO> getListByRoleId(Integer roleId) {
        //找到对应的角色ID
        //遍历找到用户信息
        return null;
    }
}
