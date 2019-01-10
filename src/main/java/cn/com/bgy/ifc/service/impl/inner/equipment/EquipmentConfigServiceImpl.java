package cn.com.bgy.ifc.service.impl.inner.equipment;

import cn.com.bgy.ifc.dao.equipment.EquipmentConfigDao;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentConfig;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentConfigService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:中联永安物联接口设备配置
 * @date: 2019-01-10 14:16
 **/
@Service
public class EquipmentConfigServiceImpl implements EquipmentConfigService {

    @Resource
    private EquipmentConfigDao equipmentConfigDao;

    @Override
    public EquipmentConfig findById(Long id) {
        return equipmentConfigDao.findById(id);
    }

    @Override
    public int insert(EquipmentConfig equipmentConfig) {
        return equipmentConfigDao.insert(equipmentConfig);
    }

    @Override
    public int insertSelective(EquipmentConfig equipmentConfig) {
        return equipmentConfigDao.insertSelective(equipmentConfig);
    }

    @Override
    public int update(EquipmentConfig equipmentConfig) {
        return equipmentConfigDao.update(equipmentConfig);
    }

    @Override
    public int updateSelective(EquipmentConfig equipmentConfig) {
        return equipmentConfigDao.updateSelective(equipmentConfig);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return equipmentConfigDao.deleteBatch(ids);
    }

    @Override
    public PageInfo<EquipmentConfig> queryListByPage(Page page, EquipmentConfig equipmentConfig) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<EquipmentConfig> list = equipmentConfigDao.queryListByParam(equipmentConfig);
        PageInfo<EquipmentConfig> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
