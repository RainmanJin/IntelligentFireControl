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
    PageInfo<ExternalInterfaceConfig> queryListByPage(Page<ExternalInterfaceConfig> page, ExternalInterfaceConfig ExternalInterfaceConfig);

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

    /**
     * 添加外部接口配置
     * @param record
     * @return
     */

    int insert(ExternalInterfaceConfig record);

    int insertSelective(ExternalInterfaceConfig record);

    int update(ExternalInterfaceConfig record);
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
