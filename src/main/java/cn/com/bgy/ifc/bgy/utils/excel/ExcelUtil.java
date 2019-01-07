package cn.com.bgy.ifc.bgy.utils.excel;

import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.WebsiteUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author: ZhangCheng
 * @description:Excel表格工具类
 * @date: 2018-12-26 10:14
 **/
public class ExcelUtil {

    private static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    public static void exportExcel(String title, HttpServletRequest request, HttpServletResponse response) {
        //设置响应头编码
        response.setCharacterEncoding("UTF-8");
        //区分不同的的类型的数据
        response.setContentType("multipart/form-data");
        // 清除response中的缓存
        response.reset();
        // 执行文件写入 设置导出Excel报表的响应文件名
        response.setHeader("content-Disposition",
                "attachment;filename=" + WebsiteUtil.getHeaderName(request,title)+".xlsx");
        ServletOutputStream out = null;
        try {
            // 获取输出流
            out = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Excel执行导出出现异常：",e);
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
}
