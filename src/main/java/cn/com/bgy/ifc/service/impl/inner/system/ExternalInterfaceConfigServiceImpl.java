package cn.com.bgy.ifc.service.impl.inner.system;

import cn.com.bgy.ifc.dao.system.ExternalInterfaceConfigDao;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.service.interfaces.inner.system.ExternalInterfaceConfigService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:接入接口配置
 * @date: 2018-12-27 11:09
 **/
@Service
public class ExternalInterfaceConfigServiceImpl implements ExternalInterfaceConfigService{

    @Resource
    private ExternalInterfaceConfigDao externalInterfaceConfigDao;

    @Override
    public ExternalInterfaceConfig findById(Long id) {
        return externalInterfaceConfigDao.findById(id);
    }

    @Override
    public int insert(ExternalInterfaceConfig externalInterfaceConfig) {
        return externalInterfaceConfigDao.insert(externalInterfaceConfig);
    }

    @Override
    public int insertSelective(ExternalInterfaceConfig externalInterfaceConfig) {
        return externalInterfaceConfigDao.insertSelective(externalInterfaceConfig);
    }

    @Override
    public int update(ExternalInterfaceConfig externalInterfaceConfig) {
        return externalInterfaceConfigDao.update(externalInterfaceConfig);
    }

    @Override
    public int updateSelective(ExternalInterfaceConfig externalInterfaceConfig) {
        return externalInterfaceConfigDao.updateSelective(externalInterfaceConfig);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return externalInterfaceConfigDao.deleteBatch(ids);
    }

    @Override
    public PageInfo<ExternalInterfaceConfig> queryListByPage(Page<ExternalInterfaceConfig> page, Integer platformValue) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        ExternalInterfaceConfig config=new ExternalInterfaceConfig();
        config.setPlatformValue(platformValue);
        List<ExternalInterfaceConfig> externalInterfaceConfigList = externalInterfaceConfigDao.queryListByParam(config);
        PageInfo<ExternalInterfaceConfig> pageInfo = new PageInfo<>(externalInterfaceConfigList);
        return pageInfo;
    }
}
