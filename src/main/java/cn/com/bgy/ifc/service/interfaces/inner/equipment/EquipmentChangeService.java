package cn.com.bgy.ifc.service.interfaces.inner.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentChange;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author: ZhangCheng
 * @description:设备状态变化管理
 * @date: 2019-01-17 11:33
 **/
public interface EquipmentChangeService {
    /**
     * 设备事件分页查询
     * @param page
     * @param equipmentChange
     * @return
     */
    PageInfo<EquipmentChange> queryListByPage(Page page, EquipmentChange equipmentChange);

    /**
     * 设备事件ID查询
     * @param id
     * @return
     */
    EquipmentChange findById(Long id);

    /**
     * 设备事件添加
     * @param equipmentChange
     * @return
     */
    ResponseVO<Object> createEquipmentChange(EquipmentChange equipmentChange);

    /**
     * 设备事件编辑
     * @param equipmentChange
     * @return
     */
    ResponseVO<Object> editEquipmentChange(EquipmentChange equipmentChange);

    /**
     * 设备事件拟量重新同步
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseVO<Object> synchroEquipmentChange(int pageNum, int pageSize);

    /**
     * 设备事件删除
     * @param ids
     * @return
     */
    ResponseVO<Object> deleteEquipmentChange(String ids);
}
