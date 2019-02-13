package cn.com.bgy.ifc.controller.inner.common;

import cn.com.bgy.ifc.domain.interfaces.equipment.EquipmentInfoDomain;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenanceCompanyDomain;
import cn.com.bgy.ifc.domain.interfaces.project.RegionInfoDomain;
import cn.com.bgy.ifc.domain.interfaces.project.RegionProjectDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentType;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentBrandService;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentInfoService;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentTypeService;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentVersionService;
import cn.com.bgy.ifc.service.interfaces.inner.project.RegionBuildingService;
import cn.com.bgy.ifc.service.interfaces.inner.project.RegionCourtService;
import cn.com.bgy.ifc.service.interfaces.inner.project.RegionStreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/1/17 14:39
 * @Description 所有级联下拉菜单
 **/

@RestController
@RequestMapping("/common")
public class DropDownController extends BaseController{

    @Autowired
    private RegionInfoDomain regionInfoDomain;
    @Autowired
    private RegionProjectDomain regionProjectDomain;
    @Resource
    private RegionCourtService regionCourtService;
    @Resource
    private RegionStreetService regionStreetService;
    @Resource
    private RegionBuildingService regionBuildingService;
    @Autowired
    private EquipmentInfoService equipmentInfoService;
    @Autowired
    private EquipmentBrandService equipmentBrandService;
    @Autowired
    private EquipmentVersionService equipmentVersionService;
    @Autowired
    private EquipmentTypeService equipmentTypeService;
    @Autowired
    private MaintenanceCompanyDomain maintenanceCompanyDomain;
    @Autowired
    private EquipmentInfoDomain equipmentInfoDomain;

   /*
    * @Author  huxin
    * @Description 获取区域下拉菜单
    * @param   []
    * @retrue  cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
    * @Date 2019/1/17 14:44
    */
    @GetMapping("regionDropDownData")
    @ResponseBody
    public ResponseVO<Object> regionDropDownData(){
        Account user=this.getUser();
        List<Map<String,Object>> list  = regionInfoDomain.queryRegionInfoName(user);
        return ResponseVO.<Object>success().setData(list);
    }
    /*
     * @Author  huxin
     * @Description 根据区域ID获取项目下拉菜单列表
     * @param   [regionId]
     * @retrue  cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @Date 2019/1/17 14:46
     */
    @GetMapping("projectDropDownData")
    public ResponseVO<Object> projectDropDownData(Long regionId){
        List<Map<String,Object>> list  = regionProjectDomain.queryRegionProjectNameBySuperId(regionId);
        return ResponseVO.<Object>success().setData(list);
    }
    /*
     * @Author  huxin
     * @Description 根据项目ID查询苑区信息下拉菜单
     * @param   [projectId]
     * @retrue  cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @Date 2019/1/17 14:49
     */
    @GetMapping("courtDropDownData")
    public ResponseVO<Object> courtDropDownData(Long projectId){
        List<Map<String,Object>> list  = regionCourtService.queryRegionCourtNameBySuperId(projectId);
        return ResponseVO.<Object>success().setData(list);
    }

    /*
     * @Author  huxin
     * @Description 根据苑区ID查询街道信息下拉菜单
     * @param   [courtId]
     * @retrue  cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @Date 2019/1/17 14:50
     */
    @GetMapping("streetDropDownData")
    public ResponseVO<Object> streetDropDownData(Long courtId){
        List<Map<String,Object>> list  = regionStreetService.queryRegionStreetNameBySuperId(courtId);
        return ResponseVO.<Object>success().setData(list);
    }
    /*
     * @Author  huxin
     * @Description 根据街道ID查询楼栋单元信息下拉菜单
     * @param   [streetId]
     * @retrue  cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @Date 2019/1/17 14:55
     */
    @GetMapping("buildingDropDownData")
    public ResponseVO<Object> buildingDropDownData(Long streetId){
        List<Map<String,Object>> list  = regionBuildingService.queryRegionBuildingNameBySuperId(streetId);
        return ResponseVO.<Object>success().setData(list);
    }
    /*
     * @Author  huxin
     * @Description 根据项目ID，苑区ID查询设备信息下拉菜单
     * @param   [projectId, courtId]
     * @retrue  cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @Date 2019/1/15 11:49
     */
    @GetMapping("equipmentInfoDropDownData")
    public ResponseVO<Object> quipmentInfoDropDownData(Long projectId,Long courtId){
        return ResponseVO.success().setData(equipmentInfoService.ListByCourtId(projectId,courtId));
    }
    /*
     * @Author  huxin
     * @Description   查询品牌信息下拉菜单
     * @param   []
     * @retrue  cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @Date 2019/1/17 15:10
     */
    @GetMapping("brandDropDownData")
    public ResponseVO<Object> versionDropDownData(){
        List<Map<String,Object>> list =  equipmentBrandService.queryAllEquipmentBrand();
        return ResponseVO.success().setData(list);
    }
    /*
     * @Author  huxin
     * @Description     根据所属品牌ID查询型号下拉菜单
     * @param   [id]
     * @retrue  cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @Date 2019/1/17 15:10
     */
    @GetMapping("versionDropDownData")
    public ResponseVO<Object> versionDropDownData(Long id){
        List<Map<String,Object>> list = equipmentVersionService.queryEquipmentVersionByBrandId(id);
        return ResponseVO.success().setData(list);
    }
    /*
     * @Author  huxin
     * @Description 根据传递的TYPE查询设备类型下拉菜单
     * @param   []
     * @retrue  cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @Date 2019/1/17 15:13
     */
    @GetMapping("typeDropDownData")
    public ResponseVO<Object> typeDropDownData(String type){
        List<EquipmentType> list =  equipmentTypeService.queryAllEquipmentType(type);
        return ResponseVO.success().setData(list);
    }
   /*
    * @Author  huxin
    * @Description     维保公司下拉列表
    * @param   []
    * @retrue  cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
    * @Date 2019/1/17 16:43
    */
    @GetMapping("maintenancecompanyDropDownData")
    @ResponseBody
    public ResponseVO<Object> queryAllList() {
        return ResponseVO.success().setData(maintenanceCompanyDomain.queryListByParam(null));
    }

    /*
     * @Author  huxin
     * @Description 根据条件查询设备下拉框
     * @param   [vo]
     * @retrue  cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @Date 2019/2/13 15:03
     */
    @GetMapping("equipmentDropDownData")
    public ResponseVO<Object> queryMaintenanceCompanyList(RegionAndBrandVO vo) {
        return ResponseVO.success().setData(equipmentInfoDomain.queryAllInfo(vo));
    }
}
