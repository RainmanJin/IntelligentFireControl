package cn.com.bgy.ifc.entity.vo.system;

/**
 * @author: ZhangCheng
 * @description:碧桂园权限
 * @date: 2018-12-24 15:16
 **/
public class BgyPermissionVo {

    /**
     * 权限id
     */
    private Integer bdId;

    /**
     * 权限类型(1-公司,2-区域,3-项目)
     */
    private Integer type;

    public Integer getBdId() {
        return bdId;
    }

    public void setBdId(Integer bdId) {
        this.bdId = bdId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
