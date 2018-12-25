package cn.com.bgy.ifc.entity.po.repair;

public class MaintenanceOrderWithBLOBs extends MaintenanceOrder {
    private String sign;

    private String remark;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}