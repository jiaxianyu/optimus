package lfhfirst.model.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserVO {

    private Integer id;
    private String name;
    private String password;
    private String tel;
    private Date entryTime;
    private Integer parentId;
    private List<RoleVO> roleVOList;
}
