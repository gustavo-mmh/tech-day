package com.techday.techdaycarrefour.dto;

import com.techday.techdaycarrefour.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	private Long id;
	private String nome;
	private String email;
	private String login;
	private String cep;
	
	public UserDTO(User user) {
		id = user.getId();
		nome = user.getNome();
		email = user.getEmail();
		login = user.getLogin();
		cep = user.getCep();
	}
	
	
	
}
