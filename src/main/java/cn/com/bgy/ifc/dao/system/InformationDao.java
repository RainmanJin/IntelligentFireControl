package cn.com.bgy.ifc.dao.system;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.system.Information;

import java.util.List;

public interface InformationDao extends BaseDao<Information> {
    Information findById(Long id);

    int insert(Information information);

    int deleteById(Long id);
    /**
     * 逻辑删除通知公告（批量）
     * @param longs
     */
    void  deleteInformation(Long[] longs);

    int update(Information information);

    List<Information> searchByWhere(Information information);
}