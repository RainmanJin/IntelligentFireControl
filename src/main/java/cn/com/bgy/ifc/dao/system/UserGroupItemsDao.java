package cn.com.bgy.ifc.dao.system;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.project.Project;
import cn.com.bgy.ifc.entity.po.project.RegionInfo;
import cn.com.bgy.ifc.entity.po.system.UserGroupItems;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserGroupItemsDao extends BaseDao<UserGroupItems> {

    UserGroupItems findByUserId(Long userId);

    //根据用户ID查询返回区域ID
    List<Long> queryRegionIdByUserId(Long userId);

    //根据用户ID查询返回项目ID
    List<Long> queryProjectIdByUserId(Long userId);

    /**
     * @description:根据分组id删除
     * @param: groupId
     * @return: int
     * @auther: chenlie
     * @date: 2019/1/8 16:52
     */
    int deleteByGroupId(Long groupId);
    /**
     * @description:通过groupId获取区域
     * @param:
     * @return:
     * @auther: chenlie
     * @date: 2019/1/10 9:21
     */
    List<RegionInfo> findRegionInfoByGroupId(Long id);
    /**
     * @description:通过groupId获取项目
     * @param:
     * @return:
     * @auther: chenlie
     * @date: 2019/1/10 9:21
     */
    List<Project> findProjectInfoByGroupId(Long id);

    /**
     * @description:删除分组下所有用户数据
     * @param:
     * @return:
     * @auther: chenlie
     * @date: 2019/1/10 10:38
     */
    int deleteByGroupIdAndUserId(@Param("groupId") Long groupId, @Param("list") List<Long> list);
}