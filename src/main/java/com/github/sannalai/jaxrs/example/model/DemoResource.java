package com.github.sannalai.jaxrs.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Diipa daapa
 * @author sasa
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DemoResource extends LinkResource {
	private String content;
}
