package cn.com.bgy.ifc.entity.po.system.basic;

import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:外部接口日志
 */
public class ExternalInterfaceMsg {

    private Long id;

    /**
     * 外部接口平台枚举
     */
    private Integer platformValue;

    /**
     * 接口信息类型值，0获取账号信息，1区域信息，2项目信息，3品牌，4规格信息，5设备类型，6机房信息，7设备信息
     */
    private Integer msgTypeValue;

    /**
     * 总条数
     */
    private Integer totalCount;

    /**
     * 新增条数
     */
    private Integer addCount;

    /**
     * 删除条数
     */
    private Integer deleteCount;

    /**
     * 修改条数
     */
    private Integer updateCount;

    /**
     * 成功条数
     */
    private Integer successCount;

    /**
     * 失败条数
     */
    private Integer errorCount;

    /**
     * 机构表Id，用于区分平台
     */
    private Long orgId;

    /**
     * 接口请求时间
     */
    private Date requestTime;

    /**
     * 新增时间
     */
    private Date createTime;

    /**
     * 是否逻辑删除
     */
    private Boolean logicRemove;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPlatformValue() {
        return platformValue;
    }

    public void setPlatformValue(Integer platformValue) {
        this.platformValue = platformValue;
    }

    public Integer getMsgTypeValue() {
        return msgTypeValue;
    }

    public void setMsgTypeValue(Integer msgTypeValue) {
        this.msgTypeValue = msgTypeValue;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getAddCount() {
        return addCount;
    }

    public void setAddCount(Integer addCount) {
        this.addCount = addCount;
    }

    public Integer getDeleteCount() {
        return deleteCount;
    }

    public void setDeleteCount(Integer deleteCount) {
        this.deleteCount = deleteCount;
    }

    public Integer getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(Integer updateCount) {
        this.updateCount = updateCount;
    }

    public Integer getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }

    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
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
}