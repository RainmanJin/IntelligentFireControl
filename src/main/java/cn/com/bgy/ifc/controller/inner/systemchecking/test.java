package cn.com.bgy.ifc.controller.inner.systemchecking;

import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import com.alibaba.fastjson.JSONObject;

public class test {

    public static void main(String[] args) {
        try {
            String url = "http://101.37.16.25:9080/device/devices?page=1&size=10&sort=id&order=desc";
            JSONObject response = HttpHelper.httpGet(url, null);
            System.out.println(response);
        } catch (Exception e) {

        }
    }
}
