package cn.com.bgy.ifc.service.interfaces.inner.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentEvent;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.EquipmentEventVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author: ZhangCheng
 * @description:物联设备事件管理
 * @date: 2019-01-15 17:12
 **/
public interface EquipmentEventService {

    /**
     * 设备事件分页查询
     * @param page
     * @param equipmentEventVo
     * @return
     */
    PageInfo<EquipmentEvent> queryListByPage(Page page, EquipmentEventVo equipmentEventVo);

    /**
     * 设备事件ID查询
     * @param id
     * @return
     */
    EquipmentEvent findById(Long id);

    /**
     * 设备事件添加
     * @param equipmentEvent
     * @return
     */
    ResponseVO<Object> createEquipmentEvent(EquipmentEvent equipmentEvent);

    /**
     * 设备事件编辑
     * @param equipmentEvent
     * @return
     */
    ResponseVO<Object> editEquipmentEvent(EquipmentEvent equipmentEvent);

    /**
     * 设备事件拟量重新同步
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseVO<Object> synchroEquipmentEvent(int pageNum, int pageSize);

    /**
     * 设备事件删除
     * @param ids
     * @return
     */
    ResponseVO<Object> deleteEquipmentEvent(String ids);
}
