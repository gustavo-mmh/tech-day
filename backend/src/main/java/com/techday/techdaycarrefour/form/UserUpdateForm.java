package com.techday.techdaycarrefour.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateForm {
	private String nome; 
	private String email; 
	private String login; 
	private String password; 
	private String cep; 
}
