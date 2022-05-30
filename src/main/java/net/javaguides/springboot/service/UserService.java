package net.javaguides.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.web.dto.UserRegistrationDto;

import java.util.Optional;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);

	User findByUserId(Long id);
}
