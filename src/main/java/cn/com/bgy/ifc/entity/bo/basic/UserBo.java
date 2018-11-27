package cn.com.bgy.ifc.entity.bo.basic;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserBo {
    @NotBlank(message="用户名不能为空")
    private String userName;
    @NotBlank(message="手机号码不能为空")
    @Size(min=11,max=11,message="手机号码长度不正确")
    private String phone;
    @NotBlank(message="邮箱不能为空")
    private String email;
    @NotBlank(message="密码不能为空")
    private String password;
    @NotNull(message="部门ID不能为空")
    private Long deptId;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

}