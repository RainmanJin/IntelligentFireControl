package cn.com.bgy.ifc.service.impl.inner.equipment;

import cn.com.bgy.ifc.dao.equipment.EquipmentTypeDao;
import cn.com.bgy.ifc.domain.interfaces.equipment.EquipmentTypeDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentType;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentTypeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/21 16:22
 * @Description 设备类型
 **/
@Service
public class EquipmentTypeServiceImpl implements EquipmentTypeService {

    @Autowired
    private EquipmentTypeDomain equipmentTypeDomain;

    @Resource
    private EquipmentTypeDao equipmentTypeDao;

    /**
     * @Author huxin
     * @Description 查
     * @Date 2018/12/23 17:16
     */
    @Override
    public PageInfo queryListEquipmentType( Page page,String keyword) {

        return equipmentTypeDomain.queryListEquipmentType(page,keyword);

    }
    /**
     * @Author huxin
     * @Description 增加
     * @Date 2018/12/23 17:16
     */
    @Override
    public int addEquipmentType( EquipmentType record ) {
        return equipmentTypeDomain.addEquipmentType(record);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/23 17:16
     */
    @Override
    public int updateEquipmentType( EquipmentType record ) {
        return equipmentTypeDomain.updateEquipmentType(record);
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/23 17:16
     */
    @Override
    public int deleteEquipmentType( String str ) {
        return equipmentTypeDomain.deleteEquipmentType(str);
    }

    @Override
    public List<Map<String, Object>> queryEquipmentTypeBySuperId( Long id ) {
        return equipmentTypeDomain.queryEquipmentTypeBySuperId(id);
    }
    /**
     * @Author huxin
     * @Description 根据ID查询类型信息
     * @Date 2019/1/2 14:21
     */
    @Override
    public Map<String, Object> findById( Long id ) {
        if(id != null || id>0){
            return (Map<String, Object>) equipmentTypeDao.findById(id);
        }
        return null;
    }

    @Override
    public List<Map<String, Object>> queryAllEquipmentType() {
        return equipmentTypeDao.queryAllEquipmentType();
    }

    @Override
    public List<EquipmentType> queryAllList() {
        EquipmentType equipmentType=new EquipmentType();
        equipmentType.setStatus(1);
        equipmentType.setLogicRemove(false);
        return equipmentTypeDao.queryAllList(equipmentType);
    }

}
