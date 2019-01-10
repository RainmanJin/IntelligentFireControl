package cn.com.bgy.ifc.service.impl.inner.equipment;

import cn.com.bgy.ifc.dao.equipment.AnalogueUnitDao;
import cn.com.bgy.ifc.entity.po.equipment.AnalogueUnit;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.AnalogueUnitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:中联永安物联接口模拟量单位
 * @date: 2019-01-10 15:29
 **/
@Service
public class AnalogueUnitServiceImpl implements AnalogueUnitService {

    @Resource
    private AnalogueUnitDao analogueUnitDao;

    /**
     * 查询所有模拟量单位
     * @return
     */
    @Override
    public List<AnalogueUnit> queryAllList() {
        return analogueUnitDao.queryAllList();
    }
}
