package lfhfirst.model.entity;

import io.swagger.annotations.ApiModel;
import lfhfirst.enums.PermissionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("PermissionDTO")
public class PermissionDO {
    private Integer id;
    private String name;
    private PermissionType type;
}
