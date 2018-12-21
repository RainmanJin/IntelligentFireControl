package cn.com.bgy.ifc.service.impl.api.equipment;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.ResponseUtil;
import cn.com.bgy.ifc.bgy.utils.SignatureUtil;
import cn.com.bgy.ifc.bgy.utils.TimeUtil;
import cn.com.bgy.ifc.domain.interfaces.system.basic.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.domain.interfaces.system.basic.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.domain.interfaces.system.equipment.EquipmentBrandDomain;
import cn.com.bgy.ifc.domain.interfaces.system.equipment.EquipmentTypeDomain;
import cn.com.bgy.ifc.entity.po.system.basic.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.po.system.basic.ExternalInterfaceMsg;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.basic.HttpVo;
import cn.com.bgy.ifc.entity.vo.equipment.BgyEquipmentBrandVo;
import cn.com.bgy.ifc.entity.vo.equipment.BgyEquipmentTypeVo;
import cn.com.bgy.ifc.service.interfaces.api.equipment.BgyEquipmentService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2018-12-21 11:07
 **/
@Service
public class BgyEquipmentServiceImpl implements BgyEquipmentService {

    private static Logger logger = LoggerFactory.getLogger(BgyEquipmentServiceImpl.class);

    @Autowired
    private ExternalInterfaceConfigDomain externalInterfaceConfigDomain;

    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;

    @Autowired
    private EquipmentTypeDomain equipmentTypeDomain;

    @Autowired
    private EquipmentBrandDomain equipmentBrandDomain;

    @SystemLogAfterSave(type = 7, description = "同步集成平台设备类型数据")
    @Override
    public ResponseVO<Object> baseObtainBgyEquipmentType(int pageNo, int pageSize) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryIntegrationConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                Long orgId = config.getOrgId();
                //机构日志,设备类型
                List<ExternalInterfaceMsg> msgList = externalInterfaceMsgDomain.queryBgyInterfaceMsg(ExternalConstant.MsgTypeValue.BGY_EQUIPMENT_TYPE_OBTAIN.getValue(), orgId);
                if (msgList.size() > 0) {
                    ExternalInterfaceMsg interfaceMsg = msgList.get(0);
                    Date createTime = interfaceMsg.getCreateTime();
                    return obtainBgyEquipmentTypeIncrement(pageNo, pageSize, config, createTime);
                } else {
                    return obtainBgyEquipmentType(pageNo, pageSize, config);
                }
            } else {
                logger.info("获取集成平台接口配置数据失败！");
                return ResponseVO.error().setMsg("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台设备类型列表接口请求异常：" + e);
            return ResponseVO.error().setMsg("获取集成平台设备类型列表接口请求异常！");
        }
    }

    @Override
    public ResponseVO<Object> obtainBgyEquipmentType(int pageNo, int pageSize, ExternalInterfaceConfig config) throws Exception {
        String reqUrl = "/api/third/equipment/getEquipmentType";
        long orgId = config.getOrgId();
        // 请求包结构体
        Map<String, Object> data = new HashMap<>();
        data.put("pageNo", pageNo);
        data.put("pageSize", pageSize);
        //集成平台HTTP头部需要数据
        HttpVo httpVo = SignatureUtil.getHttpVo(config, reqUrl, data);
        //调用HTTP请求
        JSONObject response = HttpHelper.httpPost(httpVo.getUrl(), data, httpVo.getHeaderMap());
        // 总页数
        int pageCount = ResponseUtil.getPageCount(response, pageSize);
        List<BgyEquipmentTypeVo> oList = new ArrayList<>();
        BgyEquipmentTypeVo bgyEquipmentType = new BgyEquipmentTypeVo();
        ResponseUtil.getResultList(oList, bgyEquipmentType, response, "data", "equipmentTypeList");
        if (pageCount != 0) {
            ResponseUtil.getResultByPage(pageNo, pageSize, pageCount, config, reqUrl, oList, bgyEquipmentType, "data", "equipmentTypeList");
        }
        int totalCount = oList.size();
        if (totalCount > 0) {
            return equipmentTypeDomain.saveBgyEquipmentType(oList, orgId);
        } else {
            return ResponseVO.success().setMsg("暂无集成平台设备类型数据同步！");
        }
    }

    @Override
    public ResponseVO<Object> obtainBgyEquipmentTypeIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime) throws Exception {
        String reqUrl = "/api/third/equipment/getEquipmentTypeIncrement";
        long orgId = config.getOrgId();
        //格式化时间字符串
        String dateTime = TimeUtil.parseDateToStr(createTime);
        // 请求包结构体
        Map<String, Object> data = new HashMap<>();
        data.put("startTime", dateTime);
        data.put("pageNo", pageNo);
        data.put("pageSize", pageSize);
        //集成平台HTTP头部需要数据
        HttpVo httpVo = SignatureUtil.getHttpVo(config, reqUrl, data);
        //调用HTTP请求
        JSONObject response = HttpHelper.httpPost(httpVo.getUrl(), data, httpVo.getHeaderMap());
        // 总页数
        int pageCount = ResponseUtil.getPageCount(response, pageSize);
        List<BgyEquipmentTypeVo> oList = new ArrayList<>();
        BgyEquipmentTypeVo bgyEquipmentType = new BgyEquipmentTypeVo();
        ResponseUtil.getResultList(oList, bgyEquipmentType, response, "data", "list");
        if (pageCount != 0) {
            ResponseUtil.getIncResultByPage(pageNo, pageSize, dateTime, pageCount, config, reqUrl, oList, bgyEquipmentType, "data", "list");
        }
        int totalCount = oList.size();
        if (totalCount > 0) {
            return equipmentTypeDomain.alterBgyEquipmentType(oList, orgId);
        } else {
            return ResponseVO.success().setMsg("暂无集成平台设备类型增量数据同步！");
        }

    }

    @SystemLogAfterSave(type = 7, description = "同步集成平台设备品牌数据")
    @Override
    public ResponseVO<Object> baseObtainBgyEquipmentBrand(int pageNo, int pageSize) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryIntegrationConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                Long orgId = config.getOrgId();
                //机构日志,设备类型
                List<ExternalInterfaceMsg> msgList = externalInterfaceMsgDomain.queryBgyInterfaceMsg(ExternalConstant.MsgTypeValue.BGY_EQUIPMENT_BRAND_OBTAIN.getValue(), orgId);
                if (msgList.size() > 0) {
                    ExternalInterfaceMsg interfaceMsg = msgList.get(0);
                    Date createTime = interfaceMsg.getCreateTime();
                    return obtainBgyEquipmentBrandIncrement(pageNo, pageSize, config, createTime);
                } else {
                    return obtainBgyEquipmentBrand(pageNo, pageSize, config);
                }
            } else {
                logger.info("获取集成平台接口配置数据失败！");
                return ResponseVO.error().setMsg("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台设备品牌列表接口请求异常：" + e);
            return ResponseVO.error().setMsg("获取集成平台设备品牌列表接口请求异常！");
        }
    }

    @Override
    public ResponseVO<Object> obtainBgyEquipmentBrand(int pageNo, int pageSize, ExternalInterfaceConfig config) throws Exception {
        String reqUrl = "/api/third/equipment/getEquipmentBrand";
        long orgId = config.getOrgId();
        // 请求包结构体
        Map<String, Object> data = new HashMap<>();
        data.put("pageNo", pageNo);
        data.put("pageSize", pageSize);
        //集成平台HTTP头部需要数据
        HttpVo httpVo = SignatureUtil.getHttpVo(config, reqUrl, data);
        //调用HTTP请求
        JSONObject response = HttpHelper.httpPost(httpVo.getUrl(), data, httpVo.getHeaderMap());
        // 总页数
        int pageCount = ResponseUtil.getPageCount(response, pageSize);
        List<BgyEquipmentBrandVo> oList = new ArrayList<>();
        BgyEquipmentBrandVo bgyEquipmentBrandVo = new BgyEquipmentBrandVo();
        ResponseUtil.getResultList(oList, bgyEquipmentBrandVo, response, "data", "equipmentBrandList");
        if (pageCount != 0) {
            ResponseUtil.getResultByPage(pageNo, pageSize, pageCount, config, reqUrl, oList, bgyEquipmentBrandVo, "data", "equipmentBrandList");
        }
        int totalCount = oList.size();
        if (totalCount > 0) {
            return equipmentBrandDomain.saveBgyEquipmentBrand(oList, orgId);
        } else {
            return ResponseVO.success().setMsg("暂无集成平台设备品牌数据同步！");
        }
    }

    @Override
    public ResponseVO<Object> obtainBgyEquipmentBrandIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime) throws Exception {
        String reqUrl = "/api/third/equipment/getEquipmentBrandIncrement";
        long orgId = config.getOrgId();
        //格式化时间字符串
        String dateTime = TimeUtil.parseDateToStr(createTime);
        // 请求包结构体
        Map<String, Object> data = new HashMap<>();
        data.put("startTime", dateTime);
        data.put("pageNo", pageNo);
        data.put("pageSize", pageSize);
        //集成平台HTTP头部需要数据
        HttpVo httpVo = SignatureUtil.getHttpVo(config, reqUrl, data);
        //调用HTTP请求
        JSONObject response = HttpHelper.httpPost(httpVo.getUrl(), data, httpVo.getHeaderMap());
        // 总页数
        int pageCount = ResponseUtil.getPageCount(response, pageSize);
        List<BgyEquipmentBrandVo> oList = new ArrayList<>();
        BgyEquipmentBrandVo bgyEquipmentBrandVo = new BgyEquipmentBrandVo();
        ResponseUtil.getResultList(oList, bgyEquipmentBrandVo, response, "data", "list");
        if (pageCount != 0) {
            ResponseUtil.getIncResultByPage(pageNo, pageSize, dateTime, pageCount, config, reqUrl, oList, bgyEquipmentBrandVo, "data", "list");
        }
        int totalCount = oList.size();
        if (totalCount > 0) {
            return equipmentBrandDomain.alterBgyEquipmentBrand(oList, orgId);
        } else {
            return ResponseVO.success().setMsg("暂无集成平台设备品牌增量数据同步！");
        }
    }

    @Override
    public ResponseVO<Object> baseObtainBgyEquipmentVersion(int pageNo, int pageSize) {
        return null;
    }

    @Override
    public ResponseVO<Object> obtainBgyEquipmentVersion(int pageNo, int pageSize, ExternalInterfaceConfig config) throws Exception {
        return null;
    }

    @Override
    public ResponseVO<Object> obtainBgyEquipmentVersionIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime) throws Exception {
        return null;
    }
}
