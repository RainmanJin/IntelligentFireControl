package cn.com.bgy.ifc.service.interfaces.inner.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentState;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.base.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2019-01-10 19:25
 **/
public interface EquipmentStateService extends BaseService<EquipmentState> {

    PageInfo<EquipmentState> queryListByPage(Page page, EquipmentState equipmentState);

    ResponseVO<Object> synchroEquipmentState(int pageNum, int pageSize);
}
