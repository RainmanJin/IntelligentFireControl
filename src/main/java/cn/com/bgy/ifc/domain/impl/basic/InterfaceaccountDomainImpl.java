package cn.com.bgy.ifc.domain.impl.basic;
import cn.com.bgy.ifc.domain.interfaces.basic.InterfaceaccountDomain;
import cn.com.bgy.ifc.entity.po.basic.Interfaceaccount;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class InterfaceaccountDomainImpl implements InterfaceaccountDomain {
    @Resource
    private InterfaceaccountDao interfaceaccountDao;
    @Override
    public Interfaceaccount findById(Long id) {
        return interfaceaccountDao.findById(id);
    }

    @Override
    public int insert(Interfaceaccount interfaceaccount) {
        return interfaceaccountDao.insert(interfaceaccount);
    }

    @Override
    public int deleteById(Long id) {
        return interfaceaccountDao.deleteById(id);
    }

    @Override
    public int update(Interfaceaccount interfaceaccount) {
        return interfaceaccountDao.update(interfaceaccount);
    }
}
