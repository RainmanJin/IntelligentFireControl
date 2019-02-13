package cn.com.bgy.ifc.dao.systemchecking;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.systemchecking.SystemChecking;
import cn.com.bgy.ifc.entity.vo.systemchecking.SystemCheckingVo;

import java.util.List;

public interface SystemCheckingDao extends BaseDao <SystemChecking> {

    /**
     * 系统巡检分页查询
     * @param systemCheckingVo
     * @return
     */
    List<SystemChecking> queryListByParam(SystemCheckingVo systemCheckingVo);

}