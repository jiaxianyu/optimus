package lfhfirst.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;


/**
 * @author DEEPEXI
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("UserDTO")
public class UserDTO {

    @ApiModelProperty(value = "用户编号")
    private Integer id;

    @ApiModelProperty(value = "用户姓名")
    @NotBlank(message = "用户名不能为空")
    private String name;

    @ApiModelProperty(value = "用户密码")
    @NotBlank(message = "用户密码不能为空")
    private String password;

    @ApiModelProperty(value = "用户电话")
    private String tel;

    @ApiModelProperty(value = "加入时间")
    private Date entryTime;

    @ApiModelProperty(value = "用户父ID")
    private Integer parentId;

    @ApiModelProperty(value = "角色集合")
    private List<Integer> roleIds;
}
