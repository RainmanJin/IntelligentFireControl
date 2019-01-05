package cn.com.bgy.ifc.dao.system;

import cn.com.bgy.ifc.entity.po.system.InterfaceAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InterfaceAccountDao {
    InterfaceAccount findById(Long id);

    int insert(InterfaceAccount interfaceaccount);

    int deleteById(Long id);
    /**
     * 逻辑删除用户接口（批量）
     * @param list
     */
    void  deleteInterfaceAccount(@Param("list")List<Long> list);

    int update(InterfaceAccount interfaceAccount);

    /**
     * 分页
     * @param interfaceAccount
     * @return
     */
    List<InterfaceAccount> searchByWhere(InterfaceAccount interfaceAccount);
}