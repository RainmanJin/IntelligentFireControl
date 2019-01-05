package cn.com.bgy.ifc.entity.po.firepatrol;

import java.util.Date;
/**
 * @Author huxin
 * @Description 动火证申请情况
 * @Date 2019/1/5 16:53
 */
public class FireApplication {
    //ID
    private Long id;
    //装修备案ID
    private Long recordId;
    //动火地点
    private String fireLocation;
    //动火时间
    private Date ignitionTime;
    //动火范围
    private String firingRange;
    //动火现场监护人
    private String guardian;
    //动火项目负责人
    private String projects;
    //动火方案
    private String ignitionPlan;
    //消防安全措施
    private String measures;
    //有无动火许可证
    private Boolean firePermit;
    //审批部门
    private String approvalDepartment;
    //审批结果
    private String approvalResult;
    //动火前与有关相临部门联系情况及采取消防安全措施情况
    private String measureSituation;
    //动火地点附近水源、灭火器具及消防队现场保护情况
    private String protectionSituation;
    //动火前和动火期间安全保卫部门检查消防安全措施落实和监护人、动火负责人落实情况
    private String implementatioSituation;
    //动火作业结束后现场清理情况
    private String cleanUp;
    //备注
    private String remark;
    //项目消防安全管理人
    private String custodian;
    //项目消防安全责任人
    private String personLiable;
    //创建、修改时间
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

    public String getFireLocation() {
        return fireLocation;
    }

    public void setFireLocation( String fireLocation ) {
        this.fireLocation = fireLocation;
    }

    public Date getIgnitionTime() {
        return ignitionTime;
    }

    public void setIgnitionTime( Date ignitionTime ) {
        this.ignitionTime = ignitionTime;
    }

    public String getFiringRange() {
        return firingRange;
    }

    public void setFiringRange( String firingRange ) {
        this.firingRange = firingRange;
    }

    public String getGuardian() {
        return guardian;
    }

    public void setGuardian( String guardian ) {
        this.guardian = guardian;
    }

    public String getProjects() {
        return projects;
    }

    public void setProjects( String projects ) {
        this.projects = projects;
    }

    public String getIgnitionPlan() {
        return ignitionPlan;
    }

    public void setIgnitionPlan( String ignitionPlan ) {
        this.ignitionPlan = ignitionPlan;
    }

    public String getMeasures() {
        return measures;
    }

    public void setMeasures( String measures ) {
        this.measures = measures;
    }

    public Boolean getFirePermit() {
        return firePermit;
    }

    public void setFirePermit( Boolean firePermit ) {
        this.firePermit = firePermit;
    }

    public String getApprovalDepartment() {
        return approvalDepartment;
    }

    public void setApprovalDepartment( String approvalDepartment ) {
        this.approvalDepartment = approvalDepartment;
    }

    public String getApprovalResult() {
        return approvalResult;
    }

    public void setApprovalResult( String approvalResult ) {
        this.approvalResult = approvalResult;
    }

    public String getMeasureSituation() {
        return measureSituation;
    }

    public void setMeasureSituation( String measureSituation ) {
        this.measureSituation = measureSituation;
    }

    public String getProtectionSituation() {
        return protectionSituation;
    }

    public void setProtectionSituation( String protectionSituation ) {
        this.protectionSituation = protectionSituation;
    }

    public String getImplementatioSituation() {
        return implementatioSituation;
    }

    public void setImplementatioSituation( String implementatioSituation ) {
        this.implementatioSituation = implementatioSituation;
    }

    public String getCleanUp() {
        return cleanUp;
    }

    public void setCleanUp( String cleanUp ) {
        this.cleanUp = cleanUp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark( String remark ) {
        this.remark = remark;
    }

    public String getCustodian() {
        return custodian;
    }

    public void setCustodian( String custodian ) {
        this.custodian = custodian;
    }

    public String getPersonLiable() {
        return personLiable;
    }

    public void setPersonLiable( String personLiable ) {
        this.personLiable = personLiable;
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