package cn.com.bgy.ifc.controller.inner.maintenance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import cn.com.bgy.ifc.config.interceptor.ApplicationProperties;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenanceContractFileDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceContractFile;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.maintenance.MaintenanceContractFileVo;
import org.springframework.web.multipart.MultipartFile;

/**
 * lvbingjian
 * 维保合同附件控制层
 * 2018年12月20日
 */
@Controller
@RequestMapping("/maintenance/maintenanceContractFile")
public class MaintenanceContractFileController extends BaseController{
    @Autowired
    private ApplicationProperties applicationProperties;
	@Autowired
	private MaintenanceContractFileDomain maintenanceContractFileDomain;
	/**
     * 分页查询
     *
     * @return
     */
    @GetMapping("queryPageList")
    @ResponseBody
    public ResponseVO<Object> queryPageList(Page<MaintenanceContractFile> page, MaintenanceContractFile po) {
        //关键只查询暂时默认为公司名称的模糊查询
        PageInfo<MaintenanceContractFile> pageInfo = maintenanceContractFileDomain.queryListByPage(page, po);
        return ResponseVO.success().setData(pageInfo);
    }
    /**
     * 查询全部
     * @return
     */
    @GetMapping("queryAllList")
    @ResponseBody
    public ResponseVO<Object> queryAllList() {
        return ResponseVO.success().setData(maintenanceContractFileDomain.queryListByParam(null));
    }
    /**
     * @Author lvbingjian
     * @Description 新增维保公司
     * @Date 2018年12月20日09:48:38
     */
    @PostMapping("add")
    @SystemLogAfterSave(description = "维保合同附件新增")
    @ResponseBody
    public ResponseVO<Object> add(@Validated MaintenanceContractFileVo vo, BindingResult error) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }

        MaintenanceContractFile maintenanceContractFile = new MaintenanceContractFile();
        //默认是false删除后设为true
        vo.setLogicRemove(false);
        CopyUtil.copyProperties(vo, maintenanceContractFile);
        int count = maintenanceContractFileDomain.insert(maintenanceContractFile);
        if (count == 1) {
            return ResponseVO.addSuccess();
        }
        return ResponseVO.addError();
    }
    /**
     * @Author lvbingjian
     * @Description 修改
     * @Date 2018年12月20日09:48:38
     */
    @PostMapping("update")
    @RequiresRoles(value= {SystemConstant.SYSTEM_ROLES_ADMIN,SystemConstant.SYSTEM_ROLES_ADMIN},logical=Logical.OR)
    @SystemLogAfterSave(description = "维保合同附件修改")
    @ResponseBody
    public ResponseVO<Object> updateRegionStreet(MaintenanceContractFile po){
        int resout = 1;
        int count = maintenanceContractFileDomain.update(po);
        if (count == resout) {
            return ResponseVO.success().setMsg("修改成功");
        }
        return ResponseVO.error().setMsg("修改失败！");
    }

    /**
     * 通过ID查看详细信息
     * lbj
     * 2018年12月20日
     * @param id
     * @param token
     * @return
     */
    @GetMapping("queryById")
    @ResponseBody
    public ResponseVO<MaintenanceContractFile> queryById( long id, String token) {
        MaintenanceContractFile bean = maintenanceContractFileDomain.findById(id);

        return ResponseVO.<MaintenanceContractFile>success().setData(bean);
    }
    /**
     * @description:通过合同id获取合同附件
     * @param: [id, token]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<cn.com.bgy.ifc.entity.po.maintenance.MaintenanceContractFile>
     * @auther: chenlie
     * @date: 2019/2/11 17:11
     */
    @GetMapping("queryByContractId")
    @ResponseBody
    public ResponseVO<MaintenanceContractFile> queryByContractId( long contractId, String token) {
        Map<String, Object> map=new HashMap<>();
        map.put("contractId",contractId);
        List<MaintenanceContractFile> list = maintenanceContractFileDomain.queryListByMap(map);
        MaintenanceContractFile bean;
        if(list!=null && !list.isEmpty()){
           bean=list.get(0);
        }else{
            bean=new MaintenanceContractFile();
        }
        return ResponseVO.<MaintenanceContractFile>success().setData(bean);
    }
    /**
     * @Author lvbingjian
     * @Description 删除
     * @Date 2018/12/18 15:22
     */
    @PostMapping("delete")
    @SystemLogAfterSave(description = "维保合同附件删除")
    @ResponseBody
    public ResponseVO<Object> deleteRegionComputerRoom( String arr, String token){
    	String []ids = arr.split(",");
    	List<Long>list = new ArrayList<Long>();
    	int count;
    	if(ids.length>0) {
    		for (int i = 0; i < ids.length; i++) {
    			list.add(Long.valueOf(ids[i]));
			}
    		count = maintenanceContractFileDomain.deleteBatch(list);
    	}else {
    		count = 0;
    	}
        if (count > 0) {
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.error().setMsg("删除失败！");
    }


    /**
     * @description:合同附件上传
     * @param: [file]
     * @return: java.lang.Object
     * @auther: chenlie
     * @date: 2019/1/22 11:10
     */
    @PostMapping("uploadContract")
    @ResponseBody
    public ResponseVO uploadContract(MultipartFile file, MaintenanceContractFile maintenanceContractFile) {

        if (Objects.isNull(file) || file.isEmpty()) {
            return ResponseVO.error().setMsg("文件为空，请重新上传");
        }

        try {
            byte[] bytes = file.getBytes();
            int length=file.getOriginalFilename().split("[.]").length;
            String fileUrl= UUID.randomUUID()+"."+ file.getOriginalFilename().split("[.]")[length-1];
            String pathStr= applicationProperties.file.getUploadFolder() +fileUrl;
            Path path = Paths.get(pathStr);
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(applicationProperties.file.getUploadFolder()));
            }
            if(maintenanceContractFile==null){
                maintenanceContractFile=new MaintenanceContractFile();
            }
            maintenanceContractFile.setCreateTime(new Date());
            maintenanceContractFile.setDownload(false);
            maintenanceContractFile.setFileName(file.getOriginalFilename());
            maintenanceContractFile.setFileUrl(applicationProperties.file.getFilePath()+fileUrl);
            //maintenanceContractFileDomain.insert(t);
            //文件写入指定路径
            Files.write(path, bytes);
            return ResponseVO.success().setMsg("文件上传成功").setData(maintenanceContractFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseVO.error();
        }
    }
}
