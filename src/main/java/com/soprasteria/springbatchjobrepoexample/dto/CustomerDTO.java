package com.soprasteria.springbatchjobrepoexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

	private Integer codiceCliente;

	private String nome;

	private String cognome;

	private String indirizzo;

	private String email;

	private String telefono;

}
