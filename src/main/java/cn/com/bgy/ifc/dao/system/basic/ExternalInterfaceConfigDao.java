package cn.com.bgy.ifc.dao.system.basic;

import cn.com.bgy.ifc.entity.po.system.basic.ExternalInterfaceConfig;

import java.util.List;

public interface ExternalInterfaceConfigDao {

    List<ExternalInterfaceConfig> queryListByParam(ExternalInterfaceConfig externalInterfaceConfig);

    ExternalInterfaceConfig findById(Long id);

    int insert(ExternalInterfaceConfig record);

    int insertSelective(ExternalInterfaceConfig externalInterfaceConfig);

    int update(ExternalInterfaceConfig externalInterfaceConfig);
    /**
     * 逻辑删除外部接口配置（批量）
     * @param longs
     */
    void  deleteExternalInterfaceConfig(Long[] longs);

    /**
     * 通过id删除
     * @param id
     * @return
     */
    int deleteById(Long id);
}