package cn.com.bgy.ifc.entity.po.basic;

public class SystemOperationLogWithBLOBs extends SystemOperationLog {
    private String operatorContent;

    private String operatorDescribe;

    public String getOperatorContent() {
        return operatorContent;
    }

    public void setOperatorContent(String operatorContent) {
        this.operatorContent = operatorContent;
    }

    public String getOperatorDescribe() {
        return operatorDescribe;
    }

    public void setOperatorDescribe(String operatorDescribe) {
        this.operatorDescribe = operatorDescribe;
    }
}