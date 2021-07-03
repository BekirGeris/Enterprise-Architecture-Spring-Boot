package com.begers.northwind.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.begers.northwind.business.abstracts.UserService;
import com.begers.northwind.core.entities.User;
import com.begers.northwind.core.utilities.result.ErrorDataResult;

@RestController
@RequestMapping("/api/users")
public class UsersControllor {
	
	private UserService userService;

	@Autowired
	public UsersControllor(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user) {
		return ResponseEntity.ok(this.userService.add(user));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> hardleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationError = new HashMap<String, String>();
		
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationError.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationError, "Dogrulama Hatalari");
		return errors;
	}
}



