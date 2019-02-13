package cn.com.bgy.ifc.entity.vo.systemchecking;

/**
 * @author: ZhangCheng
 * @description:系统巡检体检VO
 * @date: 2019-02-13 17:10
 **/
public class SystemCheckingVo {

    /**
     * 系统巡检类型 1:巡检 2：体检
     */
    private Integer type;

    /**
     * 检测类型 1：一键巡检 2：自动巡检
     */
    private Integer testType;

    /**
     * 所属项目
     */
    private Long projectId;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTestType() {
        return testType;
    }

    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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
}
