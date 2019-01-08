package cn.com.bgy.ifc.domain.impl.firepatrol;

import cn.com.bgy.ifc.dao.firepatrol.FireAccidentDao;
import cn.com.bgy.ifc.domain.interfaces.firepatrol.FireAccidentDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.FireAccident;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class FireAccidentDomainImpl implements FireAccidentDomain {
    @Resource
    private FireAccidentDao fireAccidentDao;

    /**
     * @description:
     * @param: [fireAccident]
     * @return: java.util.List<cn.com.bgy.ifc.entity.po.firepatrol.FireAccident>
     * @auther: chenlie
     * @date: 2019/1/7 17:18
     */
    @Override
    public List<FireAccident> queryListByParam(FireAccident fireAccident) {

        return fireAccidentDao.queryListByParam(fireAccident);
    }

    /**
     * @description:
     * @param: [map]
     * @return: java.util.List<cn.com.bgy.ifc.entity.po.firepatrol.FireAccident>
     * @auther: chenlie
     * @date: 2019/1/7 17:18
     */
    @Override
    public List<FireAccident> queryListByMap(Map<String, Object> map) {

        return fireAccidentDao.queryListByMap(map);
    }
    /**
     * @description:
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.po.firepatrol.FireAccident
     * @auther: chenlie
     * @date: 2019/1/7 17:19
     */
    @Override
    public FireAccident findById(Long id) {

        return fireAccidentDao.findById(id);
    }
    /**
     * @description:
     * @param: [record]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:19
     */
    @Override
    public int insert(FireAccident record) {

        return fireAccidentDao.insert(record);
    }

    /**
     * @description:
     * @param: [record]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:19
     */
    @Override
    public int insertSelective(FireAccident record) {

        return fireAccidentDao.insertSelective(record);
    }
    /**
     * @description:
     * @param: [fireAccident]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:19
     */
    @Override
    public int update(FireAccident fireAccident) {

        return fireAccidentDao.update(fireAccident);
    }
    /**
     * @description:
     * @param: [fireAccident]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:19
     */
    @Override
    public int updateSelective(FireAccident fireAccident) {

        return fireAccidentDao.updateSelective(fireAccident);
    }
    /**
     * @description:
     * @param: [ids]
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/7 17:19
     */
    @Override
    public int deleteBatch(List<Long> ids) {

        return fireAccidentDao.deleteBatch(ids);
    }

    /**
     * @description:
     * @param: [page, fireAccident]
     * @return: com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.firepatrol.FireAccident>
     * @auther: chenlie
     * @date: 2019/1/7 17:20
     */
    @Override
    public PageInfo<FireAccident> queryListByPage(Page<FireAccident> page, FireAccident fireAccident) {

        page= PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<FireAccident> list=fireAccidentDao.queryListByParam(fireAccident);
        return new PageInfo<FireAccident>(list);
    }
}