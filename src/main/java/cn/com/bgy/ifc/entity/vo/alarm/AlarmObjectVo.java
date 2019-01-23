package cn.com.bgy.ifc.entity.vo.alarm;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:告警对象
 * @date: 2019-01-19 17:24
 **/
public class AlarmObjectVo {
    private Long id;

    /**
     * 所属区域ID
     */
    @NotNull(message="所属区域不能为空！")
    private Long regionId;

    /**
     * 所属项目ID
     */
    @NotNull(message="所属项目不能为空！")
    private Long projectId;

    /**
     * 告警通知人ID
     */
    @NotNull(message="告警通知人不能为空！")
    private Long userId;

    /**
     * 联系方式
     */
    @Size(max=50,message="联系方式长度不能超过50字符！")
    private String contactWay;

    /**
     * 启用状态 禁用-0 启用-1
     */
    private Integer state;

    /**
     * 短信通知
     */
    private Boolean smsNotice;

    /**
     * 语音电话
     */
    private Boolean voiceCall;

    /**
     * APP通知
     */
    private Boolean appNotice;


    /**
     * 创建、修改时间
     */
    private Date createTime;

    /**
     * 是否逻辑删除
     */
    private Boolean logicRemove;

    /**
     * 关键字
     */
    private String keyword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Boolean getSmsNotice() {
        return smsNotice;
    }

    public void setSmsNotice(Boolean smsNotice) {
        this.smsNotice = smsNotice;
    }

    public Boolean getVoiceCall() {
        return voiceCall;
    }

    public void setVoiceCall(Boolean voiceCall) {
        this.voiceCall = voiceCall;
    }

    public Boolean getAppNotice() {
        return appNotice;
    }

    public void setAppNotice(Boolean appNotice) {
        this.appNotice = appNotice;
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

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
