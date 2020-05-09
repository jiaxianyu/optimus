package lfhfirst.domain.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;



@Data
@ApiModel("UserVO")
public class UserVo {

    private Integer ID;
    private String name;
    private String password;
    private String tel;


}
