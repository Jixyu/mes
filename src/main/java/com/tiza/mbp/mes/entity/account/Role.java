package com.tiza.mbp.mes.entity.account;

import com.tiza.mbp.utils.data.BaseEntity;

/**
 * CreateDate:2016/8/1
 *
 * @version 1.0.
 * @auther XieChen
 */
public class Role extends BaseEntity {
    private String roleName;
    private String roleDescription;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
