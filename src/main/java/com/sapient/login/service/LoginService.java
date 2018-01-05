package com.sapient.login.service;

import org.springframework.stereotype.Service;

import com.sapient.login.model.GenericResponse;

@FunctionalInterface
@Service
public interface LoginService {

	@SuppressWarnings("rawtypes")
	public GenericResponse validateUser(String user, String password);
}
