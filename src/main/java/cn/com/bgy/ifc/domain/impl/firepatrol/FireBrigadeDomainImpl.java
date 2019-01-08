package cn.com.bgy.ifc.domain.impl.firepatrol;

import cn.com.bgy.ifc.dao.firepatrol.FireBrigadeDao;
import cn.com.bgy.ifc.domain.interfaces.firepatrol.FireBrigadeDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.FireBrigade;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class FireBrigadeDomainImpl implements FireBrigadeDomain {

    @Resource
    private FireBrigadeDao fireBrigadeDao;

    /**
     * @description:
     * @param: [fireBrigade]
     * @return: java.util.List<cn.com.bgy.ifc.entity.po.firepatrol.FireBrigade>
     * @auther: chenlie
     * @date: 2019/1/7 17:20
     */
    @Override
    public List<FireBrigade> queryListByParam(FireBrigade fireBrigade) {

        return fireBrigadeDao.queryListByParam(fireBrigade);
    }
    /**
     * @description:
     * @param: [map]
     * @return: java.util.List<cn.com.bgy.ifc.entity.po.firepatrol.FireBrigade>
     * @auther: chenlie
     * @date: 2019/1/7 17:21
     */
    @Override
    public List<FireBrigade> queryListByMap(Map<String, Object> map) {

        return fireBrigadeDao.queryListByMap(map);
    }
    /**
     * @description:
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.po.firepatrol.FireBrigade
     * @auther: chenlie
     * @date: 2019/1/7 17:21
     */
    @Override
    public FireBrigade findById(Long id) {

        return fireBrigadeDao.findById(id);
    }
    /**
     * @description:
     * @param: [record]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:21
     */
    @Override
    public int insert(FireBrigade record) {

        return fireBrigadeDao.insert(record);
    }
    /**
     * @description:
     * @param: [record]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:21
     */
    @Override
    public int insertSelective(FireBrigade record) {

        return fireBrigadeDao.insertSelective(record);
    }

    /**
     * @description:
     * @param: [fireBrigade]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:21
     */
    @Override
    public int update(FireBrigade fireBrigade) {

        return fireBrigadeDao.update(fireBrigade);
    }
    /**
     * @description:
     * @param: [fireBrigade]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:22
     */
    @Override
    public int updateSelective(FireBrigade fireBrigade) {

        return fireBrigadeDao.updateSelective(fireBrigade);
    }
    /**
     * @description:
     * @param: [ids]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:22
     */
    @Override
    public int deleteBatch(List<Long> ids) {

        return fireBrigadeDao.deleteBatch(ids);
    }
    /**
     * @description:
     * @param: [page, fireBrigade]
     * @return: com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.firepatrol.FireBrigade>
     * @auther: chenlie
     * @date: 2019/1/7 17:22
     */
    @Override
    public PageInfo<FireBrigade> queryListByPage(Page<FireBrigade> page, FireBrigade fireBrigade) {

        page= PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<FireBrigade> list=fireBrigadeDao.queryListByParam(fireBrigade);
        return new PageInfo<FireBrigade>(list);
    }
}