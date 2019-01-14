package cn.com.bgy.ifc.service.impl.inner.equipment;

import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.DbUtil;
import cn.com.bgy.ifc.bgy.utils.ExceptionUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.bgy.utils.ResponseUtil;
import cn.com.bgy.ifc.dao.equipment.EquipmentConfigDao;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentConfig;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentConfigService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Joiner;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangCheng
 * @description:中联永安物联接口设备配置
 * @date: 2019-01-10 14:16
 **/
@Service
public class EquipmentConfigServiceImpl implements EquipmentConfigService {

    private static Logger logger = LoggerFactory.getLogger(EquipmentConfigServiceImpl.class);

    @Resource
    private EquipmentConfigDao equipmentConfigDao;

    @Autowired
    private ExternalInterfaceConfigDomain externalInterfaceConfigDomain;

    @Override
    public EquipmentConfig findById(Long id) {
        return equipmentConfigDao.findById(id);
    }

    @Override
    public int insert(EquipmentConfig equipmentConfig) {
        return equipmentConfigDao.insert(equipmentConfig);
    }

    @Override
    public int insertSelective(EquipmentConfig equipmentConfig) {

        return equipmentConfigDao.insertSelective(equipmentConfig);
    }

    @Override
    public int update(EquipmentConfig equipmentConfig) {
        return equipmentConfigDao.update(equipmentConfig);
    }

    @Override
    public int updateSelective(EquipmentConfig equipmentConfig) {
        return equipmentConfigDao.updateSelective(equipmentConfig);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return equipmentConfigDao.deleteBatch(ids);
    }

    @Override
    public PageInfo<EquipmentConfig> queryListByPage(Page page, EquipmentConfig equipmentConfig) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<EquipmentConfig> list = equipmentConfigDao.queryListByParam(equipmentConfig);
        PageInfo<EquipmentConfig> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public ResponseVO<Object> createEquipmentConfig(EquipmentConfig equipmentConfig) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryInternetThingConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                String url = config.getUrl() + "/device/configs";
                Map<String, Object> data = new HashMap<>();
                data.put("type", equipmentConfig.getType());
                data.put("valueType", equipmentConfig.getValueType());
                data.put("valueThresholdMax", equipmentConfig.getValueThresholdMax());
                data.put("valueThresholdMin", equipmentConfig.getValueThresholdMin());
                data.put("valueUnitType", equipmentConfig.getValueUnitType());
                data.put("heartbeatInterval", equipmentConfig.getHeartbeatInterval());
                JSONObject response = HttpHelper.httpPost(url, data, null);
                if (response != null) {
                    //data作为key获取JSONObject
                    Integer statusCode = response.getInteger("code");
                    String message = response.getString("message");
                    if (HttpStatus.SC_OK == statusCode) {
                        JSONObject jsonObject = response.getJSONObject("data");
                        Long id = jsonObject.getLong("id");
                        equipmentConfig.setId(id);
                        int result = equipmentConfigDao.insertSelective(equipmentConfig);
                        if (result == 1) {
                            return ResponseVO.addSuccess();
                        } else {
                            return ResponseVO.addError();
                        }
                    } else {
                        return ResponseVO.error().setMsg("添加失败!错误信息：" + message);
                    }
                } else {
                    return ResponseVO.error().setMsg("中联永安创建设备配置信息失败!");
                }
            } else {
                return ResponseVO.error().setMsg("获取中联永安设备接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取中联永安设备配置接口请求异常：", e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("获取中联永安设备配置接口请求异常！", e));
        }
    }

    @Override
    public ResponseVO<Object> editEquipmentConfig(EquipmentConfig equipmentConfig) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryInternetThingConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                Long id = equipmentConfig.getId();
                String url = config.getUrl() + "/device/configs/" + id;
                Map<String, Object> data = new HashMap<>();
                data.put("type", equipmentConfig.getType());
                data.put("valueType", equipmentConfig.getValueType());
                data.put("valueThresholdMax", equipmentConfig.getValueThresholdMax());
                data.put("valueThresholdMin", equipmentConfig.getValueThresholdMin());
                data.put("valueUnitType", equipmentConfig.getValueUnitType());
                data.put("heartbeatInterval", equipmentConfig.getHeartbeatInterval());
                JSONObject response = HttpHelper.httpPut(url, data, null);
                if (response != null) {
                    //data作为key获取JSONObject
                    Integer statusCode = response.getInteger("code");
                    String message = response.getString("message");
                    if (HttpStatus.SC_OK == statusCode) {
                        int result = equipmentConfigDao.updateSelective(equipmentConfig);
                        if (result == 1) {
                            return ResponseVO.addSuccess();
                        } else {
                            return ResponseVO.addError();
                        }
                    } else {
                        return ResponseVO.error().setMsg("修改失败!错误信息：" + message);
                    }
                } else {
                    return ResponseVO.error().setMsg("中联永安修改设备配置信息失败!");
                }
            } else {
                return ResponseVO.error().setMsg("获取中联永安设备接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取中联永安设备配置接口请求异常：", e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("获取中联永安设备配置接口请求异常！", e));
        }
    }

    @Override
    public ResponseVO<Object> synchroEquipmentConfig(int pageNum, int pageSize) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryInternetThingConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                String baseUrl = config.getUrl() + "/device/configs";
                String url = baseUrl + "?page=" + pageNum + "&size" + pageSize;
                JSONObject response = HttpHelper.httpGet(url, null);
                if (response != null) {
                    List<Map<String, Object>> configList = new ArrayList();
                    ResponseUtil.getResultListMap(configList, response, "data", "list");
                    // 总页数
                    int pageCount = ResponseUtil.getPages(response, "pages");
                    if (pageCount > 1) {
                        ResponseUtil.getListMapByPage(pageNum, pageSize, pageCount, baseUrl, configList, "data", "list");
                    }
                    int totalCount = configList.size();
                    if (totalCount > 0) {
                        int result = DbUtil.replaceAll("equipment_config", configList);
                        if (result == totalCount) {
                            return ResponseVO.success().setMsg("设备配置数据同步成功！");
                        } else {
                            return ResponseVO.error().setMsg("设备配置数据同步失败！");
                        }
                    } else {
                        return ResponseVO.success().setMsg("暂无中联永安设备配置数据同步！");
                    }
                } else {
                    return ResponseVO.error().setMsg("获取中联永安设备配置信息列表失败!");
                }
            } else {
                return ResponseVO.error().setMsg("获取中联永安接口配置信息失败！");
            }
        } catch (Exception e) {
            logger.error("获取中联永安设备配置列表接口请求异常：", e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("获取中联永安设备配置列表接口请求异常！", e));
        }
    }

    @Override
    public ResponseVO<Object> deleteEquipmentConfig(String ids) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryInternetThingConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                List<Long> idList = ListUtil.getListId(ids);
                String url = "";
                if(idList.size()>1){
                    String newIds = ListUtil.getIdStr(idList);
                    url = config.getUrl() + "/device/configs?ids=" + newIds;
                }else{
                    url = config.getUrl() + "/device/configs/" + idList.get(0);
                }
                JSONObject response = HttpHelper.httpDelete(url, null);
                if (response != null) {
                    //data作为key获取JSONObject
                    Integer statusCode = response.getInteger("code");
                    String message = response.getString("message");
                    if (HttpStatus.SC_OK == statusCode) {
                        int result = equipmentConfigDao.deleteBatch(idList);
                        if (result == idList.size()) {
                            return ResponseVO.deleteSuccess();
                        } else {
                            return ResponseVO.deleteError();
                        }
                    } else {
                        return ResponseVO.error().setMsg("刪除失败!错误信息：" + message);
                    }
                } else {
                    return ResponseVO.error().setMsg("中联永安刪除设备配置信息失败!");
                }
            } else {
                return ResponseVO.error().setMsg("获取中联永安接口配置信息失败！");
            }
        } catch (Exception e) {
            logger.error("删除中联永安设备配置信息接口请求异常：", e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("删除中联永安设备配置信息接口请求异常！", e));
        }
    }
}
