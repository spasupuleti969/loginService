package com.sapient.login.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sapient.login.exception.UnAuthorizedException;
import com.sapient.login.model.ErrorVo;
import com.sapient.login.model.GenericResponse;
import com.sapient.login.service.LoginService;

@Component
public class LoinServiceImpl implements LoginService {

	@Value("${customerName}")
	public String userName;

	@Value("${password}")
	public String password;

	@Value("${productCode}")
	public String productCode;

	/**
	 * This method is to validate the Given user name and Password is matching with
	 * the user details configured in the application properties file.
	 * 
	 * If the user and password matches then the configured product code will be
	 * returned to the user.
	 * 
	 * If user and password doen't match with the configured values exception will
	 * be thrown
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public GenericResponse validateUser(String user, String pass) {

		GenericResponse response = new GenericResponse<>();

		try {

			//Condition check for user and password with configurable values
			if (userName.equals(user) && password.equals(pass)) {

				// Once the request is successfully validated then the formation of response
				// object
				response.setStatusCode("200");
				response.setStatusMessage("Sucess");
				response.setData(productCode);

			}

			//If it is failed to validated unautroized exception will be thrown
			else {

				throw new UnAuthorizedException("User is not authorized to access for the Given Id " + user);
			}

		}

		catch (UnAuthorizedException exception) {
			
			//Formation of error Vo

			response.setStatusCode("401");
			response.setStatusMessage("UnAuthorized");

			ErrorVo error = new ErrorVo();
			error.setErrorCode("401");
			error.setErrorMessage(exception.getMessage());

			response.setErrors(error);

		}

		return response;
	}

}
