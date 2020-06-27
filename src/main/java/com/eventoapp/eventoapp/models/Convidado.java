package com.eventoapp.eventoapp.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Convidado {

	@Id
	private String rg;
	private String nomeConvidado;
	
	@ManyToOne
	private Evento evento;
	
	
}
