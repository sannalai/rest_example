package com.github.sannalai.jaxrs.example.hateoas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Link {
	public static final String SELF_REL = "self";
	
	private String rel;
	private String ref;
}
