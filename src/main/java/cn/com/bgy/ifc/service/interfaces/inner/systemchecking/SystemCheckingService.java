package cn.com.bgy.ifc.service.interfaces.inner.systemchecking;

import cn.com.bgy.ifc.entity.po.systemchecking.SystemChecking;
import cn.com.bgy.ifc.entity.vo.systemchecking.SystemCheckingVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author: ZhangCheng
 * @description:系统巡检体检
 * @date: 2019-02-13 17:34
 **/
public interface SystemCheckingService {

    /**
     * 系统巡检分页查询
     * @param page
     * @param systemCheckingVo
     * @return
     */
    PageInfo<SystemChecking> queryListByPage(Page page, SystemCheckingVo systemCheckingVo);
}
