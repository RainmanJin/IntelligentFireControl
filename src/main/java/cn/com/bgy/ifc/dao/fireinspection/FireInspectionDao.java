package cn.com.bgy.ifc.dao.fireinspection;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.fireinspection.FireInspection;
/**
 * 消防巡检
 * @author lvbingjian
 *2018年12月29日11:25:29
 */
public interface FireInspectionDao extends BaseDao<FireInspection>{
    int insert(FireInspection record);

    int insertSelective(FireInspection record);
}