package lfhfirst.model.vo;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

public class RoleVO {
    private Integer id;
    private String name;
    private Integer parentId;
}
