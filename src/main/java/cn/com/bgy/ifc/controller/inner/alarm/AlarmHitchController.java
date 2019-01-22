package cn.com.bgy.ifc.controller.inner.alarm;

import cn.com.bgy.ifc.bgy.constant.EquipmentConstant;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentEvent;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.alarm.AlarmVo;
import cn.com.bgy.ifc.service.interfaces.inner.alarm.AlarmService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ZhangCheng
 * @description:实时告警故障列表
 * @date: 2019-01-18 09:59
 **/
@RestController
@RequestMapping("/alarm/hitch")
public class AlarmHitchController {

    @Autowired
    private AlarmService alarmService;

    /**
     * @author: ZhangCheng
     * @description:故障列表
     * @param: [page]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo   <   cn.com.bgy.ifc.entity.po.equipment.EquipmentEvent>>
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo<AlarmVo>> queryPage(Page<EquipmentEvent> page) {
        Integer type = EquipmentConstant.StateEnum.FAULT.getValue();
        PageInfo<AlarmVo> pageInfo = alarmService.queryListByPage(page, type);
        return ResponseVO.<PageInfo<AlarmVo>>success().setData(pageInfo);
    }
}
