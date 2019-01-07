package cn.com.bgy.ifc.service.interfaces.inner.firepatrol;

import cn.com.bgy.ifc.entity.po.firepatrol.RegionByRecord;
import cn.com.bgy.ifc.entity.po.firepatrol.RenovationRecord;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/1/7 9:22
 * @Description 装修备案情况
 **/

public interface RenovationRecordService {
    int addRenovationRecord( RegionByRecord regionByRecord, RenovationRecord renovationRecord );

    int deleteRenovationRecord( String ids );

    PageInfo queryRenovationRecordList( Page<Object> page, String keyword, RegionByRecord regionByRecord);

    Map<String,Object> queryRenovationRecordInfo( Long id );

    int updateRenovationRecord( RenovationRecord renovationRecord );
}
