package com.github.sannalai.jaxrs.example.model;

import java.util.List;

import com.github.sannalai.jaxrs.example.hateoas.Link;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LinkResource {
	private List<Link> links;
}
