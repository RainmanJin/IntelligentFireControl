package cn.com.bgy.ifc.entity.po.system;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.Date;
/**
 * 系统公告
 */
public class Information  implements Serializable {
    /**
     * 系统公告表id
     */
    private Long id;

    /**
     * 机构表id (用于区分平台)
     */
    private Long orgId;



    /**
     * 1，通知 2，公告
     */
    private Long typeId;

    /**
     * 标题
     */
    private String title;

    /**
     * 署名
     */
    private String signature;

    /**
     * 落款日期
     */
    private String dateLine;

    /**
     * 部门id(为0时全部可以查看，具体值时为所有人)
     */
    private Long dId;
    /**
     * 部门名称
     */
    private String  departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * 用户表id
     */
    private Long uId;

    /**
     * 新增修改时间
     */
    private Date createTime;

    /**
     * 是否逻辑删除
     */
    private Boolean logicRemove;

    /**
     * 内容
     */
    private String content;
    /**
     *关键字
     */
    private String keyWords;

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    /**
     * information
     */
    private static final long serialVersionUID = 1L;

    /**
     * 系统公告表id
     * @return id 系统公告表id
     */
    public Long getId() {
        return id;
    }

    /**
     * 系统公告表id
     * @param id 系统公告表id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 机构表id (用于区分平台)
     * @return org_id 机构表id (用于区分平台)
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * 机构表id (用于区分平台)
     * @param orgId 机构表id (用于区分平台)
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * 1，通知 2，公告
     * @return type_id 1，通知 2，公告
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * 1，通知 2，公告
     * @param typeId 1，通知 2，公告
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /**
     * 标题
     * @return title 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 署名
     * @return signature 署名
     */
    public String getSignature() {
        return signature;
    }

    /**
     * 署名
     * @param signature 署名
     */
    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    /**
     * 落款日期
     * @return date_line 落款日期
     */
    public String getDateLine() {
        return dateLine;
    }

    /**
     * 落款日期
     * @param dateLine 落款日期
     */
    public void setDateLine(String dateLine) {
        this.dateLine = dateLine == null ? null : dateLine.trim();
    }

    /**
     * 部门id(为0时全部可以查看，具体值时为所有人)
     * @return d_id 部门id(为0时全部可以查看，具体值时为所有人)
     */
    public Long getdId() {
        return dId;
    }

    /**
     * 部门id(为0时全部可以查看，具体值时为所有人)
     * @param dId 部门id(为0时全部可以查看，具体值时为所有人)
     */
    public void setdId(Long dId) {
        this.dId = dId;
    }

    /**
     * 用户表id
     * @return u_id 用户表id
     */
    public Long getuId() {
        return uId;
    }

    /**
     * 用户表id
     * @param uId 用户表id
     */
    public void setuId(Long uId) {
        this.uId = uId;
    }

    /**
     * 新增修改时间
     * @return create_time 新增修改时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 新增修改时间
     * @param createTime 新增修改时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 是否逻辑删除
     * @return logic_remove 是否逻辑删除
     */
    public Boolean getLogicRemove() {
        return logicRemove;
    }

    /**
     * 是否逻辑删除
     * @param logicRemove 是否逻辑删除
     */
    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }

    /**
     * 内容
     * @return content 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}