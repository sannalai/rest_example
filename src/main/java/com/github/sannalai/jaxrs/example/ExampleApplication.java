package com.github.sannalai.jaxrs.example;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.github.sannalai.jaxrs.example.config.AppConfiguration;

@ApplicationPath(AppConfiguration.API_PATH)
public class ExampleApplication extends Application {
}
