package cn.com.bgy.ifc.controller.inner.basic;

import cn.com.bgy.ifc.domain.interfaces.basic.BrandDomain;
import cn.com.bgy.ifc.entity.po.basic.Brand;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/basic/brand")
public class BrandController {
    private BrandDomain brandDomain;
    /**
     * 分页查询:品牌获取
     * @param brand
     * @return
     */
    @PostMapping("searchPage")
    @ResponseBody
    public ResponseVO<Object> searchPage(Brand brand){
        Page page = new Page();
        page.setPageSize(brand.getPageSize());
        page.setPageNum(brand.getPageNum());
        PageInfo<Brand> pageInfo=brandDomain.searchByPage(page,brand);
        return ResponseVO.success().setData(pageInfo);
    }
}
