package com.github.sannalai.jaxrs.example.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class AppConfiguration {
	public static final String Q_API_PATH = "api-path";
	public static final String API_PATH = "/api";
	
	@Named(Q_API_PATH)
	@Produces
	public String apiPath() {
		return API_PATH;
	}
}
