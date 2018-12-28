package cn.com.bgy.ifc.controller;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author huxin
 * @Date 2018/12/25 9:59
 * @Description excel 测试
 **/

public class ExcelDemo {


    /*public static void main( String[] args ) {
        //创建workbook
        SXSSFWorkbook wb = new SXSSFWorkbook();

        //创建sheet
        SXSSFSheet sheet = (SXSSFSheet) wb.createSheet("消防设备导入模板");
        //设置列宽
        sheet.setColumnWidth(0, 20*256);//第1列
        sheet.setColumnWidth(1, 30*256);//第2列
        sheet.setColumnWidth(2, 30*256);//第3列
        sheet.setColumnWidth(3, 50*256);//第4列
        sheet.setColumnWidth(4, 30*256);//第5列
        sheet.setColumnWidth(5, 20*256);//第6列
        sheet.setColumnWidth(6, 20*256);//第7列
        sheet.setColumnWidth(7, 20*256);//第8列
        sheet.setColumnWidth(8, 20*256);//第9列
        sheet.setColumnWidth(9, 20*256);//第10列
        sheet.setColumnWidth(10, 20*256);//第11列
        sheet.setColumnWidth(11, 20*256);//第12列
        sheet.setColumnWidth(12, 20*256);//第13列

        //创建行row:建立固定的三行格式
        Row row = sheet.createRow(0);
        Row row1 = sheet.createRow(1);
        Row row2 = sheet.createRow(2);
        Row row3 = sheet.createRow(3);
        row.setHeightInPoints(30f);
        row1.setHeightInPoints(30f);
        row2.setHeightInPoints(30f);
        row3.setHeightInPoints(30f);

        //标题行字体样式
        Font font = wb.createFont();
        font.setFontName("新宋体");
        //字体加粗
        font.setBold(true);
        CellStyle style = wb.createCellStyle();
        //水平居中
        style.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFont(font);
        style.setBorderBottom(BorderStyle.THIN); //下边框
        style.setBorderLeft(BorderStyle.THIN);//左边框
        style.setBorderTop(BorderStyle.THIN);//上边框
        style.setBorderRight(BorderStyle.THIN);//右边框


        //样板数据字体样式
        Font font1 = wb.createFont();
        font1.setFontName("新宋体");
        //字体颜色  红色
        font1.setColor(Font.COLOR_RED);
        CellStyle style1 = wb.createCellStyle();
        style1.setAlignment(HorizontalAlignment.CENTER);
        style1.setVerticalAlignment(VerticalAlignment.CENTER);
        style1.setFont(font1);
        style1.setBorderBottom(BorderStyle.THIN); //下边框
        style1.setBorderLeft(BorderStyle.THIN);//左边框
        style1.setBorderTop(BorderStyle.THIN);//上边框
        style1.setBorderRight(BorderStyle.THIN);//右边框

        //数据字体样式
        Font font2 = wb.createFont();
        font2.setFontName("新宋体");
        CellStyle style2 = wb.createCellStyle();
        style2.setAlignment(HorizontalAlignment.CENTER);
        style2.setVerticalAlignment(VerticalAlignment.CENTER);
        style2.setFont(font2);
        style2.setBorderBottom(BorderStyle.THIN); //下边框
        style2.setBorderLeft(BorderStyle.THIN);//左边框
        style2.setBorderTop(BorderStyle.THIN);//上边框
        style2.setBorderRight(BorderStyle.THIN);//右边框

        //样板数据前4列字体样式
        Font font3 = wb.createFont();
        font3.setFontName("新宋体");
        //字体颜色  红色
        font3.setColor(Font.COLOR_RED);
        CellStyle style3 = wb.createCellStyle();
        style3.setAlignment(HorizontalAlignment.CENTER);
        style3.setVerticalAlignment(VerticalAlignment.CENTER);
        style3.setFont(font3);
        style3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style3.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        //填充前置颜色
        style3.setBorderBottom(BorderStyle.THIN); //下边框
        style3.setBorderLeft(BorderStyle.THIN);//左边框
        style3.setBorderTop(BorderStyle.THIN);//上边框
        style3.setBorderRight(BorderStyle.THIN);//右边框


        //真实数据前4列字体样式
        Font font4 = wb.createFont();
        font4.setFontName("新宋体");
        CellStyle style4 = wb.createCellStyle();
        style4.setAlignment(HorizontalAlignment.CENTER);
        style4.setVerticalAlignment(VerticalAlignment.CENTER);
        style4.setFont(font4);
        //设置背景颜色
        style4.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style4.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        style4.setBorderBottom(BorderStyle.THIN); //下边框
        style4.setBorderLeft(BorderStyle.THIN);//左边框
        style4.setBorderTop(BorderStyle.THIN);//上边框
        style4.setBorderRight(BorderStyle.THIN);//右边框

        //创建单元格

        //标题行数据名字
         String [] cellName ={"地址编码","所属区域*","所属项目","详细地址",
                                "设备品牌","设备型号","设备类型","设备名称",
                                "质保年份*","投入使用时间*","设备状态*","用户辅助编码","设备接口编码"};
        Cell cell = null;
        for (int i = 0; i <cellName.length ; i++) {
            cell = row1.createCell(i);
            cell.setCellValue(cellName[i]);
            cell.setCellStyle(style);
        }
        //样板数据行
        String [] dataName = {"1111","顺碧区域","顺德碧桂园芷兰湾"," 芷兰湾新碧路芷兰湾X街X座芷兰湾X街X座X层X#电梯机房",
                "火灾报警控制器（联动型）","JB-QBL-TX3002","火灾报警器", "JHDS-45",
                "2","2018-12-25","正常","sjdk54645","454545asdsd"};
        for (int i = 0; i <dataName.length ; i++) {
            cell = row2.createCell(i);
            cell.setCellValue(dataName[i]);
            if(i<4){
                cell.setCellStyle(style3);
                continue;
            }
            cell.setCellStyle(style1);
        }
        //真实数据

        String [] ceshi = {"1111","顺碧区域","顺德碧桂园芷兰湾"," 芷兰湾新碧路芷兰湾X街X座芷兰湾X街X座X层X#电梯机房",
                "火灾报警控制器（联动型）","JB-QBL-TX3002","火灾报警器", "JHDS-45",
                "2","2018-12-25","正常","sjdk54645","454545asdsd"};
        for (int i = 0; i < ceshi.length; i++) {
            cell = row3.createCell(i);
            cell.setCellValue(ceshi[i]);
            if(i<4){
                cell.setCellStyle(style3);
                continue;
            }
            cell.setCellStyle(style2);
        }
        //Excel下拉框
        DataValidationHelper helper = sheet.getDataValidationHelper();
        //参数表示 第3行开始到10行终止 第4列开始到第4列终止
        CellRangeAddressList addressList = new CellRangeAddressList(3, 10, 4, 4);
        //下拉框列表内容
        String[] list={"无效人名,方言障碍,作废,其它"};
        DataValidationConstraint constraint = helper.createExplicitListConstraint(list);
        DataValidation dataValidation = helper.createValidation(constraint, addressList);
        sheet.addValidationData(dataValidation);





        //将生成excel文件保存到指定路径下
        try {
            FileOutputStream fout = new FileOutputStream("消防设备导入模板.xlsx");
            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Excel文件生成成功...");
    }
*/

}
