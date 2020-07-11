package com.eventoapp.eventoapp.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping("/eventos/editarEventos/{id}")
	public ModelAndView updateForm(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("evento/atualizaEvento");		
		
		Evento evento = service.getEvento(id);
		mv.addObject("evento", evento);
		
		return mv;
	}
	
	@RequestMapping(value = "/eventos/editarEvento/{id}", method = RequestMethod.POST)
	public String atualizarEvento(@PathVariable("id") Long id, @Valid @ModelAttribute("evento") Evento evento, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/api/v1/eventos/cadastrarEventos";
		}
		
		service.putEvento(id, evento, result, attributes);
		attributes.addFlashAttribute("mensagem", "Atualizado com sucesso!");
		return "redirect:/api/v1/eventos/cadastrarEventos";
	}

	@RequestMapping(value = "/eventos/cadastrarEventos", method = RequestMethod.POST)
	public String cadastraEvento(@Valid @ModelAttribute("evento") Evento evento, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/api/v1/eventos/cadastrarEventos";
		}

		service.postEvento(evento, result, attributes);
		attributes.addFlashAttribute("mensagem", "Adicionado com sucesso!");
		return "redirect:/api/v1/eventos/cadastrarEventos";
		
	}
	
	@RequestMapping("/deletar")
	public String deletarEvento(Long id) {
		Boolean ok = service.deleteIdEvento(id);
		
		return ok ?
				"redirect:/api/v1/eventos" :
				"Não foi possível deletar";
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
