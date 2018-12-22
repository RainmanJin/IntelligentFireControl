package cn.com.bgy.ifc.entity.vo.project;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台设备信息VO
 * @date: 2018-12-21 11:11
 **/
public class BgyEquipmentVo extends BgyBaseVo {

    /**
     * 设备名
     */
    private String name;
    /**
     * 设备详情
     */
    private String description;
    /**
     * 设备编码
     */
    private String inputCode;
    /**
     * 所属机房ID
     */
    private Long machineRoomId;
    /**
     * 型号id
     */
    private Long versionId;
    /**
     * 品牌ID
     */
    private Long brandId;
    /**
     * 类型ID
     */
    private Long typeId;
    /**
     * 质保年份
     */
    private int keepYears;
    /**
     * 投入使用时间(yyyy-mm-dd)
     */
    private String inWorkTime;
    /**
     * 是否为重点设备(0-非重点,1-重点)
     */
    private int isImportant;
    /**
     * 设备状态 0 停用 1 正常 2报废
     */
    private Integer status;
    /**
     * 位置编号
     */
    private String localtionCode;
    /**
     * 用户辅助编码
     */
    private String simpleCode;
    /**
     * 设备接口编码
     */
    private String apiCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode;
    }

    public Long getMachineRoomId() {
        return machineRoomId;
    }

    public void setMachineRoomId(Long machineRoomId) {
        this.machineRoomId = machineRoomId;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public int getKeepYears() {
        return keepYears;
    }

    public void setKeepYears(int keepYears) {
        this.keepYears = keepYears;
    }

    public String getInWorkTime() {
        return inWorkTime;
    }

    public void setInWorkTime(String inWorkTime) {
        this.inWorkTime = inWorkTime;
    }

    public int getIsImportant() {
        return isImportant;
    }

    public void setIsImportant(int isImportant) {
        this.isImportant = isImportant;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLocaltionCode() {
        return localtionCode;
    }

    public void setLocaltionCode(String localtionCode) {
        this.localtionCode = localtionCode;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public String getApiCode() {
        return apiCode;
    }

    public void setApiCode(String apiCode) {
        this.apiCode = apiCode;
    }

    @Override
    public String toString() {
        return "BgyEquipmentVo{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", inputCode='" + inputCode + '\'' +
                ", machineRoomId=" + machineRoomId +
                ", versionId=" + versionId +
                ", brandId=" + brandId +
                ", typeId=" + typeId +
                ", keepYears=" + keepYears +
                ", inWorkTime='" + inWorkTime + '\'' +
                ", isImportant=" + isImportant +
                ", status=" + status +
                ", localtionCode='" + localtionCode + '\'' +
                ", simpleCode='" + simpleCode + '\'' +
                ", apiCode='" + apiCode + '\'' +
                '}';
    }
}
