package cn.com.bgy.ifc.domain.interfaces.system;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.project.Project;
import cn.com.bgy.ifc.entity.po.project.RegionInfo;
import cn.com.bgy.ifc.entity.po.system.UserGroupItems;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.system.BgyUserPermissionVo;

import java.util.List;
import java.util.Map;

public interface UserGroupItemsDomain extends BaseDomain<UserGroupItems> {

    /**
     * 集成平台全量增加用户权限
     * @param list
     * @return
     */
    ResponseVO<Object> saveBgyPermissionList(List<BgyUserPermissionVo> list, Long orgId);

    /**
     * 集成平台增量增加用户权限
     *
     * @param list
     * @param orgId
     * @return
     */
    ResponseVO<Object> alterBgyPermissionList(List<BgyUserPermissionVo> list, Long orgId);
    /**
     * @description:通过groupId获取区域
     * @param:
     * @return:
     * @auther: chenlie
     * @date: 2019/1/10 9:18
     */
    List<RegionInfo> findRegionInfoByGroupId(Long id);
    /**
     * @description:通过groupId获取项目
     * @param:
     * @return:
     * @auther: chenlie
     * @date: 2019/1/10 9:18
     */
    List<Project> findProjectInfoByGroupId(Long id);
}