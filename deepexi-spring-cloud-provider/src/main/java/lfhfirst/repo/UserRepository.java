package lfhfirst.repo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lfhfirst.manager.UserManager;
import lfhfirst.mapper.UserMapper;
import lfhfirst.model.entity.UserDO;
import lfhfirst.model.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.deepexi.pojo.converter.utils.ConverterUtils.convert;

@Repository
public class UserRepository {

    @Autowired
    private UserMapper mapper;

    public Integer create(UserDO userDO){
       return mapper.insert(userDO);
    }

    public Integer update(UserDO userDO) {
        return mapper.updateById(userDO);
    }

    public void delete(Integer id){
        if (id != null){
            mapper.deleteById(id);
        }
    }

    public UserDO getOne(Integer id) {
        UserDO userDO = mapper.selectById(id);
        if (userDO == null) {
            UserDO userDO1 = new UserDO();
            userDO1.setId(0);
            userDO1.setTel("无");
            userDO1.setPassword("无");
            userDO1.setName("无");
            return userDO1;
        }else {
            return userDO;
        }
    }

    public QueryWrapper<UserDO> toWrapper(UserManager.UserQuery query){
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(query.getName())){
            queryWrapper.like("tel",query.getTel());
        }
        if (StringUtils.isNotEmpty(query.getTel())){
            queryWrapper.like("name",query.getName());
        }
        return queryWrapper;
    }

    public List<UserDO> getList(UserManager.UserQuery query){
       return mapper.selectList(toWrapper(query));
    }

    public UserDO nameAndUserMatch(QueryWrapper<UserDO> queryWrapper) {
        return mapper.selectOne(queryWrapper);
    }
}
