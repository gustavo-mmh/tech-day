package com.techday.techdaycarrefour.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {

	@NotEmpty(message = "Preencha o campo corretamente.")
	@Size(min = 2, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
	private String nome;

	@NotEmpty(message = "Preencha o campo corretamente.")
	@Email(message = "email inválido!")
	private String email;
	@NotEmpty(message = "Preencha o campo corretamente.")
	@Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
	private String login;

	@NotEmpty(message = "Preencha o campo corretamente.")
	@Size(min = 4, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
	private String password;

	@NotEmpty(message = "Preencha o campo corretamente.")
	@Pattern(regexp = "\\d{5}\\d{3}", message = "'${validatedValue}' é inválido!")
	private String cep;

}
