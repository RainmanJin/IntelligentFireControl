package cn.com.bgy.ifc.service.interfaces.inner.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.base.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author: ZhangCheng
 * @description:中联永安物联接口设备配置
 * @date: 2019-01-10 14:14
 **/
public interface EquipmentConfigService {

    /**
     * 设备配置信息分页查询
     * @param page
     * @param equipmentConfig
     * @return
     */
    PageInfo<EquipmentConfig> queryListByPage(Page page, EquipmentConfig equipmentConfig);

    /**
     * 设备配置信息ID查询
     * @param id
     * @return
     */
    EquipmentConfig findById(Long id);

    /**
     * 设备配置信息编辑
     * @param equipmentConfig
     * @return
     */
    ResponseVO<Object> createEquipmentConfig(EquipmentConfig equipmentConfig);

    /**
     * 设备配置信息编辑
     * @param equipmentConfig
     * @return
     */
    ResponseVO<Object> editEquipmentConfig(EquipmentConfig equipmentConfig);

    /**
     * 设备配置信息重新同步
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseVO<Object> synchroEquipmentConfig(int pageNum, int pageSize);

    /**
     * 设备配置信息删除
     * @param ids
     * @return
     */
    ResponseVO<Object> deleteEquipmentConfig(String ids);
}
