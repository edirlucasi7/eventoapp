package com.eventoapp.eventoapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eventoapp.eventoapp.models.Convidado;
import com.eventoapp.eventoapp.service.ConvidadoService;

@Controller
@RequestMapping("/api/v1")
public class ConvidadoController {

	@Autowired
	private ConvidadoService cs;
	
	@PostMapping("/detalhesEvento/{id}")
	public String CadastraConvidado(@PathVariable("id") Long id, Convidado convidado) {
		cs.postConvidado(id, convidado);
		
		return "redirect:/api/v1/detalhesEvento/{id}";
	}
}
