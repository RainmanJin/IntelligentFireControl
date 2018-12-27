package cn.com.bgy.ifc.dao.system;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.system.AccountVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountDao extends BaseDao {
    /**
     * 条件查询用户
     * @param account
     * @return
     */
    List<Account> searchByWhere(Account account);

    /**
     * 根据Id删除用户
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 根据Id查找用户
     * @param id
     * @return
     */
    Account findById(Long id);

    /**
     * 根据id更新用户
     * @param account
     * @return
     */
    int updateById(Account account);

    /**
     * 更新用户
     * @param account
     * @return
     */
    int updateSelective(Account account);

    /**
     *
     * @param telephone
     * @return
     */
    Account findAccountByUserName(String telephone);

    /**
     * 分页查询用户权限
     * @param account
     * @return
     */
    List<Account> findUserPowerByPage(Account account);

    int updateIsDisable(@Param("list") List<Long> idslist,@Param("isDisable") int isDisable);

    int initalingPassword(Account account);
}