package com.techday.techdaycarrefour.service;

import java.util.List;

import com.techday.techdaycarrefour.dto.UserDTO;
import com.techday.techdaycarrefour.entities.User;
import com.techday.techdaycarrefour.form.UserForm;
import com.techday.techdaycarrefour.form.UserUpdateForm;

public interface IUserService {
    /**
     * Cria um UserDTO e salva no banco de dados.
     * @param form - formulário referente aos dados para criação de um UserDTO no banco de dados.
     * @return - UserDTO recém-criado.
     */
    User create(UserForm form);

    /**
     * Retorna um UserDTO que está no banco de dados de acordo com seu login.
     * @param id - id do UserDTO que será exibido.
     * @return - UserDTO de acordo com o Id fornecido.
     */
    UserDTO get(String login);

    /**
     * Retorna todos os UserDTOs que estão no banco de dados.
     * @return - Uma lista os UserDTOs que estão salvas no DB.
     */
    List<UserDTO> getAll();
    
    /**
     * Busca os UserDTOs que estão no banco de dados pelo seu ID.
     * @return - Uma lista, os UserDTOs que estão salvas no DB.
     */
    UserDTO findById(Long id);

    /**
     * Atualiza o UserDTO.
     * @param id - id do User que será atualizado.
     * @param formUpdate - formulário referente aos dados necessários para atualização do UserDTO
     * no banco de dados.
     * @return - UserDTO recém-atualizado.
     */
    User update(Long id, UserUpdateForm formUpdate);

    /**
     * Deleta um User específico.
     * @param id - id do User que será removido.
     */
	void delete(Long id);
    
	List<UserDTO> getAll(String cep);



}
