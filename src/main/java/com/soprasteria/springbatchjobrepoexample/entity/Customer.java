package com.soprasteria.springbatchjobrepoexample.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	@Id
	private Integer codiceCliente;
	
	private String nome;
	
	private String cognome;
	
	private String indirizzo;
	
	private String email;
	
	private String telefono;

}
