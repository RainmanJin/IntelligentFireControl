package cn.com.bgy.ifc.controller.inner.firepatrol;

import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.firepatrol.FireAccidentDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.FireAccident;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/firepatrol/fireAccident")
public class FireAccidentController extends BaseController {
    @Autowired
    private FireAccidentDomain fireAccidentDomain;

    /**
     * @description:
     * @param: [page, fireAccident]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.firepatrol.FireAccident>>
     * @auther: chenlie
     * @date: 2019/1/7 17:24
     */
    @GetMapping("searchPage")
    public ResponseVO<PageInfo<FireAccident>> queryListByPage(Page<FireAccident> page, FireAccident fireAccident) {

        PageInfo<FireAccident> pageInfo = fireAccidentDomain.queryListByPage(page, fireAccident);
        return ResponseVO.<PageInfo<FireAccident>>success().setData(pageInfo);
    }


}
