package cn.com.bgy.ifc.service.interfaces.api.equipment;

import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;

import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台设备信息同步
 * @date: 2018-12-21 11:07
 **/
public interface BgyEquipmentService {

    /**
     * @author: ZhangCheng
     * @description:碧桂园集成平台设备信息同步
     * @param: [pageNo, pageSize]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> baseObtainBgyEquipmentInfo(int pageNo, int pageSize);

    /**
     * @author: ZhangCheng
     * @description:获取集成平台设备信息（全量）
     * @param: [pageNo, pageSize, config]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> obtainBgyEquipmentInfo(int pageNo, int pageSize, ExternalInterfaceConfig config) throws Exception;

    /**
     * @author: ZhangCheng
     * @description:获取集成平台设备信息（增量）
     * @param: [pageNo, pageSize, config, createTime]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> obtainBgyEquipmentInfoIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime) throws Exception;

    /**
     * @author: ZhangCheng
     * @description:碧桂园集成平台设备类型信息同步
     * @param: [pageNo, pageSize]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> baseObtainBgyEquipmentType(int pageNo, int pageSize);

    /**
     * @author: ZhangCheng
     * @description:获取集成平台设备类型信息（全量）
     * @param: [pageNo, pageSize, config]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> obtainBgyEquipmentType(int pageNo, int pageSize, ExternalInterfaceConfig config) throws Exception;

    /**
     * @author: ZhangCheng
     * @description:获取集成平台设备类型信息（增量）
     * @param: [pageNo, pageSize, config, createTime]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> obtainBgyEquipmentTypeIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime) throws Exception;

    /**
     * @author: ZhangCheng
     * @description:碧桂园集成平台设备品牌信息同步
     * @param: [pageNo, pageSize]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> baseObtainBgyEquipmentBrand(int pageNo, int pageSize);

    /**
     * @author: ZhangCheng
     * @description:获取集成平台设备品牌信息（全量）
     * @param: [pageNo, pageSize, config]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> obtainBgyEquipmentBrand(int pageNo, int pageSize, ExternalInterfaceConfig config) throws Exception;

    /**
     * @author: ZhangCheng
     * @description:获取集成平台设备品牌信息（增量）
     * @param: [pageNo, pageSize, config, createTime]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> obtainBgyEquipmentBrandIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime) throws Exception;

    /**
     * @author: ZhangCheng
     * @description:碧桂园集成平台设备型号信息同步
     * @param: [pageNo, pageSize]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> baseObtainBgyEquipmentVersion(int pageNo, int pageSize);

    /**
     * @author: ZhangCheng
     * @description:获取集成平台设备型号信息（全量）
     * @param: [pageNo, pageSize, config]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> obtainBgyEquipmentVersion(int pageNo, int pageSize, ExternalInterfaceConfig config) throws Exception;

    /**
     * @author: ZhangCheng
     * @description:获取集成平台设备型号信息（增量）
     * @param: [pageNo, pageSize, config, createTime]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> obtainBgyEquipmentVersionIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime) throws Exception;
}
