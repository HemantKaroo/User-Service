package com.userservices.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userservices.dto.UserDTO;

@Service
public interface UserService {

	public String saveUser(UserDTO userDto) throws JsonProcessingException;

	public String updateUser(UserDTO userDto) throws JsonProcessingException;

	public String deleteUserById(long userId) throws JsonProcessingException;

	public String getUserDetails(String searchUser) throws JsonProcessingException;

	public boolean isValidUserEmail(UserDTO userDto);

	public String getUserById(long userId) throws JsonProcessingException;

}
