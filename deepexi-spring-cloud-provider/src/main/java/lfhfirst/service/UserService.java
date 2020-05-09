package lfhfirst.service;

import lfhfirst.model.vo.UserVO;
import lfhfirst.model.dto.UserDTO;

import java.util.List;


public interface UserService {

    public Integer create(UserDTO userDTO);

    public void delete(Integer userd);


    public UserVO update(UserDTO userDTO);

    public List<UserVO> getList(UserDTO userDTO);

    UserVO getOne(Integer id);

    UserVO nameAndUserMatch(UserDTO userDTO);
}
