package com.cts.calculatenetworth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class SwaggerUIController {
	@RequestMapping(value = "/")
	public RedirectView redirect() {
		return new RedirectView("/swagger-ui/");
	}
}
