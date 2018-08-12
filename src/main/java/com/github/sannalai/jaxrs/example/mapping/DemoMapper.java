package com.github.sannalai.jaxrs.example.mapping;

import java.util.Arrays;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.github.sannalai.jaxrs.example.Demo;
import com.github.sannalai.jaxrs.example.hateoas.Link;
import com.github.sannalai.jaxrs.example.hateoas.LinkBuilder;
import com.github.sannalai.jaxrs.example.model.DemoResource;

@ApplicationScoped
public class DemoMapper {
	@Inject
	private LinkBuilder linkBuilder;
	
	public DemoResource toResource(Demo demo) {
		DemoResource demoResource = new DemoResource();
		demoResource.setContent(demo.getContent());
		demoResource.setLinks(Arrays.asList(linkBuilder.createLink(Link.SELF_REL, "demos", demo.getId())));
		return demoResource;
	}

	public Demo toDomain(DemoResource demoResource) {
		return toDomain(null, demoResource);
	}
	
	public Demo toDomain(String id, DemoResource demoResource) {
		return new Demo(id, demoResource.getContent());
	}
}
