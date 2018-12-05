package cn.com.bgy.ifc.domain.impl.basic;
import cn.com.bgy.ifc.domain.interfaces.basic.InformationDomain;
import cn.com.bgy.ifc.entity.po.basic.Information;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
@Service
public class InformationDomainImpl implements InformationDomain {
    @Resource
    private InformationDao informationDao;

    @Override
    public Information findById(Long id) {
        return informationDao.findById(id);
    }

    @Override
    public int insert(Information information) {
        return informationDao.insert(information);
    }

    @Override
    public int deleteById(Long id) {
        return informationDao.deleteById(id);
    }

    @Override
    public int update(Information information) {
        return informationDao.update(information);
    }
}
