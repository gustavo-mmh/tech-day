package com.techday.techdaycarrefour.service.impl;

import java.util.List;
import java.util.Optional;

import org.aspectj.apache.bcel.classfile.Module.Uses;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techday.techdaycarrefour.dto.UserDTO;
import com.techday.techdaycarrefour.entities.User;
import com.techday.techdaycarrefour.form.UserForm;
import com.techday.techdaycarrefour.form.UserUpdateForm;
import com.techday.techdaycarrefour.repositories.UserRepository;
import com.techday.techdaycarrefour.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User create(UserForm form) {
		User user = new User();

		user.setNome(form.getNome());
		user.setEmail(form.getEmail());
		user.setLogin(form.getLogin());
		user.setPassword(form.getPassword());
		user.setCep(form.getCep());

		return repository.save(user);
	}

	@Transactional(readOnly = true)
	@Override
	public UserDTO findById(Long id) {
		User userEntity = repository.findById(id).get();
		UserDTO dto = new UserDTO(userEntity);
		return dto;
	}

//	@Override
//	public UserDTO get(String login) {
//
//		List<User> userEntity = repository.findByLogin(login);
//
//		if (userEntity == null) {
//			throw new UsernameNotFoundException(login);
//		}
//		UserDTO returnValue = new UserDTO();
//		BeanUtils.copyProperties(userEntity, returnValue);
//
//		return returnValue;
//
//	}

	@Transactional
	@Override
	public User update(Long id, UserUpdateForm formUpdate) {
		Optional<User> userData = repository.findById(id);
		if (userData != null) {
			User user = userData.get();
			user.setNome(formUpdate.getNome());
			user.setEmail(formUpdate.getEmail());
			user.setLogin(formUpdate.getLogin());
			user.setPassword(formUpdate.getPassword());
			user.setCep(formUpdate.getCep());
			return repository.save(user);
		} else {
			return null;
		}

	}


	@Override
	public List<UserDTO> getAll(String cep) {
		return getAll(cep);
	}

	@Override
	public List<UserDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserDTO get(String login) {
		// TODO Auto-generated method stub
		return null;
	}


}
