package com.eventoapp.eventoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.eventoapp.eventoapp.models.Evento;
import com.eventoapp.eventoapp.repository.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository rep;
	
	public ModelAndView getAllEvento() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos = rep.findAll();
		mv.addObject("eventos", eventos);
		return mv;
	}
	
	public Evento postEvento(Evento evento) {
		return rep.save(evento);
	}
}
