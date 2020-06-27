package com.eventoapp.eventoapp.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity(name="evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String local;
	private String data;
	private String hora;
	
	@OneToMany
	private List<Convidado> convidados;
	
	public Evento() {
		
	}

	public Evento(Long id, String nome, String local, String data, String hora) {
		this.id = id;
		this.nome = nome;
		this.local = local;
		this.data = data;
		this.hora = hora;
	}

}
