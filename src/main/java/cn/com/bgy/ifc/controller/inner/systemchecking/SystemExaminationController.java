package cn.com.bgy.ifc.controller.inner.systemchecking;

import cn.com.bgy.ifc.bgy.constant.EquipmentConstant;
import cn.com.bgy.ifc.bgy.constant.SystemCheckingConstant;
import cn.com.bgy.ifc.entity.po.alarm.RealTimeAlarm;
import cn.com.bgy.ifc.entity.po.systemchecking.SystemChecking;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.alarm.AlarmVo;
import cn.com.bgy.ifc.entity.vo.systemchecking.SystemCheckingVo;
import cn.com.bgy.ifc.service.interfaces.inner.systemchecking.SystemCheckingService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ZhangCheng
 * @description:系统体检
 * @date: 2019-02-13 16:19
 **/
@RestController
@RequestMapping("/checking/examination")
public class SystemExaminationController {

    @Autowired
    private SystemCheckingService systemCheckingService;

    /**
     * 自动体检
     * @param page
     * @param systemCheckingVo
     * @return
     */
    @GetMapping("automaticExamination")
    public ResponseVO<PageInfo<SystemChecking>> automaticInspection(Page<SystemChecking> page, SystemCheckingVo systemCheckingVo) {
        systemCheckingVo.setType(SystemCheckingConstant.SYSTEM_EXAMINATION.getValue());
        systemCheckingVo.setTestType(SystemCheckingConstant.AUTOMATIC_EXAMINATION.getValue());
        PageInfo<SystemChecking> pageInfo = systemCheckingService.queryListByPage(page,systemCheckingVo);
        return ResponseVO.<PageInfo<SystemChecking>>success().setData(pageInfo);
    }

    /**
     * 历史体检
     * @param page
     * @param systemCheckingVo
     * @return
     */
    @GetMapping("historyExamination")
    public ResponseVO<PageInfo<SystemChecking>> queryPage(Page<SystemChecking> page,SystemCheckingVo systemCheckingVo) {
        systemCheckingVo.setType(SystemCheckingConstant.SYSTEM_EXAMINATION.getValue());
        PageInfo<SystemChecking> pageInfo = systemCheckingService.queryListByPage(page,systemCheckingVo);
        return ResponseVO.<PageInfo<SystemChecking>>success().setData(pageInfo);
    }

}
