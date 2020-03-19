package com.jane.dao.impl;

import com.jane.utils.ESClientFactory;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackageClasses =ESClientFactory.class)
//@PropertySource() 对用配置文件中的标签<context:property-placeholder location="classpath:config/resource.properties"/>
public class ESConfig {
    @Value("${elasticsearch.host}")
    private String host;
    @Value("${elasticsearch.port}")
    private Integer port;
    @Value("${http.schema}")
    private String schema;
    @Value("${elasticsearch.client.connectNum}")
    private Integer connectNums;
    @Value("${elasticsearch.client.connectPerRoute}")
    private Integer connectPerRoute;

    /***
     *   第一种方式 通过 Bean 注解
     *   singleton  spring 容器启动时创建
     *   prototype 获取时spring 容器才去创建
     *
     *  对于单实例的bean,可以设置initMethod,destroyMethod
     *  多实例的bean,spring容器只负责创建不负责管理bean
     *
     *   第二种方式  通过Bean  实现InitializingBean(定义初始化逻辑)
     *                       实现DisposableBean(定义销毁逻辑)
     *   第三种方式 通过JSR250 提供的注解
     *           @PostConstruct   @PreDestroy  作用到方法上表示该方法 初始化时,调用该方法|或者是销毁时调用的方法
     * @return
     */
    @Bean(initMethod = "init",destroyMethod = "close")
    public ESClientFactory getEsFactory(){
        return ESClientFactory.build(new HttpHost(host, port, schema), connectNums, connectPerRoute);
    }
    @Bean
    @Scope(value = "singleton")
    public RestHighLevelClient getClient(){
        return getEsFactory().getRestClient();
    }


}
