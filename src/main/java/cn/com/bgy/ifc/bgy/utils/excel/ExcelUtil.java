package cn.com.bgy.ifc.bgy.utils.excel;

import cn.com.bgy.ifc.bgy.utils.WebsiteUtil;
import cn.com.bgy.ifc.entity.model.OrgTestModel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:Excel表格工具类
 * @date: 2018-12-26 10:14
 **/
public class ExcelUtil {

    private static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    public static void exportExcel(String title, List<? extends BaseRowModel> list, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/octet-stream;charset=utf-8");
        response.addHeader("Pargam", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        // 清除response中的缓存
        response.reset();
        // 执行文件写入 设置导出Excel报表的响应文件名
        response.setHeader("content-Disposition", "attachment;filename=" + WebsiteUtil.getHeaderName(request, title) + ".xlsx");
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
            Sheet sheet1 = new Sheet(1, 0, OrgTestModel.class);
            sheet1.setSheetName("第一个sheet");
            writer.write(list, sheet1);
            writer.finish();
            // 获取输出流
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Excel执行导出出现异常：", e);
        } finally {
            // 关闭输出流，避免出现内存泄漏
            try {
                if (null != out) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readExcel(){

    }
}
