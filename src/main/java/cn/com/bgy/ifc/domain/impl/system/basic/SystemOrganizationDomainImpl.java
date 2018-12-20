package cn.com.bgy.ifc.domain.impl.system.basic;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.bgy.utils.DBUtil;
import cn.com.bgy.ifc.bgy.utils.TimeUtil;
import cn.com.bgy.ifc.dao.system.basic.SystemOrganizationDao;
import cn.com.bgy.ifc.domain.interfaces.system.basic.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.domain.interfaces.system.basic.SystemOrganizationDomain;
import cn.com.bgy.ifc.entity.po.system.basic.SystemOrganization;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.projects.BgyOrgVo;
import cn.com.bgy.ifc.service.impl.api.basic.BgyOrgServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public SystemOrganization findById(Long id) {
        return systemOrganizationDao.findById(id);
    }

    @Override
    public int insert(SystemOrganization systemOrganization) {
        return systemOrganizationDao.insert(systemOrganization);
    }

    @Override
    public int deleteById(Long id) {
        return systemOrganizationDao.deleteById(id);
    }

    @Override
    public void deleteInterSystemOrganization(Long[] longs) {
        systemOrganizationDao.deleteInterSystemOrganization(longs);
    }

    @Override
    public int update(SystemOrganization systemOrganization) {
        return systemOrganizationDao.update(systemOrganization);
    }

    /**
     * 分页查询
     *
     * @param page
     * @param systemOrganization
     * @return
     */
    @Override
    public PageInfo<SystemOrganization> searchByWhere(Page page, SystemOrganization systemOrganization) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<SystemOrganization> systemOrganizationtList = systemOrganizationDao.searchByWhere(systemOrganization);
        PageInfo<SystemOrganization> pageInfo = new PageInfo<>(systemOrganizationtList);
        return pageInfo;
    }

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
                if(bgyOrgVo.getRegisterTime()!=null){
                    sysOrg.setRegisterTime(TimeUtil.parseStrToDate(bgyOrgVo.getRegisterTime()));
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
            int totalCount = DBUtil.insertByList("system_organization", orgList);
            if (totalCount != orgList.size()) {
                return ResponseVO.error().setMsg("同步集成平台机构异常");
            } else {
                externalInterfaceMsgDomain.successInterfaceMsg(orgId, ExternalConstant.MsgTypeValue.BGY_ORG_OBTAIN.getValue(), totalCount);
                return ResponseVO.success().setMsg("同步集成平台机构总条数：" + totalCount + "，新增条数：" + totalCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
            }
        } catch (Exception e) {
            logger.error("同步集成平台机构doMain异常:"+e);
            return ResponseVO.error().setMsg("同步集成平台机构异常");
        }
    }

    @Override
    public ResponseVO<Object> alterBgyOrgList(List<BgyOrgVo> list, Long orgId) {
        int addType = ExternalConstant.OperationType.ADD.getValue();
        int updateType = ExternalConstant.OperationType.UPDATE.getValue();
        int deleteType = ExternalConstant.OperationType.DELETE.getValue();
        int isDelete = SystemConstant.EnableState.DELETE.getValue();
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
            sysOrg.setRegisterTime(TimeUtil.parseStrToDate(bgyOrgVo.getRegisterTime()));
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
}