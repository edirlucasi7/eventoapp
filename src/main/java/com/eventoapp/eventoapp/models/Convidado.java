package com.eventoapp.eventoapp.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;


import lombok.Data;

@Entity
@Data
public class Convidado {

	@Id
	@NotBlank
	private String rg;
	
	@NotBlank
	private String nomeConvidado;
	
	@ManyToOne
	private Evento evento;
	
	
}
