package cn.com.bgy.ifc.entity.vo.alarm;

import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:实时告警列表VO
 * @date: 2019-01-19 16:33
 **/
public class AlarmVo {

    private Long id;

    /**
     * 告警等级
     */
    private String alarmGrade;

    /**
     * 告警描述
     */
    private String description;

    /**
     * 告警量
     */
    private Integer reportCount;

    /**
     * 告警时间
     */
    private Date lastTime;

    /**
     * 告警时长
     */
    private String alarmDuration;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 机房
     */
    private String computerRoomName;

    /**
     * 设备名称
     */
    private String deviceName;


}
