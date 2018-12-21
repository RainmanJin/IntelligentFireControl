package cn.com.bgy.ifc.domain.impl.system.basic;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.dao.system.basic.ExternalInterfaceConfigDao;
import cn.com.bgy.ifc.domain.interfaces.system.basic.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.entity.po.system.basic.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.system.basic.ExternalInterfaceConfigVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:外部接入接口配置
 * @date: 2018-12-10 18:16
 **/
@Service
public class ExternalInterfaceConfigDomainImpl implements ExternalInterfaceConfigDomain {

    @Resource
    private ExternalInterfaceConfigDao externalInterfaceConfigDao;

    /**
     * 批量删除外部接口配置
     * @param longs
     */
    @Override
    public void deleteExternalInterfaceConfig(Long[] longs) {
        externalInterfaceConfigDao.deleteExternalInterfaceConfig(longs);
    }

    /**
     * 通过id删除
     * @param id
     * @return
     */
    @Override
    public int deleteById(Long id) {
        return externalInterfaceConfigDao.deleteById(id);
    }

    /**
     * 分页查询外部接口配置
     * @param page
     * @param externalInterfaceConfig
     * @return
     */
    @Override
    public PageInfo<ExternalInterfaceConfig> queryListByPage(Page<ExternalInterfaceConfig> page, ExternalInterfaceConfig externalInterfaceConfig) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<ExternalInterfaceConfig> externalInterfaceConfigList = externalInterfaceConfigDao.queryListByParam(externalInterfaceConfig);
        PageInfo<ExternalInterfaceConfig> pageInfo = new PageInfo<>(externalInterfaceConfigList);
        return pageInfo;
    }

    @Override
    public List<ExternalInterfaceConfig> queryListByParam(ExternalInterfaceConfig record) {
        return externalInterfaceConfigDao.queryListByParam(record);
    }

    @Override
    public List<ExternalInterfaceConfig> queryIntegrationConfig() {
        ExternalInterfaceConfig record=new ExternalInterfaceConfig();
        record.setPlatformValue(ExternalConstant.PlatformValue.INTEGERATED_PLATFORM.getValue());
        record.setState(SystemConstant.EnableState.ENABLE.getValue());
        record.setLogicRemove(false);
        return externalInterfaceConfigDao.queryListByParam(record);
    }

    @Override
    public ExternalInterfaceConfig findById(Long id) {
        return externalInterfaceConfigDao.findById(id);
    }

    @Override
    public int insert(ExternalInterfaceConfig record) {
        return externalInterfaceConfigDao.insert(record);
    }

    @Override
    public int insertSelective(ExternalInterfaceConfig record) {
        return externalInterfaceConfigDao.insertSelective(record);
    }

    @Override
    public int update(ExternalInterfaceConfig record) {
        return externalInterfaceConfigDao.update(record);
    }
}
