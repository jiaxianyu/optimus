package lfhfirst.service;

import lfhfirst.model.dto.UserCreateDTO;
import lfhfirst.model.vo.UserVO;
import lfhfirst.model.dto.UserDTO;

import java.util.List;


public interface UserService {

    public Integer create(UserCreateDTO userDTO);

    public void delete(Integer userd);

    public Integer update(UserDTO userDTO);

    public List<UserVO> getList(UserDTO userDTO);

    UserVO getOne(Integer id);

    UserVO NameAndUserMatch(UserDTO userDTO);
}
