package cn.com.bgy.ifc.domain.impl.maintenance;


import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.utils.DbUtil;
import cn.com.bgy.ifc.bgy.utils.TimeUtil;
import cn.com.bgy.ifc.dao.maintenance.MaintenanceContractDao;
import cn.com.bgy.ifc.dao.maintenance.MaintenanceContractFileDao;
import cn.com.bgy.ifc.dao.project.RegionInfoDao;
import cn.com.bgy.ifc.dao.project.RegionProjectDao;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenanceContractDomain;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceContract;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceContractFile;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.maintenance.BgyMaintenanceContractFileVo;
import cn.com.bgy.ifc.entity.vo.maintenance.BgyMaintenanceContractVo;
import cn.com.bgy.ifc.entity.vo.project.RegionProjectVo;
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
import java.util.List;
import java.util.Map;

/**
 * @Author lvbingjian
 * @Date 2018年12月19日12:02:23
 * @Description 维保合同管理（维保）
 **/
@Service
public class MaintenanceContractDomainImpl implements MaintenanceContractDomain {

    private static Logger logger = LoggerFactory.getLogger(MaintenanceContractDomainImpl.class);

    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;

    @Resource
    private MaintenanceContractDao dao;

    @Resource
    private MaintenanceContractFileDao maintenanceContractFileDao;
    /**
     * 区域dao
     */
    @Resource
    private RegionInfoDao regionInfoDao;
    /**
     * 项目
     */
    @Resource
    private RegionProjectDao regionProjectDao;

    /**
     * 分页查询
     *
     * @param page
     * @param maintenanceContract
     * @return
     */
    @Override
    public PageInfo<MaintenanceContract> queryListByPage(Page<MaintenanceContract> page, MaintenanceContract maintenanceContract) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<MaintenanceContract> maintenanceContractList = dao.queryListByParam(maintenanceContract);
        PageInfo<MaintenanceContract> pageInfo = new PageInfo<>(maintenanceContractList);
        return pageInfo;
    }

    /**
     * 列表查询
     *
     * @param record
     * @return
     */
    @Override
    public List<MaintenanceContract> queryListByParam(MaintenanceContract record) {
        return dao.queryListByParam(record);
    }

    /**
     * 添加
     *
     * @param record
     * @return
     */
    @Override
    @Transactional
    public int addMaintenanceContractInfo(MaintenanceContract record) {
        return dao.insert(record);
    }

    /**
     * 通过ID修改合同
     *
     * @param record 合同修改字段
     * @return
     */
    @Override
    @Transactional
    public int updateMaintenanceContract(MaintenanceContract record) {
        return dao.update(record);
    }

    /**
     * 同归合同ID查询合同详细信息
     *
     * @param id
     * @return
     */
    @Override
    public MaintenanceContract findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public int deleteMaintenanceContracts(String str) {
        List<Long> list = new ArrayList<>();
        String [] arr= str.split(",");
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                list.add(Long.valueOf(arr[i]));
            }
            return dao.delete(list);
        } else {
            return 0;
        }
    }

    /**
     * 查询区域下拉框列表不需要传入参数
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> getRegionList() {
        return regionInfoDao.queryRegionInfoName();
    }

    /**
     * 获取项目下拉框初始值
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> getRegionProjectList() {
        RegionProjectVo regionProjectVo = null;
        return null;
        // return regionProjectDao.queryListRegionProject(regionProjectVo);
    }

    /**
     * @author: ZhangCheng
     * @description:集成平台全量获取维保合同信息（全量）
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @Override
    public ResponseVO<Object> saveBgyMaintenanceContract(List<BgyMaintenanceContractVo> list, Long orgId) {
        try {
            List<MaintenanceContract> contractList = new ArrayList<>();
            List<MaintenanceContractFile> fileList = new ArrayList<>();
            for (BgyMaintenanceContractVo contractVo : list) {
                Long conId = contractVo.getId();
                MaintenanceContract contract = contract(contractVo,conId);
                List<BgyMaintenanceContractFileVo> fileVoList = contractVo.getFileList();
                for (BgyMaintenanceContractFileVo fileVo : fileVoList) {
                    MaintenanceContractFile file = contractFile(fileVo,conId);
                    fileList.add(file);
                }
                contractList.add(contract);
            }
            int totalCount = DbUtil.insertByList("maintenance_contract", contractList);
            int fileCount = 0;
            if (fileList.size() > 0) {
                fileCount = DbUtil.insertByList("maintenance_contract_file", fileList);
            }
            //判断合同和文件信息是否同时写入成功
            if (totalCount == contractList.size() && fileCount == fileList.size()) {
                externalInterfaceMsgDomain.successInterfaceMsg(orgId, ExternalConstant.MsgTypeValue.BGY_REPAIR_CONTRACT_OBTAIN.getValue(), totalCount);
                return ResponseVO.success().setMsg("同步集成平台维保合同总条数：" + totalCount + "，新增条数：" + totalCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
            } else {
                return ResponseVO.error().setMsg("同步集成平台维保合同异常");
            }
        } catch (Exception e) {
            logger.error("同步集成平台维保合同doMain异常:" + e);
            return ResponseVO.error().setMsg("同步集成平台维保合同异常");
        }
    }

    /**
     * @author: ZhangCheng
     * @description:集成平台增量获取维保合同信息（增量）
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @Transactional(rollbackFor = {RuntimeException.class})
    @Override
    public ResponseVO<Object> alterBgyMaintenanceContract(List<BgyMaintenanceContractVo> list, Long orgId) {
        int addType = ExternalConstant.OperationType.ADD.getValue();
        int updateType = ExternalConstant.OperationType.UPDATE.getValue();
        int deleteType = ExternalConstant.OperationType.DELETE.getValue();
        int totalCount = list.size();
        int addCount = 0;
        int updateCount = 0;
        int deleteCount = 0;
        List<MaintenanceContractFile> fileList = new ArrayList<>();
        for (BgyMaintenanceContractVo contractVo : list) {
            Long conId = contractVo.getId();
            MaintenanceContract contract = contract(contractVo,conId);
            int operType = contractVo.getOperType();
            //新增
            if (operType == addType) {
                List<BgyMaintenanceContractFileVo> fileVoList = contractVo.getFileList();
                for (BgyMaintenanceContractFileVo fileVo : fileVoList) {
                    MaintenanceContractFile file = contractFile(fileVo,conId);
                    fileList.add(file);
                }
                int count = dao.insertSelective(contract);
                if (count == 1) {
                    addCount++;
                }
            }
            //修改
            if (operType == updateType) {
                int count = dao.updateSelective(contract);
                if (count == 1) {
                    updateCount++;
                }
            }
            //删除
            if (operType == deleteType) {
                contract.setLogicRemove(true);
                int count = dao.updateSelective(contract);
                if (count == 1) {
                    deleteCount++;
                }
            }
        }
        if (addCount + updateCount + deleteCount != totalCount) {
            throw new RuntimeException("批量同步维保合同增量数据失败!");
        } else {
            int count = 0;
            if (fileList.size() > 0) {
                for (MaintenanceContractFile file : fileList) {
                    count = maintenanceContractFileDao.insertSelective(file);
                }
            }
            if (count == fileList.size()) {
                throw new RuntimeException("批量同步维保合同附件增量数据失败!");
            }
            int msgType = ExternalConstant.MsgTypeValue.BGY_REPAIR_CONTRACT_OBTAIN.getValue();
            externalInterfaceMsgDomain.alterInterfaceMsg(orgId, msgType, totalCount, addCount, updateCount, deleteCount);
            return ResponseVO.success().setMsg("同步集成平台维保合同总条数：" + totalCount + "，新增条数：" + addCount + ",修改条数：" + updateCount + ",删除条数：" + deleteCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
        }
    }

    /**
     * @author: ZhangCheng
     * @description:合同数据转换
     * @param: [contractVo]
     * @return: cn.com.bgy.ifc.entity.po.maintenance.MaintenanceContract
     */
    private MaintenanceContract contract(BgyMaintenanceContractVo contractVo,Long conId){
        MaintenanceContract contract = new MaintenanceContract();
        contract.setId(conId);
        contract.setContractName(contractVo.getName());
        contract.setrId(contractVo.getAreaId());
        contract.setpId(contractVo.getProjectId());
        contract.setCompanyId(contractVo.getCompanyId());
        contract.setContractNo(contractVo.getContractNum());
        contract.setRemark(contractVo.getRemark());
        contract.setMasterContact(contractVo.getMainContact());
        contract.setContactPhone(contractVo.getTelephone());
        contract.setState(contractVo.getStatus());
        if (contractVo.getCreateTime() != null) {
            contract.setCreateTime(TimeUtil.parseStrToDateTime(contractVo.getCreateTime()));
        }
        if (contractVo.getStartDay() != null) {
            contract.setStartDate(TimeUtil.parseStrToDate(contractVo.getStartDay()));
        }
        if (contractVo.getEndDay() != null) {
            contract.setEndDate(TimeUtil.parseStrToDate(contractVo.getEndDay()));
        }
        contract.setLogicRemove(false);
        return contract;
    }

    /**
     * 合同附件转换
     * @param fileVo
     * @param conId
     * @return
     */
    private MaintenanceContractFile contractFile(BgyMaintenanceContractFileVo fileVo,Long conId){
        MaintenanceContractFile file = new MaintenanceContractFile();
        file.setId(fileVo.getId());
        file.setFileUrl(fileVo.getUrl());
        file.setFileName(fileVo.getName());
        if (fileVo.getCreateTime() != null) {
            file.setCreateTime(TimeUtil.parseStrToDateTime(fileVo.getCreateTime()));
        }
        file.setContractId(conId);
        file.setLogicRemove(false);
        file.setDownload(false);
        return file;
    }
}
