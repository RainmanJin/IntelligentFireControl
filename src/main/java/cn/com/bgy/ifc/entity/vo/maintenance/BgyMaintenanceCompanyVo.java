package cn.com.bgy.ifc.entity.vo.maintenance;

import cn.com.bgy.ifc.entity.vo.common.BgyBaseVo;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台维保公司VO
 * @date: 2018-12-24 10:09
 **/
public class BgyMaintenanceCompanyVo extends BgyBaseVo {

    /**
     * 区域id
     */
    private Long areaId;
    /**
     * 公司名称
     */
    private String name;
    /**
     * 公司名称（简称）
     */
    private String shortName;
    /**
     * 联系方式
     */
    private String telephone;
    /**
     * 联系人
     */
    private String contact;

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
