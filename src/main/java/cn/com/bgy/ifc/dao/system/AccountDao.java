package cn.com.bgy.ifc.dao.system;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.system.AccountVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AccountDao extends BaseDao<Account> {
    /**
     * 条件查询用户
     * @param account
     * @return
     */
    List<Account> searchByWhere(Account account);

    /**
     *
     * @param thirdUserId
     * @return
     */
    Account findByThirdId(Long thirdUserId);

    /**
     *
     * @param organizationId
     * @return
     */
    List<Account> queryThirdList(Long organizationId);

    /**
     * 根据id更新用户
     * @param account
     * @return
     */
    int updateById(Account account);

    /**
     * 根据第三方ID更新数据
     * @param account
     * @return
     */
    int updateByThirdId(Account account);

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

    /**
     * 根据角色信息查询用户信息
     * @param map
     * @return
     */
    List<Account> queryListByRole(Map<String, Object> map);
}