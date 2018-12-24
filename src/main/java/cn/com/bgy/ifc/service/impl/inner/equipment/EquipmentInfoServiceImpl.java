package cn.com.bgy.ifc.service.impl.inner.equipment;


import cn.com.bgy.ifc.domain.interfaces.equipment.EquipmentInfoDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentInfo;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentInfoView;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * @Author huxin
 * @Date 2018/12/21 11:13
 * @Description 设备信息serviceImpl
 **/
@Service
public class EquipmentInfoServiceImpl implements EquipmentInfoService {


    @Autowired
    private EquipmentInfoDomain equipmentInfoDomain;
    /**
     * @Author huxin
     * @Description 差
     * @Date 2018/12/21 11:30
     */

    @Override
    public PageInfo queryListEquipmentInfo( Page<Object> page,EquipmentInfoView equipmentInfoView ) {
        return equipmentInfoDomain.queryListEquipmentInfo(page,equipmentInfoView);
    }

    /**
     * @Author huxin
     * @Description 增
     * @Date 2018/12/21 11:30
     */
    @Override
    public int addEquipmentInfo( EquipmentInfo equipmentInfo ) {
        return equipmentInfoDomain.addEquipmentInfo(equipmentInfo);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/21 11:31
     */
    @Override
    public int updateEquipmentInfo( EquipmentInfo equipmentInfo ) {
        return equipmentInfoDomain.updateEquipmentInfo(equipmentInfo);
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/21 11:36
     */
    @Override
    public int deleteEquipmentInfo( String str ) {
        return equipmentInfoDomain.deleteEquipmentInfo(str);
    }
    /**
     * @Author huxin
     * @Description 根据id查询设备所有信息
     * @Date 2018/12/24 16:00
     */
    @Override
    public Map<String, Object> queryEquipmentInfoById( Long id ) {
        return equipmentInfoDomain.queryEquipmentInfoById(id);
    }
}
