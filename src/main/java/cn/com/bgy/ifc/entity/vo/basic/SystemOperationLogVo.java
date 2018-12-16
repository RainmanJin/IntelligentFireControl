package cn.com.bgy.ifc.entity.vo.basic;

import java.util.Date;

public class SystemOperationLogVo {
    private Long id;

    private Long userId;

    private String userName;

    private Integer logType;

    private String ip;

    private Date createTime;

    /**
     * 开始日期时间
     */
    private String startTime;

    /**
     * 结束日期时间
     */
    private String endTime;

    private Boolean logicRemove;

    private String operatorContent;

    /**
     * 操作描述
     */
    private String operatorDescribe;

    /**
     * 关键字
     */
    private String keyword;

    public String getOperatorContent() {
        return operatorContent;
    }

    public void setOperatorContent(String operatorContent) {
        this.operatorContent = operatorContent;
    }

    public String getOperatorDescribe() {
        return operatorDescribe;
    }

    public void setOperatorDescribe(String operatorDescribe) {
        this.operatorDescribe = operatorDescribe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "SystemOperationLogVo{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", logType=" + logType +
                ", ip='" + ip + '\'' +
                ", createTime=" + createTime +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", logicRemove=" + logicRemove +
                ", operatorContent='" + operatorContent + '\'' +
                ", operatorDescribe='" + operatorDescribe + '\'' +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}