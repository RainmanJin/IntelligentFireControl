package cn.com.bgy.ifc.domain.impl.firepatrol;

import cn.com.bgy.ifc.dao.firepatrol.FireRehearseDao;
import cn.com.bgy.ifc.domain.interfaces.firepatrol.FireRehearseDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.FireRehearse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class FireRehearseDomainImpl implements FireRehearseDomain {

    @Resource
    private FireRehearseDao fireRehearseDao;

    /**
     * @description:
     * @param: [fireRehearse]
     * @return: java.util.List<cn.com.bgy.ifc.entity.po.firepatrol.FireRehearse>
     * @auther: chenlie
     * @date: 2019/1/7 17:12
     */
    @Override
    public List<FireRehearse> queryListByParam(FireRehearse fireRehearse) {
        return fireRehearseDao.queryListByParam(fireRehearse);
    }
    /**
     * @description:
     * @param: [map]
     * @return: java.util.List<cn.com.bgy.ifc.entity.po.firepatrol.FireRehearse>
     * @auther: chenlie
     * @date: 2019/1/7 17:12
     */
    @Override
    public List<FireRehearse> queryListByMap(Map<String, Object> map) {
        return fireRehearseDao.queryListByMap(map);
    }
    /**
     * @description:
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.po.firepatrol.FireRehearse
     * @auther: chenlie
     * @date: 2019/1/7 17:12
     */
    @Override
    public FireRehearse findById(Long id) {
        return fireRehearseDao.findById(id);
    }
    /**
     * @description:
     * @param: [record]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:11
     */
    @Override
    public int insert(FireRehearse record) {
        record.setLogicRemove(false);
        record.setCreateTime(new Date());
        return fireRehearseDao.insert(record);
    }
    /**
     * @description:
     * @param: [record]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:13
     */
    @Override
    public int insertSelective(FireRehearse record) {
        record.setLogicRemove(false);
        record.setCreateTime(new Date());
        return fireRehearseDao.insertSelective(record);
    }

    /**
     * @description:
     * @param: [fireRehearse]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:11
     */
    @Override
    public int update(FireRehearse fireRehearse) {
        fireRehearse.setCreateTime(new Date());
        return fireRehearseDao.update(fireRehearse);
    }

    /**
     * @description:
     * @param: [fireRehearse]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:11
     */
    @Override
    public int updateSelective(FireRehearse fireRehearse) {
        fireRehearse.setCreateTime(new Date());
        return fireRehearseDao.updateSelective(fireRehearse);
    }

    /**
     * @description:
     * @param: [ids]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:10
     */
    @Override
    public int deleteBatch(List<Long> ids) {
        return fireRehearseDao.deleteBatch(ids);
    }
    /**
     * @description:
     * @param: [page, fireRehearse]
     * @return: com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.firepatrol.FireRehearse>
     * @auther: chenlie
     * @date: 2019/1/7 17:10
     */
    @Override
    public PageInfo<FireRehearse> queryListByPage(Page<FireRehearse> page, FireRehearse fireRehearse) {

        page= PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<FireRehearse> list=fireRehearseDao.queryListByParam(fireRehearse);
        return new PageInfo<FireRehearse>(list);
    }

}