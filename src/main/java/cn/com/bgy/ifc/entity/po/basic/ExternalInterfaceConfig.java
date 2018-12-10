package cn.com.bgy.ifc.entity.po.basic;

import java.util.Date;

public class ExternalInterfaceConfig {
    private Long id;

    private Integer platformValue;

    private String url;

    private String account;

    private String signKey;

    private String subSystemCode;

    private String fileUrl;

    private Integer state;

    private Date createTime;

    private Long logicRemove;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSignKey() {
        return signKey;
    }

    public void setSignKey(String signKey) {
        this.signKey = signKey;
    }

    public String getSubSystemCode() {
        return subSystemCode;
    }

    public void setSubSystemCode(String subSystemCode) {
        this.subSystemCode = subSystemCode;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove(Long logicRemove) {
        this.logicRemove = logicRemove;
    }
}