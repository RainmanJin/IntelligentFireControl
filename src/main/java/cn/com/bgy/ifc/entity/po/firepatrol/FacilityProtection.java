package cn.com.bgy.ifc.entity.po.firepatrol;

import java.util.Date;
/**
 * @Author huxin
 * @Description 消防保护措施处理情况
 * @Date 2019/1/5 16:50
 */
public class FacilityProtection implements Serializable{
    //ID
    private Long id;
    //装修备案ID
    private Long recordId;
    //设施名称
    private String name;
    //设施状况 0：未损坏 1：损坏
    private Integer state;
    //检查维修单位（人员）
    private String checkPerson;
    //描述
    private String description;
    //检查情况
    private String checkStatus;
    //备注
    private String remark;
    //创建、修改时间
    private Date createTime;
    //是否逻辑删除 0:存在   1:删除
    private Boolean logicRemove;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId( Long recordId ) {
        this.recordId = recordId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus( String checkStatus ) {
        this.checkStatus = checkStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark( String remark ) {
        this.remark = remark;
    }
}