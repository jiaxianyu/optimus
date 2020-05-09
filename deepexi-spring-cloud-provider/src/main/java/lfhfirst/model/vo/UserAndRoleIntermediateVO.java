package lfhfirst.model.vo;

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
@TableName("UserAndRoleIntermediate_db")
public class UserAndRoleIntermediateVO {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer roleId;
}
