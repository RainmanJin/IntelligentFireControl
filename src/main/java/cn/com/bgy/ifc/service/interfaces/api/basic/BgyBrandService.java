package cn.com.bgy.ifc.service.interfaces.api.basic;

/**
 * 获取品牌信息
 */
public interface BgyBrandService {
    /**
     * 获取品牌信息列表
     * @param pageNo:
     * @param pageSize
     */
    void obtainBgyBrand(int pageNo, int pageSize);
    /**
     * 获取品牌信息列表(z增量)
     * @param pageNo:
     * @param pageSize
     * @param startTime
     */
    void obtainBgyBrandIncrement(int pageNo, int pageSize,String startTime);
}
