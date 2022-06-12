package com.techday.techdaycarrefour.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.service.spi.ServiceException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techday.techdaycarrefour.dto.UserDTO;
import com.techday.techdaycarrefour.entities.User;
import com.techday.techdaycarrefour.form.UserForm;
import com.techday.techdaycarrefour.repositories.UserRepository;
import com.techday.techdaycarrefour.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public UserDTO create(@NotNull UserForm form) {
		User user = repository.findByLogin(form.getLogin());
		if (user != null) {
			throw new ServiceException("Login já existe");
		}
		User obj = new User();

		obj.setNome(form.getNome());
		obj.setEmail(form.getEmail());
		obj.setLogin(form.getLogin());
		obj.setPassword(passwordEncoder.encode(form.getPassword()));
		obj.setCep(form.getCep());
		obj = repository.save(obj);
		return new UserDTO(obj);
	}

	@Transactional(readOnly = true)
	@Override
	public UserDTO findById(Long id) {
		User userEntity = repository.findById(id).get();
		return new UserDTO(userEntity);
	}

	@Transactional
	@Override
	public UserDTO update(Long id, UserForm formUpdate) {
		Optional<User> userData = repository.findById(id);
		if (userData.isPresent()) {
			User obj = userData.get();
			obj.setNome(formUpdate.getNome());
			obj.setEmail(formUpdate.getEmail());
			obj.setLogin(formUpdate.getLogin());
			obj.setPassword(passwordEncoder.encode(formUpdate.getPassword()));
			obj.setCep(formUpdate.getCep());
			obj = repository.save(obj);
			return new UserDTO(obj);
		} else {
			throw new ServiceException("Usuário não existe!");
		}

	}

	@Transactional(readOnly = true)
	@Override
	public List<UserDTO> getAll(String cep) {
		if (cep == null) {
			List<User> list = repository.findAll();
			return list.stream().map(UserDTO::new).collect(Collectors.toList());
		} else {
			List<User> listuserbycep = repository.findByCep(cep);
			return listuserbycep.stream().map(UserDTO::new).collect(Collectors.toList());
		}
	}

	@Override
	public void delete(Long id) {
		Optional<User> userData = repository.findById(id);
		if (userData.isPresent()) {
		repository.deleteById(id);
		} else {
			throw new ServiceException("Usuário não existe!");
		}
	}

}
