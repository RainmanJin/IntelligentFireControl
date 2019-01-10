package cn.com.bgy.ifc.service.interfaces.inner.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentConfig;
import cn.com.bgy.ifc.service.interfaces.inner.base.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author: ZhangCheng
 * @description:中联永安物联接口设备配置
 * @date: 2019-01-10 14:14
 **/
public interface EquipmentConfigService extends BaseService<EquipmentConfig> {

    PageInfo<EquipmentConfig> queryListByPage(Page page, EquipmentConfig equipmentConfig);
}
