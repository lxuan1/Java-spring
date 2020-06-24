package com.dave.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/8 17:57
 * @Version 1.0.0
 * @Description
 **/
public final class ResponseJsonUtil {
    private ResponseJsonUtil() {

    }
    private static ObjectMapper objectMapper=new ObjectMapper() ;

    public static Map<String, Object> ok() {
        Map<String, Object> obj = new ConcurrentHashMap<>();
        obj.put("code", 1);
        obj.put("msg", "成功");
        return obj;
    }

    public static  Map<String, Object> ok(Object data) {
            Map<String, Object> obj = new ConcurrentHashMap<String, Object>();
            obj.put("code", 200);
            obj.put("msg", "成功");

            return obj;
    }

    /**
     *
     * @param msg
     * @param data
     * @return
     */
    public static Map<String, Object>  ok(String msg, Object data) {
        Map<String, Object> obj = null;
            obj = new ConcurrentHashMap<String, Object>();
            obj.put("code", 1);
            obj.put("msg", msg);
            obj.put("data", data);
            return obj;

    }

    /**
     * 错误
     *
     * @return json
     */
    public static Map<String, Object> fail() {
            Map<String, Object> obj = new HashMap<>();
            obj.put("code", 0);
            obj.put("msg", "错误");
           return obj;
    }

    /**
     * 失败
     *
     * @param code 状态码
     * @param msg  返回消息
     * @return String
     */
    public static Map<String, Object>  fail(int code, String msg) {
            Map<String, Object> obj = new ConcurrentHashMap<String, Object>();
            obj.put("code", code);
            obj.put("msg", msg);
            return obj;

    }

    /**
     * @param response  响应
     * @param msg 请求资源不存在
     */
    public static void ok(HttpServletResponse response,Object msg)  {
        //response.setCharacterEncoding("UTF-8");
        try {
            response.setStatus(200);
            PrintWriter printWriter=response.getWriter();
            printWriter.write(msg.toString());
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * @param response  响应
     * @param code 状态码
     * @param msg 请求资源不存在
     */
    public static void fail(HttpServletResponse response,int code,String msg)  {
        response.setCharacterEncoding("UTF-8");
        try {
            response.setStatus(code);
            response.setContentType("application/json");
            PrintWriter printWriter=response.getWriter();
            printWriter.write(objectMapper.writeValueAsString(ResponseJsonUtil.fail(code,msg)));
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
