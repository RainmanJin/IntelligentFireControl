package cn.com.bgy.ifc.entity.vo.projects;

/**
 * @author: ZhangCheng
 * @description:增量接口base字段
 * @date: 2018-12-12 11:54
 **/
public class BgyBaseVo {

    private Long id;

    /**
     * 操作类型(1-新增，2-删除，3-修改)
     */
    private Integer operType;

    /**
     * 操作时间(yyyy-mm-dd HH:mm:ss)
     */
    private String operTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOperType() {
        return operType;
    }

    public void setOperType(Integer operType) {
        this.operType = operType;
    }

    public String getOperTime() {
        return operTime;
    }

    public void setOperTime(String operTime) {
        this.operTime = operTime;
    }

    @Override
    public String toString() {
        return "BgyBaseVo{" +
                "id=" + id +
                ", operType=" + operType +
                ", operTime='" + operTime + '\'' +
                '}';
    }
}
