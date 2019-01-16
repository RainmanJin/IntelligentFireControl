package cn.com.bgy.ifc.controller.inner.equipment;

import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.AnalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ZhangCheng
 * @description:模拟量管理
 * @date: 2019-01-15 16:27
 **/
@RestController
@RequestMapping("/equipment/analog")
public class AnalogController {
    @Autowired
    private AnalogService analogService;

    /**
     * @author: ZhangCheng
     * @description:模拟量数据同步
     * @param: `
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("synchroData")
    public ResponseVO<Object> synchroData() {
        return analogService.synchroAnalog(1, 100);
    }
}
