package lfhfirst.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lfhfirst.model.entity.UserAndRoleIntermediateDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAndRoleIntermediateMapper  extends BaseMapper<UserAndRoleIntermediateDO> {
}
