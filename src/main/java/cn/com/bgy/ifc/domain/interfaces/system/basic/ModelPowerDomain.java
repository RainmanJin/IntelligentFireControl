package cn.com.bgy.ifc.domain.interfaces.system.basic;

import cn.com.bgy.ifc.entity.po.system.basic.ModelPower;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ModelPowerDomain {
    PageInfo<ModelPower> queryPageList(Page page, ModelPower modelPower);

    /**
     * 添加权限
     * @param modelPower
     * @return
     */
    int insert(ModelPower modelPower);
    /**
     * 查询模块名称
     */
    List<String> getModelName();

    /**
     * 保存权限模块
     * @param modelPower
     * @return
     */
    int saveModelPower(ModelPower modelPower);

    /**
     * 逻辑删除权限（批量）逻辑删除menu（批量）
     * @param longs
     */
    void  deleteModelPower(Long[] longs);

    /**
     *逻辑删除权限逻辑删除menu
     * @param id
     */
    void  deleteModelPowerOne(Long id);
}
