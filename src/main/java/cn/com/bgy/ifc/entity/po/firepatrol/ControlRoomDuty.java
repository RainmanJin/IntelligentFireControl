package cn.com.bgy.ifc.entity.po.firepatrol;

import java.util.Date;

public class ControlRoomDuty {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 监控室人员id
     */
    private Long userId;
    
    /**
     * @description:
     * @param: 
     * @return: 值班人姓名
     * @auther: chenlie
     * @date: 2019/1/17 11:14
     */
    private String userName;


    /**
     * 1负责人，0一般人员
     */
    private Integer userType;

    /**
     * 上班时间
     */
    private Date startTime;

    /**
     * 下班时间
     */
    private Date endTime;

    /**
     * 值班日期
     */
    private Date dutyDate;

    /**
     * 值班类型：1早班，2中班，3晚班
     */
    private String dutyType;

    /**
     * 监控室名称
     */
    private String roomName;

    /**
     * 监控室地址
     */
    private String address;

    /**
     * 创建时间
     */
    private Date createTime;


    //逻辑删除 0:存在 1:删除
    private Boolean logicRemove;


    private String keyWords;


    /**
     * 主键id
     * @return id 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 监控室人员id
     * @return user_id 监控室人员id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 监控室人员id
     * @param userId 监控室人员id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 1负责人，0一般人员
     * @return user_type 1负责人，0一般人员
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 1负责人，0一般人员
     * @param userType 1负责人，0一般人员
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 上班时间
     * @return start_time 上班时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 上班时间
     * @param startTime 上班时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 下班时间
     * @return end_time 下班时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 下班时间
     * @param endTime 下班时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 值班日期
     * @return duty_date 值班日期
     */
    public Date getDutyDate() {
        return dutyDate;
    }

    /**
     * 值班日期
     * @param dutyDate 值班日期
     */
    public void setDutyDate(Date dutyDate) {
        this.dutyDate = dutyDate;
    }

    /**
     * 值班类型：1早班，2中班，3晚班
     * @return duty_type 值班类型：1早班，2中班，3晚班
     */
    public String getDutyType() {
        return dutyType;
    }

    /**
     * 值班类型：1早班，2中班，3晚班
     * @param dutyType 值班类型：1早班，2中班，3晚班
     */
    public void setDutyType(String dutyType) {
        this.dutyType = dutyType;
    }

    /**
     * 监控室名称
     * @return room_name 监控室名称
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * 监控室名称
     * @param roomName 监控室名称
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     * 监控室地址
     * @return address 监控室地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 监控室地址
     * @param address 监控室地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove( Boolean logicRemove ) {
        this.logicRemove = logicRemove;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}