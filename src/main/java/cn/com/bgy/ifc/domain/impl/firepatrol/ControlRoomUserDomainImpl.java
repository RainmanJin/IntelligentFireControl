package cn.com.bgy.ifc.domain.impl.firepatrol;

import cn.com.bgy.ifc.dao.firepatrol.ControlRoomUserDao;
import cn.com.bgy.ifc.domain.interfaces.firepatrol.ControlRoomUserDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.ControlRoomUser;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ControlRoomUserDomainImpl implements ControlRoomUserDomain {


    @Resource
    private ControlRoomUserDao controlRoomUserDao;


    /**
     * @description:
     * @param: [controlRoomUser]
     * @return: java.util.List<cn.com.bgy.ifc.entity.po.firepatrol.ControlRoomUser>
     * @auther: chenlie
     * @date: 2019/1/7 17:15
     */
    @Override
    public List<ControlRoomUser> queryListByParam(ControlRoomUser controlRoomUser) {

        return controlRoomUserDao.queryListByParam(controlRoomUser);
    }
    /**
     * @description:
     * @param: [map]
     * @return: java.util.List<cn.com.bgy.ifc.entity.po.firepatrol.ControlRoomUser>
     * @auther: chenlie
     * @date: 2019/1/7 17:15
     */
    @Override
    public List<ControlRoomUser> queryListByMap(Map<String, Object> map) {

        return controlRoomUserDao.queryListByMap(map);
    }
    /**
     * @description:
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.po.firepatrol.ControlRoomUser
     * @auther: chenlie
     * @date: 2019/1/7 17:16
     */
    @Override
    public ControlRoomUser findById(Long id) {

        return controlRoomUserDao.findById(id);
    }
    /**
     * @description:
     * @param: [record]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:16
     */
    @Override
    public int insert(ControlRoomUser record) {
        record.setCreateTime(new Date());
        record.setLogicRemove(false);
        return controlRoomUserDao.insert(record);
    }
    /**
     * @description:
     * @param: [record]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:16
     */
    @Override
    public int insertSelective(ControlRoomUser record) {
        record.setCreateTime(new Date());
        record.setLogicRemove(false);
        return controlRoomUserDao.insertSelective(record);
    }
    /**
     * @description:
     * @param: [controlRoomUser]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:16
     */
    @Override
    public int update(ControlRoomUser controlRoomUser) {
        controlRoomUser.setCreateTime(new Date());
        return controlRoomUserDao.update(controlRoomUser);
    }
    /**
     * @description:
     * @param: [controlRoomUser]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:17
     */
    @Override
    public int updateSelective(ControlRoomUser controlRoomUser) {
        controlRoomUser.setCreateTime(new Date());
        return controlRoomUserDao.updateSelective(controlRoomUser);
    }
    /**
     * @description:
     * @param: [ids]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:18
     */
    @Override
    public int deleteBatch(List<Long> ids) {

        return controlRoomUserDao.deleteBatch(ids);
    }
    /**
     * @description:
     * @param: [page, controlRoomUser]
     * @return: com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.firepatrol.ControlRoomUser>
     * @auther: chenlie
     * @date: 2019/1/7 17:18
     */
    @Override
    public PageInfo<ControlRoomUser> queryListByPage(Page<ControlRoomUser> page, ControlRoomUser controlRoomUser) {

        page= PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<ControlRoomUser> list=controlRoomUserDao.queryListByParam(controlRoomUser);

        return new PageInfo<ControlRoomUser>(list);
    }
}