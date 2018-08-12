package com.github.sannalai.jaxrs.example.hateoas;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.github.sannalai.jaxrs.example.config.AppConfiguration;

@ApplicationScoped
public class LinkBuilder {
	private final String rootPath = "/demo-api-0.0.1-SNAPSHOT";
	@Inject
	@Named(AppConfiguration.Q_API_PATH)
	private Object apiPath;
	
	public Link createLink(String relName, String resourceName, String ...path) {
		return new Link(relName, rootPath + apiPath + "/" + resourceName + "/" + Stream.of(path).collect(Collectors.joining("/")));
	}
}
