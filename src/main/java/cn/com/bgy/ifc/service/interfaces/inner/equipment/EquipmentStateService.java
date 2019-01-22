package cn.com.bgy.ifc.service.interfaces.inner.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentConfig;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentState;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.EquipmentStateVo;
import cn.com.bgy.ifc.service.interfaces.inner.base.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2019-01-10 19:25
 **/
public interface EquipmentStateService extends BaseService<EquipmentState> {

    /**
     * 设备状态信息分页查询
     * @param page
     * @param equipmentStateVo
     * @return
     */
    PageInfo<EquipmentState> queryListByPage(Page page, EquipmentStateVo equipmentStateVo);

    /**
     * 设备状态信息查询所有
     * @return
     */
    List<EquipmentState> queryAllList();

    /**
     * 设备状态信息重新同步
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseVO<Object> synchroEquipmentState(int pageNum, int pageSize);

    /**
     * 设备基础信息编辑
     * @param equipmentState
     * @return
     */
    ResponseVO<Object> createEquipmentState(EquipmentState equipmentState);

    ResponseVO<Object> createEquipmentBySynchro();

    /**
     * 设备基础信息编辑
     * @param equipmentState
     * @return
     */
    ResponseVO<Object> editEquipmentState(EquipmentState equipmentState);

    /**
     *  设备配置状态信息删除
     * @param ids
     * @return
     */
    ResponseVO<Object>  deleteEquipmentState(String ids);
}
