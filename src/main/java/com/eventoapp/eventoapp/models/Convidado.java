package com.eventoapp.eventoapp.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;


import lombok.Data;

@Entity
@Data
public class Convidado {

	@Id
	@NotEmpty
	private String rg;
	
	@NotEmpty
	private String nomeConvidado;
	
	@ManyToOne
	private Evento evento;
	
	
}
