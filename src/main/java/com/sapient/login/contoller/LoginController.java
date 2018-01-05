package com.sapient.login.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.login.model.GenericResponse;
import com.sapient.login.service.LoginService;

@RestController
@RequestMapping(value = "/userLogin")
public class LoginController {

	@Autowired
	public LoginService loginService;

	/**
	 * Controller to receive Get request from the system to check for the user
	 * validation
	 * 
	 * @param user
	 * @param password
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GetMapping
	@RequestMapping(value = "/login")
	public GenericResponse<Object> isValidUser(@RequestParam String user, @RequestParam String password) {

		return loginService.validateUser(user, password);
	}

}
