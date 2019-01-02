package cn.com.bgy.ifc.service.impl.inner.equipment;

import cn.com.bgy.ifc.dao.equipment.EquipmentBrandDao;
import cn.com.bgy.ifc.domain.interfaces.equipment.EquipmentBrandDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentBrand;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentBrandService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/21 11:13
 * @Description 设备信息serviceImpl
 **/
@Service
public class EquipmentBrandServiceImpl implements EquipmentBrandService {

    @Autowired
    private EquipmentBrandDomain equipmentBrandDomain;

    @Resource
    private EquipmentBrandDao equipmentBrandDao;

    /**
     * @Author huxin
     * @Description 差
     * @Date 2018/12/21 11:30
     */
    @Override
    public PageInfo queryListEquipmentBrand( Page page,String keyword) {
        return equipmentBrandDomain.queryListEquipmentBrand(page,keyword);
    }
    /**
     * @Author huxin
     * @Description 增
     * @Date 2018/12/21 11:30
     */
    @Override
    public int addEquipmentBrand( EquipmentBrand equipmentBrand ) {
        return equipmentBrandDomain.addEquipmentBrand(equipmentBrand);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/21 11:31
     */
    @Override
    public int updateEquipmentBrand( EquipmentBrand equipmentBrand ) {
        return equipmentBrandDomain.updateEquipmentBrand(equipmentBrand);
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/21 11:36
     */
    @Override
    public int deleteEquipmentBrand( String str ) {
        return equipmentBrandDomain.deleteEquipmentBrand(str);
    }
    /**
     * @Author huxin
     * @Description 查询所有品牌
     * @Date 2018/12/24 10:47
     */
    @Override
    public List<Map<String, Object>> queryAllEquipmentBrand() {
        return equipmentBrandDomain.queryAllEquipmentBrand();
    }

    @Override
    public Map<String, Object> findById( Long id ) {
        if(id != null || id>0){
            return (Map<String, Object>) equipmentBrandDao.findById(id);
        }
        return null;
    }
}
