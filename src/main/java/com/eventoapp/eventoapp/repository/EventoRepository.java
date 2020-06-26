package com.eventoapp.eventoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventoapp.eventoapp.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{

}
