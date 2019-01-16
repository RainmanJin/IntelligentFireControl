package cn.com.bgy.ifc.service.impl.inner.equipment;

import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.dao.equipment.EquipmentTypeDao;
import cn.com.bgy.ifc.domain.interfaces.equipment.EquipmentTypeDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentState;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentType;
import cn.com.bgy.ifc.entity.vo.equipment.EquipmentTypeVo;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentTypeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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

    @Override
    public PageInfo<EquipmentType> queryListByPage(Page<EquipmentType> page, EquipmentTypeVo equipmentTypeVo) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<EquipmentType> list = equipmentTypeDao.queryListByParam(equipmentTypeVo);
        PageInfo<EquipmentType> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * @Author huxin
     * @Description 查
     * @Date 2018/12/23 17:16
     */
    @Override
    public PageInfo queryListEquipmentType( Page page,String keyword) {
        return equipmentTypeDomain.queryListEquipmentType(page,keyword);

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
    public EquipmentType findById(Long id) {
            return  equipmentTypeDao.findById(id);
    }

    @Override
    public int insert(EquipmentType equipmentType) {
        if(equipmentType.getParentId()==null){
            equipmentType.setParentId(0L);
        }
        equipmentType.setStatus(SystemConstant.EnableState.ENABLE.getValue());
        equipmentType.setLogicRemove(false);
        return equipmentTypeDao.insert(equipmentType);
    }

    @Override
    public int insertSelective(EquipmentType equipmentType) {
        if(equipmentType.getParentId()==null){
            equipmentType.setParentId(0L);
        }
        equipmentType.setStatus(SystemConstant.EnableState.ENABLE.getValue());
        equipmentType.setLogicRemove(false);
        return equipmentTypeDao.insertSelective(equipmentType);
    }

    @Override
    public int update(EquipmentType equipmentType) {
        if(equipmentType.getParentId()==null){
            equipmentType.setParentId(0L);
        }
        return equipmentTypeDao.update(equipmentType);
    }

    @Override
    public int updateSelective(EquipmentType equipmentType) {
        if(equipmentType.getParentId()==null){
            equipmentType.setParentId(0L);
        }
        return equipmentTypeDao.updateSelective(equipmentType);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return equipmentTypeDao.deleteBatch(ids);
    }

    @Override
    public List<EquipmentType> queryAllEquipmentType() {
        EquipmentType equipmentType=new EquipmentType();
        equipmentType.setStatus(SystemConstant.EnableState.ENABLE.getValue());
        equipmentType.setLogicRemove(false);
        return equipmentTypeDao.queryAllList(equipmentType);
    }

    @Override
    public List<EquipmentType> queryAllList() {
        EquipmentType equipmentType=new EquipmentType();
        equipmentType.setStatus(SystemConstant.EnableState.ENABLE.getValue());
        equipmentType.setLogicRemove(false);
        return equipmentTypeDao.queryAllList(equipmentType);
    }

}
