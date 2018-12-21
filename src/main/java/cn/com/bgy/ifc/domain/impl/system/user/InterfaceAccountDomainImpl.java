package cn.com.bgy.ifc.domain.impl.system.user;
import cn.com.bgy.ifc.dao.system.user.InterfaceAccountDao;
import cn.com.bgy.ifc.domain.interfaces.system.user.InterfaceAccountDomain;
import cn.com.bgy.ifc.entity.po.system.user.InterfaceAccount;
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

    /**
     * 批量删除用户接口
     * @param longs
     */
    @Override
    public void deleteInterfaceAccount(Long[] longs) {
        interfaceaccountDao.deleteInterfaceAccount(longs);
    }

    @Override
    public int update(InterfaceAccount interfaceaccount) {
        return interfaceaccountDao.update(interfaceaccount);
    }

    /**
     * 分页
     * @param page
     * @param interfaceAccount
     * @return
     */
    @Override
    public PageInfo<InterfaceAccount> searchByWhere(Page page,InterfaceAccount interfaceAccount) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<InterfaceAccount> interfaceaccountList = interfaceaccountDao.searchByWhere(interfaceAccount);
        PageInfo<InterfaceAccount> pageInfo = new PageInfo<>(interfaceaccountList);
        return pageInfo;
    }
}

