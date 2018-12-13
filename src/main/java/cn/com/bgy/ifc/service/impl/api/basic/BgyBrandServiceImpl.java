package cn.com.bgy.ifc.service.impl.api.basic;

import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.ResponseUtil;
import cn.com.bgy.ifc.bgy.utils.SignatureUtil;
import cn.com.bgy.ifc.domain.interfaces.basic.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.domain.interfaces.basic.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.entity.po.basic.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.po.basic.ExternalInterfaceMsg;
import cn.com.bgy.ifc.entity.vo.projects.BgyBrandVo;
import cn.com.bgy.ifc.entity.vo.projects.BgyProjectVo;
import cn.com.bgy.ifc.service.interfaces.api.basic.BgyBrandService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BgyBrandServiceImpl implements BgyBrandService {

    private static Logger logger = LoggerFactory.getLogger(BgyBrandServiceImpl.class);

    @Autowired
    private ExternalInterfaceConfigDomain externalInterfaceConfigDomain;

    @Autowired
    ExternalInterfaceMsgDomain externalInterfaceMsgDomain;

    @Override
    public void obtainBgyBrand(int pageNo, int pageSize) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryIntegrationConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                String url = config.getUrl() + "/api/third/equipment/getEquipmentBrand";
                String account = config.getAccount();
                String signKey = config.getSignKey();
                String timestampStr = SignatureUtil.timestampStr();
                // 请求包结构体
                Map<String, Object> data = new HashMap<>();
                //区域id,为空则返回所有项目
                data.put("pageNo", pageNo);
                data.put("pageSize", pageSize);
                String signature = SignatureUtil.getBgySignature(timestampStr, signKey, data);
                //集成平台HTTP头部需要数据
                Map<String, Object> headerMap = SignatureUtil.getBgyHeader(timestampStr, signature, account);
                //调用HTTP请求
                JSONObject response = HttpHelper.httpPost(url, data, headerMap);
                List<BgyBrandVo> oList = new ArrayList<>();
                BgyBrandVo brandVo = new BgyBrandVo();
                ResponseUtil.getResultList(oList, brandVo, response, "data", "equipmentBrandList");
                System.out.println("oList:" + oList);
                //将接口数据平台的数据保存到数据库中
                this.saveData(response,"data","equipmentBrandList");
            } else {
                logger.info("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台区域列表接口请求异常：" + e.getMessage());
        }
    }

    /**
     * 增量
     * @param pageNo:
     * @param pageSize
     * @param startTime
     */
    @Override
    public void obtainBgyBrandIncrement(int pageNo, int pageSize, String startTime) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryIntegrationConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                String url = config.getUrl() + "/api/third/equipment/getEquipmentBrandIncrement";
                String account = config.getAccount();
                String signKey = config.getSignKey();
                String timestampStr = SignatureUtil.timestampStr();
                // 请求包结构体
                Map<String, Object> data = new HashMap<>();
                //区域id,为空则返回所有项目
                data.put("pageNo", pageNo);
                data.put("pageSize", pageSize);
                data.put("startTime", startTime);
                String signature = SignatureUtil.getBgySignature(timestampStr, signKey, data);
                //集成平台HTTP头部需要数据
                Map<String, Object> headerMap = SignatureUtil.getBgyHeader(timestampStr, signature, account);
                //调用HTTP请求
                JSONObject response = HttpHelper.httpPost(url, data, headerMap);
                List<BgyBrandVo> oList = new ArrayList<>();
                BgyBrandVo brandVo = new BgyBrandVo();
                ResponseUtil.getResultList(oList, brandVo, response, "data", "list");
                System.out.println("oList:" + oList);
                this.saveData(response,"data","list");
            } else {
                logger.info("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台区域列表接口请求异常：" + e.getMessage());
        }
    }
    int saveData(JSONObject jsonObject,String dataKey,String listKey){
        //1 创建externalInterfaceMsg 对象
        ExternalInterfaceMsg externalInterfaceMsg = new ExternalInterfaceMsg();
        //设置externalInterfaceMsg对象字段值

        //设置添加条数为接口返回条数（业务明确做对应修改）
        externalInterfaceMsg.setAddCount(jsonObject.getJSONObject(dataKey).getJSONArray(listKey).size());
        //创建时间设置为当前时间
        externalInterfaceMsg.setCreateTime(new Date());
        //删除条数设置为0（明确业务做相应修改）
        externalInterfaceMsg.setDeleteCount(0);
        //错误条数设置为0（明确业务做相应修改）
        externalInterfaceMsg.setErrorCount(0);
        //是否删除设置为 false
        externalInterfaceMsg.setLogicRemove(false);
        //接口信息类型值，0获取账号信息，1区域信息，2项目信息，3品牌，4规格信息，5设备类型，6机房信息，7设备信息
        externalInterfaceMsg.setMsgTypeValue(1);
        //机构 设置为1（明确业务做相应修改）
        externalInterfaceMsg.setOrgId(1L);
        //外部接口平台 设置为1（只有一条数据--明确业务做相应修改）
        externalInterfaceMsg.setPlatformValue(1);
        //请求时间为当前时间
        externalInterfaceMsg.setRequestTime(new Date());
        //成功条数设置为返回条数（明确业务做相应修改）
        externalInterfaceMsg.setSuccessCount(jsonObject.getJSONObject(dataKey).getJSONArray(listKey).size());
        //总条数设置为返回的总条数（明确业务做相应修改）
        externalInterfaceMsg.setTotalCount(jsonObject.getJSONObject(dataKey).getInteger("totalSize"));
        //修改条数设置为0（明确业务做相应修改）
        externalInterfaceMsg.setUpdateCount(0);
        /**
         * 将赋值后的对象 保存到数据库
         */
        int count = externalInterfaceMsgDomain.insert(externalInterfaceMsg);
        return count;
    }
}
