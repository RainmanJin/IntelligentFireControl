package cn.com.bgy.ifc.service.impl.inner.equipment;


import cn.com.bgy.ifc.bgy.constant.EquipmentConstant;
import cn.com.bgy.ifc.dao.equipment.EquipmentInfoDao;
import cn.com.bgy.ifc.domain.interfaces.equipment.EquipmentInfoDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentInfo;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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

    @Resource
    private EquipmentInfoDao equipmentInfoDao;
    /**
     * @Author huxin
     * @Description 差
     * @Date 2018/12/21 11:30
     */

    @Override
    public PageInfo queryListEquipmentInfo( Page<Object> page,RegionAndBrandVO regionAndBrandVO ) {
        return equipmentInfoDomain.queryListEquipmentInfo(page,regionAndBrandVO);
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
    /*
     * @Author  huxin
     * @Description 根据项目ID，苑区ID查询设备下拉框
     * @param   [projectId, courtId]
     * @retrue  java.util.List<cn.com.bgy.ifc.entity.po.equipment.EquipmentInfo>
     * @Date 2019/1/15 11:49
     **/
    @Override
    public List<EquipmentInfo> ListByCourtId(Long projectId, Long courtId ) {
        if(projectId!=null && projectId>0 || courtId!=null && courtId>0){
            Map<String,Object> map = new HashMap<>();
            map.put("projectId",projectId);
            map.put("courtId",courtId);
            return equipmentInfoDao.ListByCourtId(map);
        }
        return null;
    }

    @Override
    public List<EquipmentInfo> queryAllList() {
        //获取正常且未删除所有设备
        EquipmentInfo equipmentInfo=new EquipmentInfo();
        equipmentInfo.setStatus(EquipmentConstant.RunState.NORMAL.getValue());
        return equipmentInfoDao.queryListByParam(equipmentInfo);
    }
}
