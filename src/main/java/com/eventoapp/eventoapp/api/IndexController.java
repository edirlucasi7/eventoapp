package com.eventoapp.eventoapp.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/api/v1")
	public String index() {
		return "index";
	}
}
