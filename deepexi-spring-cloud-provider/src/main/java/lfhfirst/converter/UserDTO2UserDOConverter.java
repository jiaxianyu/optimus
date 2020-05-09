package lfhfirst.converter;

import lfhfirst.model.dto.UserDTO;
import lfhfirst.model.entity.UserDO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDTO2UserDOConverter implements Converter<UserDTO, UserDO> {
    @Override
    public UserDO convert(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        userDO.setId(userDTO.getId());
        userDO.setName(userDTO.getName());
        userDO.setPassword(userDTO.getPassword());
        userDO.setTel(userDTO.getTel());
        return userDO;
    }
}
