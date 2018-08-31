package com.github.sannalai.jaxrs.example;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.github.sannalai.jaxrs.example.config.AppConfiguration;

import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath(AppConfiguration.API_PATH)
public class ExampleApplication extends Application {
	public ExampleApplication() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath(AppConfiguration.API_PATH);
        beanConfig.setResourcePackage("com.github.sannalai.jaxrs.example, com.github.sannalai.jaxrs.example.model.DemoResource");
        beanConfig.setScan(true);
    }
}
