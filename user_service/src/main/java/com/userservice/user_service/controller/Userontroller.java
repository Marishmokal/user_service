package com.userservice.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.user_service.dto.ResponseDto;
import com.userservice.user_service.model.User;
import com.userservice.user_service.service.UserService;

@RestController
@RequestMapping("api/users")
public class Userontroller {

	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<User>saveUser(@RequestBody User user)
	{
		User createUser= userService.saveUser(user);
		return new ResponseEntity<>(createUser,HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ResponseDto>getUser(@PathVariable("id")Long id)
	{
		ResponseDto responseDto= userService.getUser(id);
		return ResponseEntity.ok(responseDto);
	}
}
