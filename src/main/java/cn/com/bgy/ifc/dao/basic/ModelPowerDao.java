package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.ModelPower;
import cn.com.bgy.ifc.entity.po.basic.SystemMenu;
import cn.com.bgy.ifc.entity.po.basic.SystemModel;
import cn.com.bgy.ifc.entity.po.basic.SystemPower;

import java.util.List;
import java.util.Map;

/**
 * 系统权限
 */
public interface ModelPowerDao {
   /**
    * 查询系统权限列表
    * @param modelPower
    * @return
    */
   List<ModelPower> queryPageList(ModelPower modelPower);

   /**
    * 添加系统权限
    * @param modelPower
    * @return
    */
   int insert(ModelPower modelPower);

   int deleteById(Long id);
   /**
    * 查询模块名称
    */
   List<String> getModelName();

   /**
    * 新增权限
    * @param systemPower
    * @return
    */
   int insertSystemPower(SystemPower systemPower);

   /**
    * 新增menu
    * @param systemMenu
    * @return
    */
   int insertSystemMenu(SystemMenu systemMenu);

   /**
    * 查询模块对象
    * @param modelName
    * @return
    */
   SystemModel querySystemModelbyName(String modelName);

   /**
    * 逻辑删除权限（批量）
    * @param longs
    */
   void  deletePower(Long[] longs);

   /**
    *逻辑删除menu（批量）
    * @param longs
    */
    void  deleteMenu(Long[] longs);

   /**
    * 逻辑删除权限
    * @param id
    */
    void deletePowerOne(Long id);

   /**
    * 逻辑删除menu
    * @param id
    */
    void deleteMenuOne(Long id);

}
