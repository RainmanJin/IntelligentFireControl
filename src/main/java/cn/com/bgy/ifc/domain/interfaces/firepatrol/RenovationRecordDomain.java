package cn.com.bgy.ifc.domain.interfaces.firepatrol;

import cn.com.bgy.ifc.entity.po.firepatrol.RegionByRecord;
import cn.com.bgy.ifc.entity.po.firepatrol.RenovationRecord;

import java.util.List;

/**
 * @Author huxin
 * @Date 2019/1/7 9:25
 * @Description 装修备案情况
 **/

public interface RenovationRecordDomain {
    int addRenovationRecord( RegionByRecord regionByRecord, RenovationRecord renovationRecord );

    int deleteRenovationRecord( List<Long> list );

    int updateRenovationRecord( RenovationRecord renovationRecord );
}
