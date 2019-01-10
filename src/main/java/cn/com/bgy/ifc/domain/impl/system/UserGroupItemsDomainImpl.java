package cn.com.bgy.ifc.domain.impl.system;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.utils.DbUtil;
import cn.com.bgy.ifc.dao.system.AccountDao;
import cn.com.bgy.ifc.dao.system.UserGroupItemsDao;
import cn.com.bgy.ifc.domain.impl.equipment.EquipmentTypeDomainImpl;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.domain.interfaces.system.UserGroupItemsDomain;
import cn.com.bgy.ifc.entity.po.project.Project;
import cn.com.bgy.ifc.entity.po.project.RegionInfo;
import cn.com.bgy.ifc.entity.po.system.UserGroupItems;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.system.BgyPermissionVo;
import cn.com.bgy.ifc.entity.vo.system.BgyUserPermissionVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserGroupItemsDomainImpl implements UserGroupItemsDomain {
    private static Logger logger = LoggerFactory.getLogger(UserGroupItemsDomainImpl.class);

    @Resource
    private UserGroupItemsDao userGroupItemsDao;

    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;

    @Override
    public List<UserGroupItems> queryListByParam(UserGroupItems t) {
        return userGroupItemsDao.queryListByParam(t);
    }

    @Override
    public List<UserGroupItems> queryListByMap(Map<String, Object> map) {
        return userGroupItemsDao.queryListByMap(map);
    }

    @Override
    public UserGroupItems findById(Long id) {
        return userGroupItemsDao.findById(id);
    }

    @Override
    public int insert(UserGroupItems t) {
        return userGroupItemsDao.insert(t);
    }

    @Override
    public int insertSelective(UserGroupItems t) {
        return userGroupItemsDao.insertSelective(t);
    }

    @Override
    public int update(UserGroupItems t) {
        return userGroupItemsDao.update(t);
    }

    @Override
    public int updateSelective(UserGroupItems t) {
        return userGroupItemsDao.updateSelective(t);
    }


    @Override
    public int deleteBatch(List<Long> ids) {
        return userGroupItemsDao.deleteBatch(ids);
    }

    @Override
    public ResponseVO<Object> saveBgyPermissionList(List<BgyUserPermissionVo> list, Long orgId) {
        try {
            List<UserGroupItems> groupList = new ArrayList<>();
            for (BgyUserPermissionVo bgyUserPermissionVo : list) {
                List<BgyPermissionVo> permission = bgyUserPermissionVo.getPermission();
                UserGroupItems group = new UserGroupItems();
                group.setUserId(bgyUserPermissionVo.getId());
                int voSize = permission.size();
                int count=0;
                if (voSize > 0) {
                    for (int i = 0; i < voSize; i++) {
                        int type = permission.get(i).getType();
                        //区域
                        if (type == 2) {
                            group.setRegionId(permission.get(i).getBdId());
                            count++;
                        }
                        //项目
                        if (type == 3) {
                            group.setProjectId(permission.get(i).getBdId());
                            count++;
                        }
                    }
                }
                if(count>0){
                    groupList.add(group);
                }
            }
           int groupSize = groupList.size();
            if (groupSize > 0) {
                int sumCount = DbUtil.insertByList("user_group_items", groupList);
                if (sumCount != groupList.size()) {
                    return ResponseVO.error().setMsg("同步集成平台用户权限异常");
                } else {
                    externalInterfaceMsgDomain.successInterfaceMsg(orgId, ExternalConstant.MsgTypeValue.BGY_PERMISSION_OBTAIN.getValue(), sumCount);
                    return ResponseVO.success().setMsg("同步集成平台用户总条数：" + sumCount + "，新增条数：" + sumCount + ",成功条数：" + sumCount + "，失败条数" + 0 + "");
                }
            } else {
                return ResponseVO.error().setMsg("暂无集成平台用户权限数据同步");
            }
        } catch (Exception e) {
            logger.error("同步集成平台用户权限doMain异常:",e);
            return ResponseVO.error().setMsg("同步集成平台用户权限异常");
        }
    }

    @Transactional(rollbackFor = {RuntimeException.class})
    @Override
    public ResponseVO<Object> alterBgyPermissionList(List<BgyUserPermissionVo> list, Long orgId) {
            int addType = ExternalConstant.OperationType.ADD.getValue();
            int updateType = ExternalConstant.OperationType.UPDATE.getValue();
            int deleteType = ExternalConstant.OperationType.DELETE.getValue();
            int addCount = 0;
            int updateCount = 0;
            int deleteCount = 0;
            int totalCount = list.size();
            for (BgyUserPermissionVo bgyUserPermissionVo : list) {
                List<BgyPermissionVo> permission = bgyUserPermissionVo.getPermission();
                Long userId = bgyUserPermissionVo.getId();
                UserGroupItems myItems = userGroupItemsDao.findByUserId(userId);
                UserGroupItems group = new UserGroupItems();
                group.setUserId(userId);
                int voSize = permission.size();
                int typeCount = 0;
                if (voSize > 0) {
                    for (int i = 0; i < voSize; i++) {
                        int type = permission.get(i).getType();
                        //区域
                        if (type == 2) {
                            group.setRegionId(permission.get(i).getBdId());
                            typeCount++;
                        }
                        //项目
                        if (type == 3) {
                            group.setProjectId(permission.get(i).getBdId());
                            typeCount++;
                        }
                    }
                }
                if (typeCount == 0) {
                    if (myItems == null) {
                        deleteCount++;
                    } else {
                        int count = userGroupItemsDao.deleteById(myItems.getId());
                        if (count == 1) {
                            deleteCount++;
                        }
                    }
                    continue;
                }
                int operType = bgyUserPermissionVo.getOperType();
                //新增
                if (operType == addType) {
                    if (myItems == null) {
                        int count = userGroupItemsDao.insertSelective(group);
                        if (count == 1) {
                            addCount++;
                        }
                    } else {
                        group.setId(myItems.getId());
                        int count = userGroupItemsDao.updateSelective(group);
                        if (count == 1) {
                            addCount++;
                        }
                    }

                }
                //修改
                if (operType == updateType) {
                    if (myItems == null) {
                        int count = userGroupItemsDao.insertSelective(group);
                        if (count == 1) {
                            updateCount++;
                        }
                    } else {
                        group.setId(myItems.getId());
                        int count = userGroupItemsDao.updateSelective(group);
                        if (count == 1) {
                            updateCount++;
                        }
                    }
                }
                //删除
                if (operType == deleteType) {
                    int count = userGroupItemsDao.deleteById(myItems.getId());
                    if (count == 1) {
                        deleteCount++;
                    }
                }
            }
            if (addCount + updateCount + deleteCount != totalCount) {
                throw new RuntimeException("批量同步用户权限增量数据失败!");
            } else {
                int msgType = ExternalConstant.MsgTypeValue.BGY_PERMISSION_OBTAIN.getValue();
                externalInterfaceMsgDomain.alterInterfaceMsg(orgId, msgType, totalCount, addCount, updateCount, deleteCount);
                return ResponseVO.success().setMsg("同步集成平台用户总条数：" + totalCount + "，新增条数：" + addCount + ",修改条数：" + updateCount + ",删除条数：" + deleteCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
            }
    }

    @Override
    public List<RegionInfo> findRegionInfoByGroupId(Long id) {
        return userGroupItemsDao.findRegionInfoByGroupId(id);
    }

    @Override
    public List<Project> findProjectInfoByGroupId(Long id) {
        return userGroupItemsDao.findProjectInfoByGroupId(id);
    }

}