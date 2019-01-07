package cn.com.bgy.ifc.domain.impl.system;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.utils.TimeUtil;
import cn.com.bgy.ifc.dao.system.SystemOrganizationDao;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.domain.interfaces.system.SystemOrganizationDomain;
import cn.com.bgy.ifc.entity.po.system.SystemOrganization;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.project.BgyOrgVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SystemOrganizationDomainImpl implements SystemOrganizationDomain {
    private static Logger logger = LoggerFactory.getLogger(SystemOrganizationDomainImpl.class);

    @Resource
    private SystemOrganizationDao systemOrganizationDao;

    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;

    /**
     * @author: ZhangCheng
     * @description:同步机构全量
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @Override
    public ResponseVO<Object> saveBgyOrgList(List<BgyOrgVo> list, Long orgId) {
        try {
            List<SystemOrganization> orgList = new ArrayList<>();
            Date createTime = new Date();
            for (BgyOrgVo bgyOrgVo : list) {
                SystemOrganization sysOrg = new SystemOrganization();
                sysOrg.setId(bgyOrgVo.getId());
                sysOrg.setCode(bgyOrgVo.getCode());
                sysOrg.setName(bgyOrgVo.getName());
                sysOrg.setDescription(bgyOrgVo.getDescription());
                sysOrg.setFaxNum(bgyOrgVo.getFaxNum());
                sysOrg.setLegalPerson(bgyOrgVo.getLegalPerson());
                sysOrg.setNature(bgyOrgVo.getNature());
                sysOrg.setFixedTelephone(bgyOrgVo.getFixedTelephone());
                if (bgyOrgVo.getRegisterTime() != null) {
                    sysOrg.setRegisterTime(TimeUtil.parseStrToDateTime(bgyOrgVo.getRegisterTime()));
                }
                sysOrg.setTelephone(bgyOrgVo.getTelephone());
                sysOrg.setEmail(bgyOrgVo.getEmail());
                sysOrg.setHomePage(bgyOrgVo.getHomePage());
                sysOrg.setScale(bgyOrgVo.getScale());
                sysOrg.setRegisterAddress(bgyOrgVo.getRegisterAddress());
                sysOrg.setState(bgyOrgVo.getStatus());
                sysOrg.setCreateTime(createTime);
                sysOrg.setLogicRemove(false);
                orgList.add(sysOrg);
            }
            int totalCount = DbUtil.insertByList("system_organization", orgList);
            if (totalCount != orgList.size()) {
                return ResponseVO.error().setMsg("同步集成平台机构异常");
            } else {
                externalInterfaceMsgDomain.successInterfaceMsg(orgId, ExternalConstant.MsgTypeValue.BGY_ORG_OBTAIN.getValue(), totalCount);
                return ResponseVO.success().setMsg("同步集成平台机构总条数：" + totalCount + "，新增条数：" + totalCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
            }
        } catch (Exception e) {
            logger.error("同步集成平台机构doMain异常:" + e);
            return ResponseVO.error().setMsg("同步集成平台机构异常");
        }
    }

    /**
     * @author: ZhangCheng
     * @description:同步机构增量
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @Transactional(rollbackFor = {RuntimeException.class})
    @Override
    public ResponseVO<Object> alterBgyOrgList(List<BgyOrgVo> list, Long orgId) {
        int addType = ExternalConstant.OperationType.ADD.getValue();
        int updateType = ExternalConstant.OperationType.UPDATE.getValue();
        int deleteType = ExternalConstant.OperationType.DELETE.getValue();
        int totalCount = list.size();
        int addCount = 0;
        int updateCount = 0;
        int deleteCount = 0;
        Date createTime = new Date();
        for (BgyOrgVo bgyOrgVo : list) {
            SystemOrganization sysOrg = new SystemOrganization();
            sysOrg.setId(bgyOrgVo.getId());
            sysOrg.setCode(bgyOrgVo.getCode());
            sysOrg.setName(bgyOrgVo.getName());
            sysOrg.setDescription(bgyOrgVo.getDescription());
            sysOrg.setFaxNum(bgyOrgVo.getFaxNum());
            sysOrg.setLegalPerson(bgyOrgVo.getLegalPerson());
            sysOrg.setNature(bgyOrgVo.getNature());
            sysOrg.setFixedTelephone(bgyOrgVo.getFixedTelephone());
            if (bgyOrgVo.getRegisterTime() != null) {
                sysOrg.setRegisterTime(TimeUtil.parseStrToDateTime(bgyOrgVo.getRegisterTime()));
            }
            sysOrg.setTelephone(bgyOrgVo.getTelephone());
            sysOrg.setEmail(bgyOrgVo.getEmail());
            sysOrg.setHomePage(bgyOrgVo.getHomePage());
            sysOrg.setScale(bgyOrgVo.getScale());
            sysOrg.setRegisterAddress(bgyOrgVo.getRegisterAddress());
            sysOrg.setState(bgyOrgVo.getStatus());
            sysOrg.setCreateTime(createTime);
            sysOrg.setLogicRemove(false);
            int operType = bgyOrgVo.getOperType();
            //新增
            if (operType == addType) {
                int count = systemOrganizationDao.insertSelective(sysOrg);
                if (count == 1) {
                    addCount++;
                }
            }
            //修改
            if (operType == updateType) {
                int count = systemOrganizationDao.updateSelective(sysOrg);
                if (count == 1) {
                    updateCount++;
                }
            }
            //删除
            if (operType == deleteType) {
                sysOrg.setLogicRemove(true);
                int count = systemOrganizationDao.updateSelective(sysOrg);
                if (count == 1) {
                    deleteCount++;
                }
            }
        }
        if (addCount + updateCount + deleteCount != totalCount) {
            throw new RuntimeException("批量同步机构增量数据失败!");
        } else {
            int msgType = ExternalConstant.MsgTypeValue.BGY_ORG_OBTAIN.getValue();
            externalInterfaceMsgDomain.alterInterfaceMsg(orgId, msgType, totalCount, addCount, updateCount, deleteCount);
            return ResponseVO.success().setMsg("同步集成平台机构总条数：" + totalCount + "，新增条数：" + addCount + ",修改条数：" + updateCount + ",删除条数：" + deleteCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
        }
    }

    @Override
    public SystemOrganization querySystemOrganizationByUserId(Long userId) {
        return systemOrganizationDao.querySystemOrganizationByUserId(userId);
    }
}
