package cn.com.bgy.ifc.dao.system;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.system.UserGroup;

import java.util.List;
import java.util.Map;

public interface UserGroupDao extends BaseDao<UserGroup> {

    /**
     * 参数查询返回map数据集
     * @param t
     * @return
     */
    List<Map<String,Object>> queryListMapByParam(UserGroup t);
    /**
     * @description:根据分组id删除
     * @param: groupId
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/8 16:52
     */
    int deleteByGroupId(Long groupId);
}