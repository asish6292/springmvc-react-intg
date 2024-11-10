package com.akm.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FrontendController {

	@GetMapping(value = { "/", "/{x:[\\w\\-]+}", "/**/{x:[\\w\\-]+}" })
	@ResponseBody
	public ResponseEntity<Resource> index() {
		ClassPathResource resource = new ClassPathResource("/static/index.html");
		return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(resource);
	}
}
