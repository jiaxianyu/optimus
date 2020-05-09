package lfhfirst.repo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lfhfirst.mapper.UserAndRoleIntermediateMapper;
import lfhfirst.model.entity.UserAndRoleIntermediateDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserAndRoleIntermediateRepository {

    @Autowired
    private UserAndRoleIntermediateMapper mapper;

    public void removeByRoleId(Integer roleId) {
        QueryWrapper<UserAndRoleIntermediateDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("roleId",roleId);

        mapper.delete(queryWrapper);
    }

    public void create(UserAndRoleIntermediateDO userAndRoleIntermediateDO) {
        mapper.insert(userAndRoleIntermediateDO);
    }

    public void removeByUserId(Integer userId) {
        QueryWrapper<UserAndRoleIntermediateDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId",userId);

        mapper.delete(queryWrapper);
    }
}
