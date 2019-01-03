package cn.com.bgy.ifc.entity.vo.system;

import cn.com.bgy.ifc.entity.vo.common.BgyBaseVo;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:集成平台用户权限
 * @date: 2018-12-19 10:28
 **/
public class BgyUserPermissionVo extends BgyBaseVo {

    /**
     * 手机号
     */
    private String telephone;

    /**
     * 用户权限
     */
    private List<BgyPermissionVo> permission;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<BgyPermissionVo> getPermission() {
        return permission;
    }

    public void setPermission(List<BgyPermissionVo> permission) {
        this.permission = permission;
    }
}
