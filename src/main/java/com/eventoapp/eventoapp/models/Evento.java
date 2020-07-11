package com.eventoapp.eventoapp.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity(name="evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nome;
	@NotEmpty
	private String local;
	@NotEmpty
	private String data;
	@NotEmpty
	private String hora;
	
	@OneToMany( mappedBy="evento", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Convidado> convidados;
	
	public Evento() {
		
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nome=" + nome + ", local=" + local + ", data=" + data + ", hora=" + hora + "]";
	}
	
	
	

}
