package com.github;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 陈敏
 * @version XxlJobSpringExecutorProperties.java, v 1.1 2021/4/28 16:55 chenmin Exp $
 * Created on 2021/4/28
 * My blog： https://www.chenmin.info
 */
@Data
@ConfigurationProperties(prefix = "xxl.job")
public class XxlJobSpringExecutorProperties {

    private AdminProperties admin;

    private String accessToken;

    private ExecutorProperties executor;

    @Data
    public static class AdminProperties {
        private String addresses;
    }

    @Data
    public static class ExecutorProperties {

        private String appname;

        private String address;

        private String ip;

        private int port;

        private String logPath;

        private int logRetentionDays;

    }
}
