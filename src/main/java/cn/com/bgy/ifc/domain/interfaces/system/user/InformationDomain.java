package cn.com.bgy.ifc.domain.interfaces.system.user;

import cn.com.bgy.ifc.entity.po.system.basic.Information;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface InformationDomain {
    Information findById(Long id);

    int insert(Information information);

    int deleteById(Long id);
    /**
     * 逻辑删除通知公告（批量）
     * @param longs
     */
    void  deleteInformation(Long[] longs);

    int update(Information information);
    /**
     * 分页
     * @param information
     * @return
     */
    PageInfo<Information> searchByPage(Page page, Information information);
}