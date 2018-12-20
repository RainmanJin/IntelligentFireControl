package cn.com.bgy.ifc.entity.vo.projects;

import java.util.List;
import java.util.Map;

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
    private List<Map<String,Object>> permission;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Map<String, Object>> getPermission() {
        return permission;
    }

    public void setPermission(List<Map<String, Object>> permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "BgyUserPermissionVo{" +
                "telephone='" + telephone + '\'' +
                ", permission=" + permission +
                '}';
    }
}
