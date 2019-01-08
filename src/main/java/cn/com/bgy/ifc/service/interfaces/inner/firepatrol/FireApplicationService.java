package cn.com.bgy.ifc.service.interfaces.inner.firepatrol;

import cn.com.bgy.ifc.entity.po.firepatrol.FireApplication;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/1/8 9:22
 * @Description 动火证申请情况
 **/

public interface FireApplicationService {
    int addFireApplication( FireApplication renovationJunk );

    int deleteFireApplication( String ids );

    int updateFireApplication( FireApplication renovationJunk );

    PageInfo listFireApplication( Page<Object> page, String keyword, Long recordId );

    Map<String,Object> getFireApplicationById( Long id );
}
