package cn.com.bgy.ifc.service.interfaces.api.report;

import cn.com.bgy.ifc.entity.po.system.UserGroupItems;

public class test {

    public static void main(String[] args) {
        UserGroupItems group = new UserGroupItems();
        group.setProjectId(0l);
        for(int i=0;i<10;i++){
            if(group.getRegionId()==null&&group.getProjectId()==null)
                continue;
            System.out.println("0000");
        }
    }
}
