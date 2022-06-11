package com.techday.techdaycarrefour.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techday.techdaycarrefour.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByCep(String cep);

	User findByLogin(String login);

}
