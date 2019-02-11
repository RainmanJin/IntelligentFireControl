package cn.com.bgy.ifc.entity.po.equipment;

import java.util.Date;
import java.util.List;

public class EquipmentInfo extends RegionAndBrand {
    /**
     * 系统自增ID
     */
    private Long id;

    /**
     * 设备名称
     */
    private String name;

    /**
     * 设备编码
     */
    private String inputCode;
    /**
     * 所属机房ID
     */
    private Long machineRoomId;

    /**
     * 型号ID
     */
    private Long versionId;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 所属分类ID
     */
    private Long typeId;

    /**
     * 质保年份
     */
    private Integer keepYears;

    /**
     * 投入使用时间(yyyy-mm-dd)
     */
    private Date inWorkTime;

    /**
     * 是否为重点设备(0-非重点,1-重点)
     */
    private Integer important;

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

    /**
     * 描述
     */
    private String description;

    private Boolean logicRemove;

    /**
     * 物联设备状态信息ID
     */
    private Long equipmentStateId;

    /**
     * OneNet平台设备ID
     */
    private String platformDeviceId;

    /**
     * 三方设备ID，如：序列号，IMEI号，MAC地址等
     */
    private String thirdDeviceId;

    /**
     * 上级设备ID
     */
    private Long superiorId;
    /**
     * 区号
     */
    private Integer partitionNum;

    /**
     * 位号
     */
    private Integer positionNum;

    private List<EquipmentType> equipmentType;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode( String inputCode ) {
        this.inputCode = inputCode;
    }

    public Long getMachineRoomId() {
        return machineRoomId;
    }

    public void setMachineRoomId( Long machineRoomId ) {
        this.machineRoomId = machineRoomId;
    }

    public Integer getKeepYears() {
        return keepYears;
    }

    public void setKeepYears( Integer keepYears ) {
        this.keepYears = keepYears;
    }

    public Date getInWorkTime() {
        return inWorkTime;
    }

    public void setInWorkTime( Date inWorkTime ) {
        this.inWorkTime = inWorkTime;
    }

    public Integer getImportant() {
        return important;
    }

    public void setImportant( Integer important ) {
        this.important = important;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus( Integer status ) {
        this.status = status;
    }

    public String getLocaltionCode() {
        return localtionCode;
    }

    public void setLocaltionCode( String localtionCode ) {
        this.localtionCode = localtionCode;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode( String simpleCode ) {
        this.simpleCode = simpleCode;
    }

    public String getApiCode() {
        return apiCode;
    }

    public void setApiCode( String apiCode ) {
        this.apiCode = apiCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove( Boolean logicRemove ) {
        this.logicRemove = logicRemove;
    }

    public Long getSuperiorId() {
        return superiorId;
    }

    public void setSuperiorId(Long superiorId) {
        this.superiorId = superiorId;
    }

    public Integer getPartitionNum() {
        return partitionNum;
    }

    public void setPartitionNum(Integer partitionNum) {
        this.partitionNum = partitionNum;
    }

    public Integer getPositionNum() {
        return positionNum;
    }

    public void setPositionNum(Integer positionNum) {
        this.positionNum = positionNum;
    }

    public String getPlatformDeviceId() {
        return platformDeviceId;
    }

    public void setPlatformDeviceId(String platformDeviceId) {
        this.platformDeviceId = platformDeviceId;
    }

    public String getThirdDeviceId() {
        return thirdDeviceId;
    }

    public void setThirdDeviceId(String thirdDeviceId) {
        this.thirdDeviceId = thirdDeviceId;
    }

    public Long getEquipmentStateId() {
        return equipmentStateId;
    }

    public void setEquipmentStateId(Long equipmentStateId) {
        this.equipmentStateId = equipmentStateId;
    }

    public List<EquipmentType> getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType( List<EquipmentType> equipmentType ) {
        this.equipmentType = equipmentType;
    }
}