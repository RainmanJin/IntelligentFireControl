package cn.com.bgy.ifc.controller.inner.system.project;

import cn.com.bgy.ifc.domain.interfaces.system.basic.ModelPowerDomain;
import cn.com.bgy.ifc.entity.po.system.basic.ModelPower;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/basic/modelPower")
public class ModelPowerController {
    @Autowired
    ModelPowerDomain modelPowerDomain;

    /**
     * 分页查询
     *
     * @param modelPowern
     * @return
     */
    @PostMapping("queryPageList")
    @ResponseBody
    public ResponseVO<Object> queryPageList(Page page,ModelPower modelPowern) {
        PageInfo<ModelPower> pageInfo = modelPowerDomain.queryPageList(page, modelPowern);
        return ResponseVO.success().setData(pageInfo);
    }
    /**
     * 获取模块名称
     * @return
     */
    @PostMapping("getModelName")
    @ResponseBody
    public ResponseVO<Object> getModelName() {

        return ResponseVO.success().setData(modelPowerDomain.getModelName());
    }
    /**
     * 获取模块名称
     * @return
     */
    @PostMapping("saveModelPower")
    @ResponseBody
    public ResponseVO<Object> saveModelPower(ModelPower modelPower) {
        int reint = modelPowerDomain.saveModelPower(modelPower);
        if(reint!=0){
            return ResponseVO.success().setMsg("保存成功").setData(null);
        }
        return ResponseVO.error().setMsg("保存失败");
    }

    @PostMapping("deleteModelPower")
    @ResponseBody
    public ResponseVO<Object> deleteModelPower(String longs) {
        if (longs==null){
            return ResponseVO.error().setMsg("参数异常");
        }
        List<Long> list = JSONArray.parseArray(longs,Long.class);
        Long[] deleteLongs = new Long[list.size()];
        list.toArray(deleteLongs);
        if (list.size()==1){
            modelPowerDomain.deleteModelPowerOne(deleteLongs[0]);
            return ResponseVO.success().setMsg("删除成功").setData(null);
        }else {
            modelPowerDomain.deleteModelPower(deleteLongs);
            return ResponseVO.success().setMsg("删除成功").setData(null);
        }
    }
}