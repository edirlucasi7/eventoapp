package com.eventoapp.eventoapp.api;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eventoapp.eventoapp.models.Evento;
import com.eventoapp.eventoapp.service.EventoService;

@Controller
@RequestMapping("/api/v1")
public class EventoController {
	
	@Autowired
	private EventoService service;
	
	@GetMapping("/eventos/cadastrarEventos")
	public String retornaEventos() {
		
		return "evento/formEvento";
	}
	
	@GetMapping("/eventos")
	public ModelAndView retornaEvento() {
		ModelAndView mv = service.getAllEvento();
		
		if(mv.isEmpty()) {
			return null;
		} else {
			return mv;
		}
	}
	
	@RequestMapping("/deletar")
	public String deletarEvento(Long id) {
		Boolean ok = service.deleteIdEvento(id);
		
		return ok ?
				"redirect:/api/v1/eventos" :
				"Não foi possível deletar";
	}
	
	@PostMapping("/eventos/cadastrarEventos")
	public String cadastraEvento(@Valid Evento evento, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/api/v1/eventos/cadastrarEventos";
		}
		service.postEvento(evento, result, attributes);
		attributes.addFlashAttribute("mensagem", "Adicionado com sucesso!");
		return "redirect:/api/v1/eventos/cadastrarEventos";
		
	}
	
	@GetMapping("/eventos/detalhesEvento/{id}")
	public ModelAndView detalhesEvento(@PathVariable("id") Long id) {
		ModelAndView mv = service.getIdEvento(id);
		
		if(mv.isEmpty()) {
			return null;
		}
		else {
			return mv;
		}
	}

	
}
