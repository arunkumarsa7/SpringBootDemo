package com.spring_boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Homepage controller.
 */
@Controller
public class IndexController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

}
