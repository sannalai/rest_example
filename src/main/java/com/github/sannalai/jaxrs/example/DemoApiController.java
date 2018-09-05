package com.github.sannalai.jaxrs.example;

import java.util.Arrays;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.sannalai.jaxrs.example.hateoas.LinkBuilder;
import com.github.sannalai.jaxrs.example.model.ServiceResource;

import io.swagger.annotations.Api;

@Api("This is the API root")
@Path("")
@Produces(MediaType.APPLICATION_JSON)
public class DemoApiController {
	@Inject
	private LinkBuilder linkBuilder;

	@GET
	public ServiceResource getApiLinks() {
		return new ServiceResource(
				"DemoService",
				"1.0.0-SNAPSHOT",
				Arrays.asList(
				linkBuilder.createLink("demos", "demos")
				));
	}
}
