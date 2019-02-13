package cn.com.bgy.onenet.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ZhangCheng
 * @description:oneNet平台设备管理
 * @date: 2019-02-12 14:38
 **/
@RestController
@RequestMapping("/oneNet/device")
public class OneNetDeviceController {


    @PostMapping("createData")
    public void createData(){

    }
}
