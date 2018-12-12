package cn.com.bgy.ifc.service.impl.api.basic;

import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.ResponseUtil;
import cn.com.bgy.ifc.bgy.utils.SignatureUtil;
import cn.com.bgy.ifc.domain.impl.basic.ExternalInterfaceConfigDomainImpl;
import cn.com.bgy.ifc.entity.po.basic.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.projects.BgyEquipmentVersionVo;
import cn.com.bgy.ifc.entity.vo.projects.EquipmentTypeVo;
import cn.com.bgy.ifc.entity.vo.projects.EquipmentVo;
import cn.com.bgy.ifc.service.interfaces.api.basic.EquipmentApiService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/11 16:26
 * @Description 消防设备信息接口
 **/
@Service
public class EquipmentApiServiceImpl implements EquipmentApiService {

    private static Logger logger = LoggerFactory.getLogger(UserApiServiceImpl.class);
    @Autowired
    private ExternalInterfaceConfigDomainImpl externalInterfaceConfigDomain;

    /**
     * @Author huxin
     * @Description 集成平台获取设备信息列表接口
     * @Date 2018/12/11 16:33
     */
    @Override
    public void obtainEquipment(int areaId,int projectId,int machineRoomId,int typeId,int pageNo,int pageSize) {
        try {
            List<ExternalInterfaceConfig> list=externalInterfaceConfigDomain.queryIntegrationConfig();
            if(list.size()!=0){
                ExternalInterfaceConfig config=list.get(0);
                String url = config.getUrl()+"/api/third/equipment/getEquipmentList";
                String account = config.getAccount();
                String signKey = config.getSignKey();
                String timestampStr = SignatureUtil.timestampStr();
                // 请求包结构体
                Map<String, Object> data = new HashMap<>();
                if(areaId>0){
                    data.put("areaId",areaId);
                }
                if(projectId>0){
                    data.put("projectId",projectId);
                }
                if(machineRoomId>0){
                    data.put("machineRoomId",machineRoomId);
                }
                if(typeId>0){
                    data.put("typeId",typeId);
                }
                data.put("pageNo", pageNo);
                data.put("pageSize", pageSize);
                String signature=SignatureUtil.getBgySignature(timestampStr, signKey, data);

                //集成平台HTTP头部需要数据
                Map<String, Object> headerMap = SignatureUtil.getBgyHeader(timestampStr, signature, account);

                //调用HTTP请求
                JSONObject response = HttpHelper.httpPost(url, data, headerMap);
                List<EquipmentVo> oList = new ArrayList<>();
                EquipmentVo equipmentVo= new EquipmentVo();
                ResponseUtil.getResultList(oList,equipmentVo,response,"data","equipmentList");
                System.out.println("oList:" + oList);

            }else{
                logger.info("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台设备信息接口请求异常：" + e.getMessage());
        }

    }
    /**
     * @Author huxin
     * @Description 集成平台获取设备信息列表接口(增量)
     * @Date 2018/12/11 16:33
     */
    @Override
    public void obtainListEquipment( String startTime,int pageNo, int pageSize) {
        try {
            List<ExternalInterfaceConfig> list=externalInterfaceConfigDomain.queryIntegrationConfig();
            if(list.size()!=0){
                ExternalInterfaceConfig config=list.get(0);
                String url = config.getUrl()+"/api/third/equipment/getEquipmentListIncrement";
                String account = config.getAccount();
                String signKey = config.getSignKey();
                String timestampStr = SignatureUtil.timestampStr();
                // 请求包结构体
                Map<String, Object> data = new HashMap<>();
                data.put("startTime",startTime);
                data.put("pageNo", pageNo);
                data.put("pageSize", pageSize);
                String signature= SignatureUtil.getBgySignature(timestampStr, signKey, data);
                //集成平台HTTP头部需要数据
                Map<String, Object> headerMap = SignatureUtil.getBgyHeader(timestampStr, signature, account);
                //调用HTTP请求
                JSONObject response = HttpHelper.httpPost(url, data, headerMap);
                List<EquipmentVo> oList = new ArrayList<>();
                EquipmentVo equipmentVo= new EquipmentVo();
                ResponseUtil.getResultList(oList,equipmentVo,response,"data","list");
                System.out.println("oList:" + oList);
            }else{
                logger.info("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台设备信息列表接口（增量）请求异常：" + e.getMessage());
        }


    }

    @Override
    public void obtainBgyEquipmentVersion(int pageNo, int pageSize) {
        try {
            List<ExternalInterfaceConfig> list=externalInterfaceConfigDomain.queryIntegrationConfig();
            if(list.size()!=0){
                ExternalInterfaceConfig config=list.get(0);
                String url = config.getUrl()+"/api/third/equipment/getEquipmentVersion";
                String account = config.getAccount();
                String signKey = config.getSignKey();
                String timestampStr = SignatureUtil.timestampStr();
                // 请求包结构体
                Map<String, Object> data = new HashMap<>();
                data.put("pageNo", pageNo);
                data.put("pageSize", pageSize);
                String signature = SignatureUtil.getBgySignature(timestampStr, signKey, data);
                //集成平台HTTP头部需要数据
                Map<String, Object> headerMap = SignatureUtil.getBgyHeader(timestampStr, signature, account);
                //调用HTTP请求
                JSONObject response = HttpHelper.httpPost(url, data, headerMap);
                List<BgyEquipmentVersionVo> oList = new ArrayList<>();
                BgyEquipmentVersionVo bgyEquipmentVersionVo=new BgyEquipmentVersionVo();
                ResponseUtil.getResultList(oList,bgyEquipmentVersionVo,response,"data","equipmentVersionList");
                System.out.println("oList:" + oList);
            }else{
                logger.info("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台项目列表接口请求异常：" + e.getMessage());
        }
    }

    @Override
    public void obtainBgyEquipmentVersionIncrement(int pageNo, int pageSize) {
        try {
            List<ExternalInterfaceConfig> list=externalInterfaceConfigDomain.queryIntegrationConfig();
            if(list.size()!=0){
                ExternalInterfaceConfig config=list.get(0);
                String url = config.getUrl()+"/api/third/equipment/getEquipmentVersionIncrement";
                String account = config.getAccount();
                String signKey = config.getSignKey();
                String timestampStr = SignatureUtil.timestampStr();
                // 请求包结构体
                Map<String, Object> data = new HashMap<>();
                data.put("startTime", "2018-10-01 01:00:00");
                data.put("pageNo", pageNo);
                data.put("pageSize", pageSize);
                String signature = SignatureUtil.getBgySignature(timestampStr, signKey, data);
                //集成平台HTTP头部需要数据
                Map<String, Object> headerMap = SignatureUtil.getBgyHeader(timestampStr, signature, account);
                //调用HTTP请求
                JSONObject response = HttpHelper.httpPost(url, data, headerMap);
                List<BgyEquipmentVersionVo> oList = new ArrayList<>();
                BgyEquipmentVersionVo bgyEquipmentVersionVo=new BgyEquipmentVersionVo();
                ResponseUtil.getResultList(oList,bgyEquipmentVersionVo,response,"data","list");
                System.out.println("oList:" + oList);
            }else{
                logger.info("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台项目列表（增量）接口请求异常：" + e.getMessage());
        }
    }
    /**
     * @Author huxin
     * @Description 获取集成平台设备类型列表
     * @Date 2018/12/12 16:13
     */
    @Override
    public void obtainEquipmentType( int pageNo, int pageSize ) {
        try {
            List<ExternalInterfaceConfig> list=externalInterfaceConfigDomain.queryIntegrationConfig();
            if(list.size()!=0){
                ExternalInterfaceConfig config=list.get(0);
                String url = config.getUrl()+"/api/third/equipment/getEquipmentType";
                String account = config.getAccount();
                String signKey = config.getSignKey();
                String timestampStr = SignatureUtil.timestampStr();
                // 请求包结构体
                Map<String, Object> data = new HashMap<>();
                data.put("pageNo", pageNo);
                data.put("pageSize", pageSize);
                String signature= SignatureUtil.getBgySignature(timestampStr, signKey, data);
                //集成平台HTTP头部需要数据
                Map<String, Object> headerMap = SignatureUtil.getBgyHeader(timestampStr, signature, account);
                //调用HTTP请求
                JSONObject response = HttpHelper.httpPost(url, data, headerMap);


                List<EquipmentTypeVo> obList = new ArrayList<>();
                EquipmentTypeVo equipmentTypeVo = new EquipmentTypeVo();
                ResponseUtil.getResultList(obList,equipmentTypeVo,response,"data","equipmentTypeList");

                System.out.println(" obList:" + obList);
            }else{
                logger.info("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台设备类型列表接口请求异常：" + e.getMessage());
        }
    }
    /**
     * @Author huxin
     * @Description 获取集成平台设备类型列表（增量）
     * @Date 2018/12/12 16:14
     */
    @Override
    public void obtainListEquipmentType( String startTime, int pageNo, int pageSize ) {
        try {
            List<ExternalInterfaceConfig> list=externalInterfaceConfigDomain.queryIntegrationConfig();
            if(list.size()!=0){
                ExternalInterfaceConfig config=list.get(0);
                String url = config.getUrl()+"/api/third/equipment/getEquipmentTypeIncrement";
                String account = config.getAccount();
                String signKey = config.getSignKey();
                String timestampStr = SignatureUtil.timestampStr();
                // 请求包结构体
                Map<String, Object> data = new HashMap<>();
                data.put("startTime",startTime);
                data.put("pageNo", pageNo);
                data.put("pageSize", pageSize);
                String signature= SignatureUtil.getBgySignature(timestampStr, signKey, data);
                //集成平台HTTP头部需要数据
                Map<String, Object> headerMap = SignatureUtil.getBgyHeader(timestampStr, signature, account);
                //调用HTTP请求
                JSONObject response = HttpHelper.httpPost(url, data, headerMap);
                List<EquipmentTypeVo> obList = new ArrayList<>();
                EquipmentTypeVo equipmentTypeVo = new EquipmentTypeVo();
                ResponseUtil.getResultList(obList,equipmentTypeVo,response,"data","list");
                System.out.println("mapList:" + obList);
            }else{
                logger.info("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台设备类型接口（增量）请求异常：" + e.getMessage());
        }
    }


}
