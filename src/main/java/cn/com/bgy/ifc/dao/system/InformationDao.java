package cn.com.bgy.ifc.dao.system;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.system.Information;

import java.util.List;

public interface InformationDao extends BaseDao<Information> {
    /**
     * 逻辑删除通知公告（批量）
     * @param list
     */
    void  deleteInformation(List<Long> list);

    List<Information> searchByWhere(Information information);
}