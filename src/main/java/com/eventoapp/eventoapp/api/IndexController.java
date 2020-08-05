package com.eventoapp.eventoapp.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
	
	@RequestMapping("/api/v1")
	public String index() {
		return "index";
	}
	
	@GetMapping("/userInfo")
	public UserDetails userInfo(@AuthenticationPrincipal UserDetails usuario) {
		return usuario;
	}
	
}
