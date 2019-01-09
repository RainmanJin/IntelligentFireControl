package cn.com.bgy.ifc.entity.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2019-01-08 14:41
 **/
public class OrgTestModel extends BaseRowModel {

    @ExcelProperty(value = "机构编码" ,index = 0)
    private String code;

    @ExcelProperty(value = "机构名称",index = 1)
    private String name;

    @ExcelProperty(value = "公司介绍",index = 2)
    private String description;

    @ExcelProperty(value = "注册时间",index = 3)
    private Date registerTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
}
