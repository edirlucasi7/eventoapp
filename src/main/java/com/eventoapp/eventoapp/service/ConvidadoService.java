package com.eventoapp.eventoapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public String postConvidado(Long id, Convidado convidado) {
		Optional<Evento> opt = rep.findById(id);
		
		if(opt.isPresent()) {
		Evento evento = opt.get();
		convidado.setEvento(evento);
		cr.save(convidado);
		}
		
		
		return "Adicionado com sucesso";
	}
}
