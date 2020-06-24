package com.dave.controller;

import com.dave.bean.SystemConfig;
import com.dave.common.customannotation.LoginClear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/4 10:07
 * @Version 1.0.0
 * @Description
 **/

@RestController
@RequestMapping("/test")
@LoginClear("test")
public class TestController {
    @Autowired
    SystemConfig systemConfig;
    @RequestMapping("/test01")
    public String test01(){
        return systemConfig.getSystemTitle();
    }
}
