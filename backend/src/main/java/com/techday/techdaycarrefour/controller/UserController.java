package com.techday.techdaycarrefour.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techday.techdaycarrefour.dto.UserDTO;
import com.techday.techdaycarrefour.entities.User;
import com.techday.techdaycarrefour.form.UserForm;
import com.techday.techdaycarrefour.form.UserUpdateForm;
import com.techday.techdaycarrefour.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserServiceImpl service;

	@PostMapping
	public User create(@Valid @RequestBody UserForm form) {
		return service.create(form);
	}

	@GetMapping("/{id}")
	public UserDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	 @GetMapping
		public List<UserDTO> getAll(@RequestParam(value = "cep",required = false)String cep){
	    return service.getAll(cep);
	  }
	
	@PutMapping("/users/{id}")
	  public User update(@PathVariable("id") Long id, @RequestBody UserUpdateForm formUpdate) {
		
		return service.update(id, formUpdate);
		 
		
	}
	@DeleteMapping("/{id}")
	public User delete(@PathVariable Long id) {
	    User returnValue = new User();
	    service.delete(id);
	    return  returnValue;
	}
}
