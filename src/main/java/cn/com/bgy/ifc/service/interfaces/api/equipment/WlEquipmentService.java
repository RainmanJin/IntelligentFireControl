package cn.com.bgy.ifc.service.interfaces.api.equipment;

import cn.com.bgy.ifc.entity.vo.ResponseVO;

/**
 * @author: ZhangCheng
 * @description:中联永安物联接口设备信息同步
 * @date: 2019-01-09 11:14
 **/
public interface WlEquipmentService {

    ResponseVO<Object> createWlEquipment();

    ResponseVO<Object> saveWlEquipment();

}
