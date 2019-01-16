package cn.com.bgy.ifc.service.impl.inner.equipment;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.LoginState;
import cn.com.bgy.ifc.bgy.constant.SystemLogType;
import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.*;
import cn.com.bgy.ifc.dao.equipment.AnalogDao;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.entity.po.equipment.Analog;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.AnalogService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
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
 * @description:
 * @date: 2019-01-15 16:29
 **/
@Service
public class AnalogServiceImpl implements AnalogService {

    private static Logger logger = LoggerFactory.getLogger(AnalogServiceImpl.class);

    @Resource
    private AnalogDao analogDao;

    @Autowired
    private ExternalInterfaceConfigDomain externalInterfaceConfigDomain;


    @Override
    public PageInfo<Analog> queryListByPage(Page page, Analog analog) {
        return null;
    }

    @Override
    public Analog findById(Long id) {
        return analogDao.findById(id);
    }

    @Override
    public ResponseVO<Object> createAnalog(Analog analog) {
        return null;
    }

    @Override
    public ResponseVO<Object> editAnalog(Analog analog) {
        return null;
    }

    @SystemLogAfterSave(type = SystemLogType.INTERFACE_LOG, description = "同步物联设备模拟量",login= LoginState.NOT_LOGIN)
    @Override
    public ResponseVO<Object> synchroAnalog(int pageNum, int pageSize) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryInternetThingConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                String baseUrl = config.getUrl() + "/device/values";
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
                        String executeName = "REPLACE INTO ";
                        int size = configList.size();
                        List<Map<String, Object>> datas = new ArrayList<>();
                        for (int i = 0; i < size; i++) {
                            Map<String, Object> newValueMap = new HashMap<>();
                            Map<String, Object> valueMap = configList.get(i);
                            valueMap.forEach((key, value) -> {
                                //采集时间转换
                                if ("caputureTime".equals(key)) {
                                    if (value != null) {
                                        value = TimeUtil.formatDateOfTimestamp(Long.valueOf(value.toString()));
                                    }
                                }
                                newValueMap.put(EntityUtil.humpToLine(key), value);
                            });
                            datas.add(newValueMap);
                        }
                        int result = DbUtil.insertAll("analog", executeName, datas);
                        if (result == totalCount) {
                            return ResponseVO.success().setMsg("设备模拟量同步成功！");
                        } else {
                            return ResponseVO.error().setMsg("设备模拟量同步失败！");
                        }
                    } else {
                        return ResponseVO.success().setMsg("暂无中联永安设备模拟量同步！");
                    }
                } else {
                    return ResponseVO.error().setMsg("获取中联永安设备模拟量失败!");
                }
            } else {
                return ResponseVO.error().setMsg("获取中联永安接口配置信息失败！");
            }
        } catch (Exception e) {
            logger.error("获取中联永安设备模拟量接口请求异常：", e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("获取中联永安设备模拟量接口请求异常！", e));
        }
    }

    @Override
    public ResponseVO<Object> deleteAnalog(String ids) {
        return null;
    }
}
