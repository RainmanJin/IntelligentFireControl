package cn.com.bgy.ifc.domain.impl.project;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.dao.project.*;
import cn.com.bgy.ifc.dao.system.UserGroupItemsDao;
import cn.com.bgy.ifc.domain.interfaces.project.RegionInfoDomain;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.entity.po.project.RegionInfo;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.project.BgyRegionInfoVo;
import cn.com.bgy.ifc.entity.vo.project.RegionInfoVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author huxin
 * @Description 区域信息
 * @Date 2018/12/18 15:19
 */
@Service
public class RegionInfoDomainImpl implements RegionInfoDomain {

    private static Logger logger = LoggerFactory.getLogger(RegionInfoDomainImpl.class);

    @Resource
    private RegionInfoDao regionInfoDao;

    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;

    @Resource
    private UserGroupItemsDao userGroupItemsDao;

    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/18 16:26
     */
    @Override
    public PageInfo queryListRegionInfo(Page page, String keyword,Account user) {
        List<Long>  regionList = userGroupItemsDao.queryRegionIdByUserId(user.getId());

        Map<String,Object> map = new HashMap<>();
        map.put("keyword",keyword);
        if(regionList.size()>0){
            map.put("regionList",regionList);
        }else{
            map.put("regionList",null);
        }
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<Map<String,Object>> list = regionInfoDao.queryListRegionInfo(map);
        return new PageInfo(list);
    }

    /**
     * @Author huxin
     * @Description 添加
     * @Date 2018/12/18 16:26
     */
    @Override
    public int insert(RegionInfo record) {
        record.setCreateTime(new Date());
        record.setLogicRemove(false);
        return regionInfoDao.insert(record);
    }

    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/18 16:26
     */
    @Override
    public int updateRegionInfo(RegionInfoVo record) {
        record.setCreateTime(new Date());
        return regionInfoDao.updateRegionInfo(record);
    }

    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/18 16:26
     */
    @Override
    public int deleteRegionInfo( String ids) {
        if(ids.length()>0){
            List<Long> list = ListUtil.getListId(ids);
            if(list.size()>0){
                return regionInfoDao.deleteRegionInfo(list);
            }
            return 0;
        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 查询所有区域
     * @Date 2018/12/21 9:22
     */
    @Override
    public List<Map<String, Object>> queryRegionInfoName(Account user) {
        List<Long>  regionList = userGroupItemsDao.queryRegionIdByUserId(user.getId());
        return regionInfoDao.queryRegionInfoName();
    }

    /**
     * @author: ZhangCheng
     * @description:通过机构ID获取区域信息
     * @param: [orgId]
     * @return: java.util.List<cn.com.bgy.ifc.entity.po.system.project.RegionInfo>
     */
    @Override
    public List<RegionInfo> findByOrgId(Long orgId) {
        return regionInfoDao.findByOrgId(orgId);
    }

    /**
     * @author: ZhangCheng
     * @description:同步区域全量
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @Override
    public ResponseVO<Object> saveBgyRegionInfo(List<BgyRegionInfoVo> list, Long orgId) {
        try {
            List<RegionInfo> infoList = new ArrayList<>();
            Date createTime = new Date();
            for (BgyRegionInfoVo bgyRegionInfoVo : list) {
                RegionInfo info = new RegionInfo();
                info.setId(bgyRegionInfoVo.getId());
                info.setOrganizationId(orgId);
                info.setCode(bgyRegionInfoVo.getCode());
                info.setName(bgyRegionInfoVo.getName());
                info.setCreateTime(createTime);
                info.setLogicRemove(false);
                infoList.add(info);
            }
            int totalCount = DbUtil.insertByList("region_info", infoList);
            if (totalCount != infoList.size()) {
                return ResponseVO.error().setMsg("同步集成平台区域异常");
            } else {
                externalInterfaceMsgDomain.successInterfaceMsg(orgId, ExternalConstant.MsgTypeValue.BGY_REGION_OBTAIN.getValue(), totalCount);
                return ResponseVO.success().setMsg("同步集成平台区域总条数：" + totalCount + "，新增条数：" + totalCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
            }
        } catch (Exception e) {
            logger.error("同步集成平台区域doMain异常:" + e);
            return ResponseVO.error().setMsg("同步集成平台区域异常");
        }
    }

    /**
     * @author: ZhangCheng
     * @description:同步区域增量
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @Transactional(rollbackFor = {RuntimeException.class})
    @Override
    public ResponseVO<Object> alterBgyRegionInfo(List<BgyRegionInfoVo> list, Long orgId) {
        int addType = ExternalConstant.OperationType.ADD.getValue();
        int updateType = ExternalConstant.OperationType.UPDATE.getValue();
        int deleteType = ExternalConstant.OperationType.DELETE.getValue();
        int totalCount = list.size();
        int addCount = 0;
        int updateCount = 0;
        int deleteCount = 0;
        Date createTime = new Date();
        for (BgyRegionInfoVo bgyRegionInfoVo : list) {
            RegionInfo info = new RegionInfo();
            info.setId(bgyRegionInfoVo.getId());
            info.setOrganizationId(orgId);
            info.setCode(bgyRegionInfoVo.getCode());
            info.setName(bgyRegionInfoVo.getName());
            info.setCreateTime(createTime);
            info.setLogicRemove(false);
            int operType = bgyRegionInfoVo.getOperType();
            //新增
            if (operType == addType) {
                int count = regionInfoDao.insertSelective(info);
                if (count == 1) {
                    addCount++;
                }
            }
            //修改
            if (operType == updateType) {
                int count = regionInfoDao.updateSelective(info);
                if (count == 1) {
                    updateCount++;
                }
            }
            //删除
            if (operType == deleteType) {
                info.setLogicRemove(true);
                int count = regionInfoDao.updateSelective(info);
                if (count == 1) {
                    deleteCount++;
                }
            }
        }
        if (addCount + updateCount + deleteCount != totalCount) {
            throw new RuntimeException("批量同步区域增量数据失败!");
        } else {
            int msgType = ExternalConstant.MsgTypeValue.BGY_REGION_OBTAIN.getValue();
            externalInterfaceMsgDomain.alterInterfaceMsg(orgId, msgType, totalCount, addCount, updateCount, deleteCount);
            return ResponseVO.success().setMsg("同步集成平台区域增量总条数：" + totalCount + "，新增条数：" + addCount + ",修改条数：" + updateCount + ",删除条数：" + deleteCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
        }
    }

    @Override
    public Map<String, Object> findById( Long id ) {
        if(id != null || id>0){
            return (Map<String, Object>) regionInfoDao.findById(id);
        }
        return null;
    }
}
