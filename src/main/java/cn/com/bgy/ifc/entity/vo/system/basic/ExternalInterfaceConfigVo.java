package cn.com.bgy.ifc.entity.vo.system.basic;

import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:外部接入接口配置实体VO
 * @date: 2018-12-17 22:06
 **/
public class ExternalInterfaceConfigVo {

    private Long id;

    /**
     * 机构ID
     */
    private Long orgId;

    /**
     * 外部接口平台枚举
     */
    private Integer platformValue;

    /**
     * 外部接入接口地址
     */
    private String url;

    /**
     * 外部接口接口平台账号
     */
    private String account;

    /**
     * 外部接口接口平台专用密码
     */
    private String signKey;

    /**
     * 子系统编码（用于凤凰慧）
     */
    private String subSystemCode;

    /**
     * 附件地址（用于集成平台）
     */
    private String fileUrl;

    /**
     * 启用 未用
     */
    private Integer state;

    /**
     * 创建修改时间
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

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }

}
