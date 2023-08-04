package com.userservice.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.user_service.dto.DepartmentDto;
import com.userservice.user_service.dto.ResponseDto;
import com.userservice.user_service.dto.UserDto;
import com.userservice.user_service.model.User;
import com.userservice.user_service.repository.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceIMPL implements UserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public ResponseDto getUser(Long id) {
		ResponseDto responseDto=new ResponseDto();
		User user=userRepo.findById(id).get();
		UserDto userDto=mapToUser(user);
		
		ResponseEntity<DepartmentDto>responseEntity=restTemplate
				.getForEntity("http://localhost:8080/api/departments/"+user.getDepartmentId(),
						DepartmentDto.class);
		
		DepartmentDto departmentDto=responseEntity.getBody();
		
		System.out.println(responseEntity.getStatusCode());
		responseDto.setUser(userDto);
		responseDto.setDepartment(departmentDto);
		
		return responseDto;
	}

	private UserDto mapToUser(User user) {
		UserDto userDto=new UserDto();
		userDto.setId(user.getId());
		userDto.setFisrtName(user.getFisrtName());
		userDto.setLastName(user.getLastName());
		userDto.setEmailId(user.getEmailId());
		return userDto;
	}
	
	
}
