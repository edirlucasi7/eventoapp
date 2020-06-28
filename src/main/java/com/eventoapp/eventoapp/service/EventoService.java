package com.eventoapp.eventoapp.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	public Evento postEvento(@Valid Evento evento, BindingResult result, RedirectAttributes attributes) {
		return rep.save(evento);
	}
	
	public void updateEvento(Long id, Evento evento) {
		Optional<Evento> opt = rep.findById(id);
		
		if(opt.isPresent()) {
			Evento db = opt.get();
			db.setNome(evento.getNome());
			db.setLocal(evento.getLocal());
			db.setData(evento.getData());
			db.setHora(evento.getHora());
			
			rep.save(db);
		}
	}
	
	public boolean deleteIdEvento(Long id) {
		Optional<Evento> evento = rep.findById(id);
		
		if(evento.isPresent()) {
			Evento ev = evento.get();
			rep.delete(ev);
			return true;
		} else {
			return false;
		}
		
	}
}
