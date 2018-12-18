package cn.com.bgy.ifc.domain.interfaces.system.basic;

import cn.com.bgy.ifc.entity.po.system.basic.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.system.basic.ExternalInterfaceConfigVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:外部接入接口配置
 * @date: 2018-12-10 18:10
 **/
public interface ExternalInterfaceConfigDomain {

    /**
     * 分页查询接入接口配置
     * @param page
     * @return
     */
    PageInfo<ExternalInterfaceConfigVo> queryListByPage(Page<ExternalInterfaceConfigVo> page, ExternalInterfaceConfigVo ExternalInterfaceConfigVo);

    /**
     *
     * @param record
     * @return
     */
    List<ExternalInterfaceConfig> queryListByParam(ExternalInterfaceConfig record);

    /**
     * 查询集成平台接口信息
     * @return
     */
    List<ExternalInterfaceConfig> queryIntegrationConfig();

    ExternalInterfaceConfig findById(Long id);

    int insert(ExternalInterfaceConfig record);

    int insertSelective(ExternalInterfaceConfig record);

    int update(ExternalInterfaceConfig record);
}
