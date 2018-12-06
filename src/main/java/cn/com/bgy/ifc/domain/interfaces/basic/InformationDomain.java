package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.Information;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface InformationDomain {
    Information findById(Long id);

    int insert(Information information);

    int deleteById(Long id);

    int update(Information information);
    /**
     * 分页
     * @param information
     * @return
     */
    PageInfo<Information> searchByPage(Page page, Information information);
}
