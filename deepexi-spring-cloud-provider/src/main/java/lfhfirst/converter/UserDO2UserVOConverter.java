package lfhfirst.converter;

import lfhfirst.model.entity.UserDO;
import lfhfirst.model.vo.UserVO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDO2UserVOConverter implements Converter<UserDO, UserVO> {
    @Override
    public UserVO convert(UserDO userDO) {
        UserVO vo = new UserVO();
        vo.setID(userDO.getId());
        vo.setName(userDO.getName());
        vo.setPassword(userDO.getPassword());
        vo.setTel(userDO.getTel());
        return vo;
    }
}
