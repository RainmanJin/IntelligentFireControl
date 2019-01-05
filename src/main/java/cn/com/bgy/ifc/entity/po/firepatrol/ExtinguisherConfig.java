package cn.com.bgy.ifc.entity.po.firepatrol;

import java.util.Date;
/**
 * @Author huxin
 * @Description 灭火器配置情况
 * @Date 2019/1/5 16:46
 */
public class ExtinguisherConfig {
    //ID
    private Long id;
    //灭火器类型
    private Integer type;
    //购买时间
    private Date buyingTime;
    //设置位置
    private String settingPosition;
    //数量
    private Integer number;
    //检查维修单位（人员）
    private String person;
    //检修情况
    private String condition;
    //其他
    private String other;
    //创建、修改时间
    private Date createTime;
    //是否逻辑删除 0:存在  1：删除
    private Boolean logicRemove;


    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType( Integer type ) {
        this.type = type;
    }

    public Date getBuyingTime() {
        return buyingTime;
    }

    public void setBuyingTime( Date buyingTime ) {
        this.buyingTime = buyingTime;
    }

    public String getSettingPosition() {
        return settingPosition;
    }

    public void setSettingPosition( String settingPosition ) {
        this.settingPosition = settingPosition;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber( Integer number ) {
        this.number = number;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson( String person ) {
        this.person = person;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition( String condition ) {
        this.condition = condition;
    }

    public String getOther() {
        return other;
    }

    public void setOther( String other ) {
        this.other = other;
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