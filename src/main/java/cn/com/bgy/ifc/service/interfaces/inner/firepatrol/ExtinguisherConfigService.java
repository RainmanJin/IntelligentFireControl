package cn.com.bgy.ifc.service.interfaces.inner.firepatrol;

import cn.com.bgy.ifc.entity.po.firepatrol.ExtinguisherConfig;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/1/7 16:16
 * @Description 灭火器配置情况
 **/

public interface ExtinguisherConfigService {
    int addExtinguisherConfig( ExtinguisherConfig extinguisherConfig );

    int deleteExtinguisherConfig( String ids );

    int updateExtinguisherConfig( ExtinguisherConfig extinguisherConfig );

    PageInfo listExtinguisherConfig( Page<Object> page,String keyword, Long recordId, Date startTime, Date endTime);

    Map<String,Object> getExtinguisherConfigFindById( Long id );
}
