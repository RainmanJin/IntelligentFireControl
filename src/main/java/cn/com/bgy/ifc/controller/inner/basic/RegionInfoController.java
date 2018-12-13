package cn.com.bgy.ifc.controller.inner.basic;

import cn.com.bgy.ifc.domain.interfaces.basic.RegionInfoDomain;
import cn.com.bgy.ifc.entity.po.basic.RegionInfo;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/basic/regionInfo")
public class RegionInfoController {
    @Autowired
    private RegionInfoDomain regionInfoDomain;
    /**
     * 分页查询
     * @param regionInfo
     * @return
     */
    @PostMapping ("searchPage")
    @ResponseBody
    public ResponseVO<Object> searchPage(RegionInfo regionInfo){
        Page page = new Page();
        page.setPageSize(regionInfo.getPageSize());
        page.setPageNum(regionInfo.getPageNum());
        PageInfo<RegionInfo> pageInfo=regionInfoDomain.searchByPage(page,regionInfo);
        return ResponseVO.success().setData(pageInfo);
    }

}
