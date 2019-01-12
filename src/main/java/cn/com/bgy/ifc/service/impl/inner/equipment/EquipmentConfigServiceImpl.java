package cn.com.bgy.ifc.service.impl.inner.equipment;

import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.EntityUtil;
import cn.com.bgy.ifc.bgy.utils.ExceptionUtil;
import cn.com.bgy.ifc.dao.equipment.EquipmentConfigDao;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentConfig;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentConfigService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
                Map<String, Object> data = EntityUtil.entityToMap(equipmentConfig);
                JSONObject response = HttpHelper.httpPost(url, data, null);
                if (response != null) {
                    //data作为key获取JSONObject
                    Integer statusCode = response.getInteger("code");
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
                        return ResponseVO.error().setMsg("中联永安创建设备配置信息失败!错误码：" + statusCode);
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
                String url = config.getUrl() + "/device/configs?id=" + id;
                Map<String, Object> data = EntityUtil.entityToMap(equipmentConfig);
                JSONObject response = HttpHelper.httpPut(url, data, null);
                if (response != null) {
                    //data作为key获取JSONObject
                    Integer statusCode = response.getInteger("code");
                    if (HttpStatus.SC_OK == statusCode) {
                        int result = equipmentConfigDao.update(equipmentConfig);
                        if (result == 1) {
                            return ResponseVO.addSuccess();
                        } else {
                            return ResponseVO.addError();
                        }
                    } else {
                        return ResponseVO.error().setMsg("中联永安修改设备配置信息失败!错误码：" + statusCode);
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
}
