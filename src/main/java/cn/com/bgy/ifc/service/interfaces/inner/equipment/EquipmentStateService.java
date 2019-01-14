package cn.com.bgy.ifc.service.interfaces.inner.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentState;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.EquipmentStateVo;
import cn.com.bgy.ifc.service.interfaces.inner.base.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2019-01-10 19:25
 **/
public interface EquipmentStateService extends BaseService<EquipmentState> {

    PageInfo<EquipmentState> queryListByPage(Page page, EquipmentStateVo equipmentStateVo);

    /**
     * 设备配置状态信息重新同步
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseVO<Object> synchroEquipmentState(int pageNum, int pageSize);

    /**
     *  设备配置状态信息删除
     * @param ids
     * @return
     */
    ResponseVO<Object>  deleteEquipmentState(String ids);
}
