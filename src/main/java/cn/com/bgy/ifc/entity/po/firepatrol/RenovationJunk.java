package cn.com.bgy.ifc.entity.po.firepatrol;

import java.util.Date;
/**
 * @Author huxin
 * @Description 装修垃圾清理情况表
 * @Date 2019/1/5 17:11
 */
public class RenovationJunk implements Serializable{
    //ID
    private Long id;
    //装修备案ID
    private Long recordId;
    //验收/检查人
    private String checkPerson;
    //垃圾清理情况
    private String clearDescription;
    //验收/检查人联系电话
    private String checkPersonTel;
    //验收/检查结果
    private String checkResult;
    //创建/修改时间
    private Date createTime;
    //是否逻辑删除    0:存在    1:删除
    private Boolean logicRemove;


    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId( Long recordId ) {
        this.recordId = recordId;
    }

    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson( String checkPerson ) {
        this.checkPerson = checkPerson;
    }

    public String getClearDescription() {
        return clearDescription;
    }

    public void setClearDescription( String clearDescription ) {
        this.clearDescription = clearDescription;
    }

    public String getCheckPersonTel() {
        return checkPersonTel;
    }

    public void setCheckPersonTel( String checkPersonTel ) {
        this.checkPersonTel = checkPersonTel;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult( String checkResult ) {
        this.checkResult = checkResult;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime( Date createTime ) {
        this.createTime = createTime;
    }

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove( Boolean logicRemove ) {
        this.logicRemove = logicRemove;
    }
}