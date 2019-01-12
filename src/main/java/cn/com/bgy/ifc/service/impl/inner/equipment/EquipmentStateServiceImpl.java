package cn.com.bgy.ifc.service.impl.inner.equipment;

import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.DbUtil;
import cn.com.bgy.ifc.bgy.utils.ExceptionUtil;
import cn.com.bgy.ifc.bgy.utils.ResponseUtil;
import cn.com.bgy.ifc.dao.equipment.EquipmentStateDao;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentState;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentStateService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2019-01-10 19:27
 **/
@Service
public class EquipmentStateServiceImpl implements EquipmentStateService {

    private static Logger logger = LoggerFactory.getLogger(EquipmentConfigServiceImpl.class);

    @Resource
    private EquipmentStateDao equipmentStateDao;

    @Autowired
    private ExternalInterfaceConfigDomain externalInterfaceConfigDomain;

    @Override
    public EquipmentState findById(Long id) {
        return equipmentStateDao.findById(id);
    }

    @Override
    public int insert(EquipmentState equipmentState) {
        return 0;
    }

    @Override
    public int insertSelective(EquipmentState equipmentState) {
        return 0;
    }

    @Override
    public int update(EquipmentState equipmentState) {
        return 0;
    }

    @Override
    public int updateSelective(EquipmentState equipmentState) {
        return 0;
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return 0;
    }

    @Override
    public PageInfo<EquipmentState> queryListByPage(Page page, EquipmentState equipmentState) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<EquipmentState> list = equipmentStateDao.queryListByParam(equipmentState);
        PageInfo<EquipmentState> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public ResponseVO<Object> synchroEquipmentState(int pageNum, int pageSize) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryInternetThingConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                String baseUrl=config.getUrl() + "/device/devices";
                String url = baseUrl + "?page="+pageNum+"&size"+pageSize;
                JSONObject response = HttpHelper.httpGet(url,null);
                if (response != null) {
                    List<Map<String, Object>> configList=new ArrayList();
                    ResponseUtil.getResultListMap(configList,response, "data", "list");
                    // 总页数
                    int pageCount = ResponseUtil.getPages(response,"pages");
                    if(pageCount>1){
                        ResponseUtil.getListMapByPage(pageNum,pageSize,pageCount,baseUrl,configList,"data", "list");
                    }
                    int totalCount = configList.size();
                    if (totalCount > 0) {
                        int result= DbUtil.replaceAll("equipment_state",configList);
                        if(result==totalCount){
                            return ResponseVO.success().setMsg("设备状态数据同步成功！");
                        } else {
                            return ResponseVO.error().setMsg("设备状态数据同步失败！");
                        }
                    } else {
                        return ResponseVO.success().setMsg("暂无中联永安设备状态数据同步！");
                    }
                } else {
                    return ResponseVO.error().setMsg("获取中联永安设备状态信息列表失败!");
                }
            } else {
                return ResponseVO.error().setMsg("获取中联永安接口配置信息失败！");
            }
        } catch (Exception e) {
            logger.error("获取中联永安设备配置列表接口请求异常：", e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("获取中联永安设备配置列表接口请求异常！", e));
        }
    }
}
