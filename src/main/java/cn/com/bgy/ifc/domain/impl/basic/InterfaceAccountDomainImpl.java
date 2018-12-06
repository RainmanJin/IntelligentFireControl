package cn.com.bgy.ifc.domain.impl.basic;
import cn.com.bgy.ifc.dao.basic.InterfaceAccountDao;
import cn.com.bgy.ifc.domain.interfaces.basic.InterfaceAccountDomain;
import cn.com.bgy.ifc.entity.po.basic.InterfaceAccount;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class InterfaceAccountDomainImpl implements InterfaceAccountDomain {
    @Resource
    private InterfaceAccountDao interfaceaccountDao;
    @Override
    public InterfaceAccount findById(Long id) {
        return interfaceaccountDao.findById(id);
    }

    @Override
    public int insert(InterfaceAccount interfaceaccount) {
        return interfaceaccountDao.insert(interfaceaccount);
    }

    @Override
    public int deleteById(Long id) {
        return interfaceaccountDao.deleteById(id);
    }

    @Override
    public int update(InterfaceAccount interfaceaccount) {
        return interfaceaccountDao.update(interfaceaccount);
    }

    @Override
    public PageInfo<InterfaceAccount> searchByWhere(Page page, InterfaceAccount interfaceAccount) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<InterfaceAccount> interfaceaccountList = interfaceaccountDao.searchByWhere(interfaceAccount);
        PageInfo<InterfaceAccount> pageInfo = new PageInfo<>(interfaceaccountList);
        return pageInfo;
    }


}
