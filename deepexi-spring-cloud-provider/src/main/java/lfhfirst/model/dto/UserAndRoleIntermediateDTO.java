package lfhfirst.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

    private Integer id;
    private Integer userId;
    private Integer roleId;

    public UserAndRoleIntermediateDTO(Integer userId,Integer roleId){
        this.userId = userId;
        this.roleId = roleId;
    }
}
