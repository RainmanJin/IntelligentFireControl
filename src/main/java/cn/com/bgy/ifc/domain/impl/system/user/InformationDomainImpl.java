package cn.com.bgy.ifc.domain.impl.system.user;
import cn.com.bgy.ifc.dao.system.basic.InformationDao;
import cn.com.bgy.ifc.domain.interfaces.system.user.InformationDomain;
import cn.com.bgy.ifc.entity.po.system.basic.Information;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

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
    public void deleteInformation(Long[] longs) {
        informationDao.deleteInformation(longs);
    }

    @Override
    public int update(Information information) {
        return informationDao.update(information);
    }

    @Override
    public PageInfo<Information> searchByPage(Page page, Information information) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<Information> informationList = informationDao.searchByWhere(information);
        PageInfo<Information> pageInfo = new PageInfo<>(informationList);
        return pageInfo;
    }
}
