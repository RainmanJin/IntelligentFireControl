package cn.com.bgy.ifc.service.interfaces.api.basic;

/**
 * @author: ZhangCheng
 * @description:获取碧桂园集成平台项目信息
 * @date: 2018-12-11 16:23
 **/
public interface BgyProjectService {

    /**
     * @author: ZhangCheng
     * @description:获取集成平台项目信息
     * @param: [pageNo, pageSize, areaId]
     * @return: void
     */
    void obtainBgyProject(int pageNo, int pageSize,Integer areaId);

    /**
     * @author: ZhangCheng
     * @description:获取集成平台项目信息（增量）
     * @param: [pageNo, pageSize, areaId]
     * @return: void
     */
    void obtainBgyProjectIncrement(int pageNo, int pageSize,Integer areaId);
}
