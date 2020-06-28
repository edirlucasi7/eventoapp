package com.eventoapp.eventoapp.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eventoapp.eventoapp.models.Convidado;
import com.eventoapp.eventoapp.models.Evento;
import com.eventoapp.eventoapp.repository.ConvidadoRepository;
import com.eventoapp.eventoapp.repository.EventoRepository;

@Service
public class ConvidadoService {
	
	@Autowired
	private ConvidadoRepository cr;
	
	@Autowired
	private EventoRepository rep;

	public void postConvidado(Long id,  @Valid Convidado convidado, BindingResult result, RedirectAttributes attributes) {
		Optional<Evento> opt = rep.findById(id);

		if(opt.isPresent()) {
		Evento evento = opt.get();
		convidado.setEvento(evento);
		cr.save(convidado);
		}
		
	}
	
}
