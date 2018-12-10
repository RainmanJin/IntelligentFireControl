package cn.com.bgy.ifc.entity.po.basic;

import java.util.Date;
/**
 * @Author huxin
 * @Description 操作日志实体
 * @Date 2018/12/6 14:19
 */
public class SystemOperationLog {
    /**
     * @Author huxin
     * @Description 日志ID
     * @Date 2018/12/6 14:12
     */
    private Long id;
    /**
     * @Author huxin
     * @Description 操作用户ID
     * @Date 2018/12/6 14:12
     */
    private Long userId;
    /**
     * @Author huxin
     * @Description 操作用户名字
     * @Date 2018/12/6 14:12
     */
    private String userName;
    /**
     * @Author huxin
     * @Description 日志类型
     * @Date 2018/12/6 14:12
     */
    private Integer logType;
    /**
     * @Author huxin
     * @Description IP地址
     * @Date 2018/12/6 14:12
     */
    private String ip;
    /**
     * @Author huxin
     * @Description 操作时间
     * @Date 2018/12/6 14:13
     */
    private Date createTime;
    /**
     * @Author huxin
     * @Description 是否删除
     * @Date 2018/12/6 14:13
     */
    private Boolean logicRemove;
    /**
     * @Author huxin
     * @Description 操作内容
     * @Date 2018/12/6 14:13
     */
    private String operatorContent;
    /**
     * @Author huxin
     * @Description 备注描述
     * @Date 2018/12/6 14:13
     */
    private String operatorDescribe;

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
}