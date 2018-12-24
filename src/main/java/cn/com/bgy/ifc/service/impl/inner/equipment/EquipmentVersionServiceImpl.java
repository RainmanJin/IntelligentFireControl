package cn.com.bgy.ifc.service.impl.inner.equipment;

import cn.com.bgy.ifc.domain.interfaces.equipment.EquipmentVersionDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentVersion;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentVersionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author huxin
 * @Date 2018/12/21 16:22
 * @Description 设备型号
 **/
@Service
public class EquipmentVersionServiceImpl implements EquipmentVersionService {

    @Autowired
    private EquipmentVersionDomain equipmentVersionDomain;

    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/24 9:59
     */

    @Override
    public PageInfo queryListEquipmentVersion( Page page, Integer brandID, String keyword ) {
        return equipmentVersionDomain.queryListEquipmentVersion( page, brandID, keyword);
    }
    /**
     * @Author huxin
     * @Description 添加
     * @Date 2018/12/24 10:00
     */
    @Override
    public int addEquipmentVersion( EquipmentVersion record ) {
        return equipmentVersionDomain.addEquipmentVersion(record);
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/24 10:00
     */
    @Override
    public int updateEquipmentVersion( EquipmentVersion record ) {
        return equipmentVersionDomain.updateEquipmentVersion(record);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/24 10:00
     */
    @Override
    public int deleteEquipmentVersion( String str ) {
        return equipmentVersionDomain.deleteEquipmentVersion(str);
    }
}
