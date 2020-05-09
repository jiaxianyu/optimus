package lfhfirst.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DEEPEXI
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAndRoleIntermediateDTO {

    @ApiModelProperty(value = "用户-角色编号")
    private Integer id;
    @ApiModelProperty(value = "用户编号")
    private Integer userId;
    @ApiModelProperty(value = "角色编号")
    private Integer roleId;

    public UserAndRoleIntermediateDTO(Integer userId,Integer roleId){
        this.userId = userId;
        this.roleId = roleId;
    }
}
