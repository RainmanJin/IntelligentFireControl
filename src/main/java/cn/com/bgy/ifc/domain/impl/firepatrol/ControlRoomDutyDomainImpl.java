package cn.com.bgy.ifc.domain.impl.firepatrol;

import cn.com.bgy.ifc.dao.firepatrol.ControlRoomDutyDao;
import cn.com.bgy.ifc.domain.interfaces.firepatrol.ControlRoomDutyDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.ControlRoomDuty;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ControlRoomDutyDomainImpl  implements ControlRoomDutyDomain {

    @Resource
    private ControlRoomDutyDao controlRoomDutyDao;

    /**
     * @description:
     * @param: [controlRoomDuty]
     * @return: java.util.List<cn.com.bgy.ifc.entity.po.firepatrol.ControlRoomDuty>
     * @auther: chenlie
     * @date: 2019/1/7 17:13
     */
    @Override
    public List<ControlRoomDuty> queryListByParam(ControlRoomDuty controlRoomDuty) {
        return controlRoomDutyDao.queryListByParam(controlRoomDuty);
    }

    /**
     * @description:
     * @param: [map]
     * @return: java.util.List<cn.com.bgy.ifc.entity.po.firepatrol.ControlRoomDuty>
     * @auther: chenlie
     * @date: 2019/1/7 17:13
     */
    @Override
    public List<ControlRoomDuty> queryListByMap(Map<String, Object> map) {

        return controlRoomDutyDao.queryListByMap(map);
    }
    /**
     * @description:
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.po.firepatrol.ControlRoomDuty
     * @auther: chenlie
     * @date: 2019/1/7 17:14
     */
    @Override
    public ControlRoomDuty findById(Long id) {

        return controlRoomDutyDao.findById(id);
    }
    /**
     * @description:
     * @param: [record]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:14
     */
    @Override
    public int insert(ControlRoomDuty record) {

        return controlRoomDutyDao.insert(record);
    }

    /**
     * @description:
     * @param: [record]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:14
     */
    @Override
    public int insertSelective(ControlRoomDuty record) {
        record.setCreateTime(new Date());
        return controlRoomDutyDao.insertSelective(record);
    }

    /**
     * @description:
     * @param: [controlRoomDuty]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:14
     */
    @Override
    public int update(ControlRoomDuty controlRoomDuty) {

        return controlRoomDutyDao.update(controlRoomDuty);
    }
    /**
     * @description:
     * @param: [controlRoomDuty]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:14
     */
    @Override
    public int updateSelective(ControlRoomDuty controlRoomDuty) {

        return controlRoomDutyDao.updateSelective(controlRoomDuty);
    }
    /**
     * @description:
     * @param: [ids]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:15
     */
    @Override
    public int deleteBatch(List<Long> ids) {

        return controlRoomDutyDao.deleteBatch(ids);
    }
    /**
     * @description:
     * @param: [page, controlRoomDuty]
     * @return: com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.firepatrol.ControlRoomDuty>
     * @auther: chenlie
     * @date: 2019/1/7 17:15
     */
    @Override
    public PageInfo<ControlRoomDuty> queryListByPage(Page<ControlRoomDuty> page, ControlRoomDuty controlRoomDuty) {

        page=  PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<ControlRoomDuty> list=controlRoomDutyDao.queryListByParam(controlRoomDuty);
        return new PageInfo<ControlRoomDuty>(list);
    }
}