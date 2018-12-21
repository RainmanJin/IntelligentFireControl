package cn.com.bgy.ifc.domain.impl.system.project;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.utils.DBUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.dao.system.project.*;
import cn.com.bgy.ifc.domain.interfaces.system.basic.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.domain.interfaces.system.project.RegionProjectDomain;
import cn.com.bgy.ifc.entity.po.system.project.RegionProject;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.projects.BgyProjectVo;
import cn.com.bgy.ifc.entity.vo.system.project.RegionProjectVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/18 17:18
 * @Description
 **/
@Service
public class RegionProjectDomainImpl implements RegionProjectDomain {
    private static Logger logger = LoggerFactory.getLogger(RegionProjectDomainImpl.class);

    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;

    @Resource
    private RegionProjectDao regionProjectDao;

    @Resource
    private RegionCourtDao regionCourtDao;

    @Resource
    private RegionStreetDao regionStreetDao;

    @Resource
    private RegionBuildingDao regionBuildingDao;

    @Resource
    private RegionComputerRoomDao regionComputerRoomDao;

    /**
     * @Author huxin
     * @Description 查
     * @Date 2018/12/18 17:31
     */
    @Override
    public PageInfo<RegionProjectVo> queryListRegionProjec(Page<RegionProjectVo> page, RegionProjectVo record) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<RegionProjectVo> list = regionProjectDao.queryListRegionProject(record);
        return new PageInfo<RegionProjectVo>(list);
    }

    /**
     * @Author huxin
     * @Description 增加
     * @Date 2018/12/18 17:31
     */
    @Override
    public int insert(RegionProject record) {
        record.setCreateTime(new Date());
        record.setLogicRemove(false);
        return regionProjectDao.insert(record);
    }

    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/18 17:31
     */
    @Transactional
    @Override
    public int updateRegionProjec(RegionProject record) {
        record.setCreateTime(new Date());
        return regionProjectDao.updateRegionProject(record);
    }

    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/18 17:31
     */
    @Transactional
    @Override
    public int deleteRegionProjec(String str) {
        List<Long> list = ListUtil.getListId(str);

        if(list.size()>0){
            //删除机房
            regionComputerRoomDao.deleteRegionComputerRoomBySuperId(list);
            //删除楼栋
            regionBuildingDao.deleteRegionBuildingBySuperId(list);
            //删除街道
            regionStreetDao.deleteRegionStreetBySuperId(list);
            //删除苑区
            regionCourtDao.deleteRegionCourtBySuperId(list);
            //删除项目
            return regionProjectDao.deleteRegionProject(list);
        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 根据父级id查询所有项目名
     * @Date 2018/12/20 18:26
     */
    @Override
    public List<Map<String, Object>> queryRegionProjectNameBySuperId(Long id) {
         return regionProjectDao.queryRegionProjectNameBySuperId(id);
    }

    /**
     * @author: ZhangCheng
     * @description:
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @Override
    public ResponseVO<Object> saveBgyRegionProject(List<BgyProjectVo> list, Long orgId) {
        try {
            List<RegionProject> infoList = new ArrayList<>();
            Date createTime = new Date();
            for (BgyProjectVo bgyProjectVo : list) {
                RegionProject project = new RegionProject();
                project.setId(bgyProjectVo.getId());
                project.setOrganizationId(orgId);
                project.setRegionId(bgyProjectVo.getAreaId());
                project.setCode(bgyProjectVo.getCode());
                project.setName(bgyProjectVo.getName());
                String locationStr=bgyProjectVo.getLocationStr();
                if(locationStr.contains(",")){
                    project.setLongitude(locationStr.substring(0,locationStr.indexOf(",")));
                    project.setLatitude(locationStr.substring(locationStr.indexOf(",")+1,locationStr.length()));
                }
               // project.setAscription(bgyProjectVo.get);
                project.setCreateTime(createTime);
                project.setLogicRemove(false);
                infoList.add(project);
            }
            int totalCount = DBUtil.insertByList("region_project", infoList);
            if (totalCount != infoList.size()) {
                return ResponseVO.error().setMsg("同步集成平台项目异常");
            } else {
                externalInterfaceMsgDomain.successInterfaceMsg(orgId, ExternalConstant.MsgTypeValue.BGY_PROJECT_OBTAIN.getValue(), totalCount);
                return ResponseVO.success().setMsg("同步集成平台项目总条数：" + totalCount + "，新增条数：" + totalCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
            }
        } catch (Exception e) {
            logger.error("同步集成平台项目doMain异常:" + e);
            return ResponseVO.error().setMsg("同步集成平台项目异常");
        }
    }

    /**
     * @author: ZhangCheng
     * @description:同步项目全量
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @Override
    public ResponseVO<Object> alterBgyRegionProject(List<BgyProjectVo> list, Long orgId) {
        int addType = ExternalConstant.OperationType.ADD.getValue();
        int updateType = ExternalConstant.OperationType.UPDATE.getValue();
        int deleteType = ExternalConstant.OperationType.DELETE.getValue();
        int totalCount = list.size();
        int addCount = 0;
        int updateCount = 0;
        int deleteCount = 0;
        Date createTime = new Date();
        return null;
    }


}
