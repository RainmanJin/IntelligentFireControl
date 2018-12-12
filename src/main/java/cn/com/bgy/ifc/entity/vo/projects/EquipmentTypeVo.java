package cn.com.bgy.ifc.entity.vo.projects;

/**
 * @Author huxin
 * @Date 2018/12/12 16:37
 * @Description 第三方接口调用--》设备类型VO
 **/

public class EquipmentTypeVo extends  BgyBaseVo{
    //设备类型名
    private String name;
    //父级ID
    private Long parentId;
    //设备状态
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId( Long parentId ) {
        this.parentId = parentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus( Integer status ) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EquipmentTypeVo{" + "name='" + name + '\'' + ", parentId=" + parentId + ", status=" + status + '}';
    }
}
