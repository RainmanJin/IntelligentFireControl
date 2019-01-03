package cn.com.bgy.ifc.domain.interfaces.system;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.system.BgyUserVo;
import cn.com.bgy.ifc.entity.vo.system.AccountVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface AccountDomain extends BaseDomain<Account> {
    /**
     * 保存用户
     *
     * @param account
     * @return
     */
    int save(Account account);

    /**
     * 条件查找用户
     *
     * @param account
     * @return
     */
    List<Account> searchByWhere(Account account);

    /**
     * 分页查询用户
     *
     * @param page
     * @param account
     * @return
     */
    PageInfo<Account> searchByPage(Page page, Account account);

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 根据id查找用户
     *
     * @param id
     * @return
     */
    Account findById(Long id);

    /**
     * 根据id更新用户
     *
     * @param account
     * @return
     */
    int update(Account account);

    /**
     * 根据电话称查询用户对象
     *
     * @param telephone
     * @return
     */
    Account findAccountByUserName(String telephone);

    /**
     * 根据用户名查询用户
     *
     * @param page
     * @param account
     * @return
     */
    public PageInfo<Account> findUserPowerByPage(Page<Account> page, Account account);


    /**
     * 集成平台全量增加用户信息
     *
     * @param list
     * @return
     */
    ResponseVO<Object> saveBgyAccountList(List<BgyUserVo> list, Long orgId);

    /**
     * 集成平台增量增加用户信息
     *
     * @param list
     * @param orgId
     * @return
     */
    ResponseVO<Object> alterBgyAccountList(List<BgyUserVo> list, Long orgId);

    int updateIsDisable(List<Long> idslist, int isDisable);

    int initalingPassword(Account account);

    /**
     * 根据角色信息查询用户信息
     * @param map
     * @return
     */
    List<Account> queryListByRole(Map<String, Object> map);

}
