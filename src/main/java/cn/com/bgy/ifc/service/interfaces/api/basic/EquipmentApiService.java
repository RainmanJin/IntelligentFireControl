package cn.com.bgy.ifc.service.interfaces.api.basic;

/**
 * @Author huxin
 * @Date 2018/12/11 16:27
 * @Description 消防设备数据调用接口
 **/

public interface EquipmentApiService {
    /**
     * @Author huxin
     * @Description 集成平台获取设备信息列表接口
     * @Date 2018/12/11 16:32
     */
    void obtainEquipment(int areaId,int projectId,int machineRoomId,int typeId,int pageNo,int pageSize);
    /**
     * @Author huxin
     * @Description 集成平台获取设备信息列表接口（增量）
     * @Date 2018/12/11 16:33
     */
    void obtainListEquipment(String startTime,int pageNo, int pageSize);

    /**
     * @author: ZhangCheng
     * @description:获取集成平台用户信息
     * @param: [pageNo, pageSize]
     * @return: void
     */
    void obtainBgyEquipmentVersion(int pageNo, int pageSize);

    /**
     * @author: ZhangCheng
     * @description:获取集成平台用户信息
     * @param: [pageNo, pageSize]
     * @return: void
     */
    void obtainBgyEquipmentVersionIncrement(int pageNo, int pageSize);
    /**
     * @Author huxin
     * @Description 获取集成平台设备类型
     * @Date 2018/12/12 16:10
     */
    void obtainEquipmentType(int pageNo, int pageSize);
    /**
     * @Author huxin
     * @Description 获取集成平台设备类型（增量）
     * @Date 2018/12/12 16:12
     */
    void obtainListEquipmentType(String startTime,int pageNo, int pageSize);
}
