package lfhfirst.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lfhfirst.model.entity.RoleDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface RoleMapper extends BaseMapper<RoleDO> {
}
