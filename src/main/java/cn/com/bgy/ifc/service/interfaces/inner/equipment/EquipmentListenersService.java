package cn.com.bgy.ifc.service.interfaces.inner.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentEvent;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentListeners;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author: ZhangCheng
 * @description:设备监听事件管理
 * @date: 2019-01-16 14:05
 **/
public interface EquipmentListenersService {

    /**
     * 设备事件分页查询
     * @param page
     * @param keyword
     * @return
     */
    PageInfo<EquipmentListeners> queryListByPage(Page page, String keyword);

    /**
     * 设备事件ID查询
     * @param id
     * @return
     */
    EquipmentListeners findById(Long id);

    /**
     * 设备事件添加
     * @param equipmentListeners
     * @return
     */
    ResponseVO<Object> createEquipmentListeners(EquipmentListeners equipmentListeners);

    /**
     * 设备事件编辑
     * @param equipmentListeners
     * @return
     */
    ResponseVO<Object> editEquipmentListeners(EquipmentListeners equipmentListeners);

    /**
     * 设备监听事件拟量重新同步
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseVO<Object> synchroEquipmentListeners(int pageNum, int pageSize);

    /**
     * 设备事件监听删除
     * @param ids
     * @return
     */
    ResponseVO<Object> deleteEquipmentListeners(String ids);
}
