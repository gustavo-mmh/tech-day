package com.techday.techdaycarrefour.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techday.techdaycarrefour.dto.UserDTO;
import com.techday.techdaycarrefour.form.UserForm;
import com.techday.techdaycarrefour.service.exception.ServiceException;
import com.techday.techdaycarrefour.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserServiceImpl service;

	@PostMapping
	public ResponseEntity<UserDTO> create(@RequestBody UserForm form) {
		try {
			UserDTO obj = service.create(form);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).body(obj);	
		}catch (ServiceException e) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
	}

	@GetMapping("/{id}")
	public UserDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	 @GetMapping
		public List<UserDTO> getAll(@RequestParam(value = "cep",required = false)String cep){
	    return service.getAll(cep);
	  }
	
	@PutMapping("/{id}")
	  public UserDTO update(@PathVariable Long id, @RequestBody UserForm formUpdate) {
		return service.update(id, formUpdate);
		 
		
	}
	@DeleteMapping("/{id}")
	public UserDTO delete(@PathVariable Long id) {
	    service.delete(id);
		return null;
	}
}
