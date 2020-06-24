package com.dave.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/4 11:51
 * @Version 1.0.0
 * @Description  系统配置相关
 **/
@Component
public class SystemConfig {

    @Value(value = "${system.config.title}")
    private String systemTitle;
    //@Value(value = "${}")
    private String projectName;

    public String getSystemTitle() {
        return systemTitle;
    }
}
