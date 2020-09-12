package com.eventoapp.eventoapp.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eventoapp.eventoapp.models.Convidado;
import com.eventoapp.eventoapp.models.Evento;
import com.eventoapp.eventoapp.repository.ConvidadoRepository;
import com.eventoapp.eventoapp.service.ConvidadoService;

@Controller
@RequestMapping("/api/v1")
//@CrossOrigin(origins="*")
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
	
	@RequestMapping("/eventos/editarConvidado/{rg}")
	public ModelAndView updateFormConvidado(@PathVariable("rg") String rg) {
		ModelAndView mv = new ModelAndView("convidado/atualizaConvidado");
		
		Convidado convidado = cr.findByRg(rg);
		mv.addObject("convidado", convidado);
	
		return mv;
	}
	
	@RequestMapping(value = "/eventos/editarConvidado/{rg}", method = RequestMethod.POST)
	public String atualizarConvidado(@PathVariable("rg") String rg, @Valid Convidado convidado, BindingResult result, RedirectAttributes attributes) {

		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Preencha o campo!");
			return "redirect:/api/v1/eventos/editarConvidado/{rg}";
		}
		
		cs.putConvidado(rg, convidado, result, attributes);
		attributes.addFlashAttribute("mensagem", "Convidado atualizado com sucesso!");
		return "redirect:/api/v1/eventos";
		
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
