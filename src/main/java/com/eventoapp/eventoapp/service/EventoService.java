package com.eventoapp.eventoapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.eventoapp.eventoapp.models.Convidado;
import com.eventoapp.eventoapp.models.Evento;
import com.eventoapp.eventoapp.repository.ConvidadoRepository;
import com.eventoapp.eventoapp.repository.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository rep;
	
	@Autowired
	private ConvidadoRepository cr;
	
	public ModelAndView getAllEvento() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos = rep.findAll();
		mv.addObject("eventos", eventos);
		return mv;
	}
	
	public ModelAndView getIdEvento(Long id) {
		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
		Optional<Evento> opt = rep.findById(id);
		if(opt.isPresent()) {
			Evento evento = opt.get();
			mv.addObject("evento", evento);
			
			Iterable<Convidado> convidados = cr.findByEvento(evento);
			mv.addObject("convidados", convidados);
			
			return mv;
		} else {
			return null;
		}
		
	}
	
	public Evento postEvento(Evento evento) {
		return rep.save(evento);
	}
}
