package lfhfirst.model.vo;

import java.util.List;

public class RoleVO {
    private Integer id;
    private String name;
    private Integer parentId;
    private List<PermissionVO> permissionVOS;
    private List<UserVO> userVOS;
}
