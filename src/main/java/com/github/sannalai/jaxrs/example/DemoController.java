package com.github.sannalai.jaxrs.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.sannalai.jaxrs.example.mapping.DemoMapper;
import com.github.sannalai.jaxrs.example.model.DemoResource;

@Path("demos")
@Produces(MediaType.APPLICATION_JSON)
public class DemoController {
	@Inject
	private DemoMapper demoMapper;
	
	@GET
	public List<DemoResource> getAllDemos() {
		Demo demo1 = new Demo("1", "demo1");
		Demo demo2 = new Demo("2", "demo2");
		
		return Arrays.asList(demo1, demo2)
				.stream()
				.map(demoMapper::toResource)
				.collect(Collectors.toList());
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public DemoResource createDemo(DemoResource demoResource) {
		Demo demo = demoMapper.toDomain(demoResource);
		// TODO: Persist
		demo.setId(String.valueOf((int)(Math.random() * 10000)));
		return demoMapper.toResource(demo);
	}
	
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public DemoResource updateDemo(@PathParam("id") String id, DemoResource demoResource) {
		Demo demo = demoMapper.toDomain(id, demoResource);
		return demoMapper.toResource(demo);
	}
	
	@GET
	@Path("{id}")
	public DemoResource getDemo(@PathParam("id") String id) {
		if(!Arrays.asList("1", "2").contains(id)) {
			throw new NotFoundException();
		}
		Demo demo = new Demo(id, "demo" + id);
		return demoMapper.toResource(demo);
	}
}
