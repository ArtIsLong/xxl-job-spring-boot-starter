package com.github;

import com.xxl.job.core.executor.XxlJobExecutor;
import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 陈敏
 * @version XxlJobAutoConfiguration.java, v 1.1 2021/4/28 16:52 chenmin Exp $
 * Created on 2021/4/28
 * My blog： https://www.chenmin.info
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(XxlJobSpringExecutorProperties.class)
public class XxlJobAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public XxlJobExecutor xxlJobExecutor(XxlJobSpringExecutorProperties executorProperties) {
        log.info(">>>>>>>>>>> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(executorProperties.getAdmin().getAddresses());
        xxlJobSpringExecutor.setAppname(executorProperties.getExecutor().getAppname());
        xxlJobSpringExecutor.setAddress(executorProperties.getExecutor().getAddress());
        xxlJobSpringExecutor.setIp(executorProperties.getExecutor().getIp());
        xxlJobSpringExecutor.setPort(executorProperties.getExecutor().getPort());
        xxlJobSpringExecutor.setAccessToken(executorProperties.getAccessToken());
        xxlJobSpringExecutor.setLogPath(executorProperties.getExecutor().getLogPath());
        xxlJobSpringExecutor.setLogRetentionDays(executorProperties.getExecutor().getLogRetentionDays());

        return xxlJobSpringExecutor;
    }

}
