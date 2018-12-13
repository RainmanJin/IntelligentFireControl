package cn.com.bgy.ifc.service.interfaces.api.basic;

public interface BgyRegionInfoService {
    /**
     *
     * @param pageNo
     * @param pageSize
     * @param orgId
     */
    void obtainBgyRegionInfo(int pageNo, int pageSize,Integer orgId);

    /**
     *
     * @param pageNo
     * @param pageSize
     * @param startTime
     */

    void obtainBgyRegionInfoIncrement(int pageNo, int pageSize,String startTime);
}
