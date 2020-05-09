package lfhfirst.model.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("role_db")
public class RoleDO {
    private Integer id;
    private String name;
    private Integer parentId;
}
