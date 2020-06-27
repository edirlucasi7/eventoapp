package com.eventoapp.eventoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventoapp.eventoapp.models.Convidado;
import com.eventoapp.eventoapp.models.Evento;

public interface ConvidadoRepository extends JpaRepository<Convidado, String>{
	Iterable<Convidado> findByEvento(Evento evento);
}
