package cn.com.bgy.ifc.controller.inner.common;

import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenanceCompanyDomain;
import cn.com.bgy.ifc.domain.interfaces.project.RegionInfoDomain;
import cn.com.bgy.ifc.domain.interfaces.project.RegionProjectDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentType;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentBrandService;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentInfoService;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentTypeService;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentVersionService;
import cn.com.bgy.ifc.service.interfaces.inner.project.RegionBuildingService;
import cn.com.bgy.ifc.service.interfaces.inner.project.RegionCourtService;
import cn.com.bgy.ifc.service.interfaces.inner.project.RegionStreetService;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpRequest;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author huxin
 * @Date 2019/1/17 14:39
 * @Description 所有级联下拉菜单
 **/
@Controller
@RequestMapping("/common/uploadDown")
@CrossOrigin
public class UploadDownController extends BaseController{

    Logger logger = LoggerFactory.getLogger(UploadDownController.class);

    private String UPLOAD_FOLDER="D:/upload";

    @PostMapping("upload")
    @ResponseBody
    public Object singleFileUpload(MultipartFile file, HttpServletRequest request) {

        String root = request.getRealPath("/upload");
        System.out.println("=================path="+root);
        logger.debug("传入的文件参数：{}", JSON.toJSONString(file, true));
        if (Objects.isNull(file) || file.isEmpty()) {
            logger.error("文件为空");
            return "文件为空，请重新上传";
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER +"/"+ file.getOriginalFilename());
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(UPLOAD_FOLDER));
            }
            //文件写入指定路径
            Files.write(path, bytes);
            logger.debug("文件写入成功...");
            return "文件上传成功";
        } catch (IOException e) {
            e.printStackTrace();
            return "后端异常...";
        }
    }
    @PostMapping("download")
    public void singleDownLoad(HttpServletResponse response) {
        String[] title = {"名称", "性别", "年龄", "学校", "班级"};

        //excel文件名
        String fileName = "学生信息表" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "学生信息表";


        //创建HSSFWorkbook
        HSSFWorkbook wb = getHSSFWorkbook(sheetName, title, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, "1111.xls");
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setResponseHeader(HttpServletResponse response, String fileName) {
            try {
                try {
                    fileName = new String(fileName.getBytes(),"utf-8");
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                response.setContentType("application/octet-stream;charset=utf-8");
                response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
                response.addHeader("Pargam", "no-cache");
                response.addHeader("Cache-Control", "no-cache");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

    }





    public  HSSFWorkbook getHSSFWorkbook(String sheetName,String []title, HSSFWorkbook wb){

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if(wb == null){
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式

        //声明列对象
        HSSFCell cell = null;

        //创建标题
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        return wb;
    }

}
