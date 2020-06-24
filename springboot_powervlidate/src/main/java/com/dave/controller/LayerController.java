package com.dave.controller;

import com.dave.common.customannotation.LoginClear;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/22 15:04
 * @Version 1.0.0
 * @Description
 **/
@Controller
@RequestMapping("/layer")
@LoginClear
public class LayerController {

    /**
     * 菜单模板主页面
     * @return 页面路径
     */
    @RequestMapping("/")
    public String layer(HttpServletRequest request){
        return "layer.html";
    }
}

