package cn.com.bgy.ifc.service.interfaces.inner.firepatrol;

import cn.com.bgy.ifc.entity.po.firepatrol.RenovationJunk;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/1/7 18:04
 * @Description 装修垃圾清理情况
 **/

public interface RenovationJunkService {
    int addRenovationJunk( RenovationJunk renovationJunk );

    int deleteaddRenovationJunk( String ids );

    int updateRenovationJunk( RenovationJunk renovationJunk );

    PageInfo listRenovationJunk( Page<Object> page, String keyword, Long recordId );

    Map<String,Object> getRenovationJunkFindById( Long id );
}
