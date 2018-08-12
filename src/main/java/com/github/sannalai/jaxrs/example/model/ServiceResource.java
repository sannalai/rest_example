package com.github.sannalai.jaxrs.example.model;

import java.util.List;

import com.github.sannalai.jaxrs.example.hateoas.Link;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ServiceResource extends LinkResource {
	private String name;
	private String version;
	
	public ServiceResource(String name, String version, List<Link> links) {
		this.name = name;
		this.version = version;
		setLinks(links);
	}
}
