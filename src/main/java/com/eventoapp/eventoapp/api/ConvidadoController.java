package com.eventoapp.eventoapp.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eventoapp.eventoapp.models.Convidado;
import com.eventoapp.eventoapp.models.Evento;
import com.eventoapp.eventoapp.repository.ConvidadoRepository;
import com.eventoapp.eventoapp.service.ConvidadoService;

@Controller
@RequestMapping("/api/v1")
public class ConvidadoController {

	@Autowired
	private ConvidadoService cs;
	
	@Autowired
	private ConvidadoRepository cr;
	
	@PostMapping("/eventos/detalhesEvento/{id}")
	public String cadastraConvidado(@PathVariable("id") Long id, @Valid Convidado convidado, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/api/v1/eventos/detalhesEvento/{id}";
		} 
		
		cs.postConvidado(id, convidado, result, attributes);
		attributes.addFlashAttribute("mensagem", "Adicionado com sucesso!");
		
		return "redirect:/api/v1/eventos/detalhesEvento/{id}";
	}
	
	@RequestMapping("/deletarConvidado")
	public String deletaConvidado(String rg) {
		Convidado convidado = cr.findByRg(rg);
		
		cr.delete(convidado);
		Evento evento = convidado.getEvento();
		long codigoLong = evento.getId();
		return "redirect:/api/v1/eventos/detalhesEvento/" + codigoLong;
		
	}
}
