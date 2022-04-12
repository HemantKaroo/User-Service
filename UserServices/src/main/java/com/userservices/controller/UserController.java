package com.userservices.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userservices.constants.ServiceConstants;
import com.userservices.dto.SearchUserDTO;
import com.userservices.dto.UserDTO;
import com.userservices.service.UserService;

@RestController
@RequestMapping("/userservice")
public class UserController {

	@Autowired
	UserService userServices;

	@PostMapping("/saveUser")
	@ResponseBody
	public ResponseEntity<String> saveUser(@Valid @RequestBody UserDTO userDto) throws JsonProcessingException {
		String userSave = userServices.saveUser(userDto);
		if (null != userSave && !userSave.isEmpty()) {
			return new ResponseEntity<>(userSave, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ServiceConstants.Request_Fail, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/userUpdate")
	@ResponseBody
	public ResponseEntity<String> updateUser(@Valid @RequestBody UserDTO userDto) throws JsonProcessingException {
		String userUpdate = userServices.updateUser(userDto);
		if (null != userUpdate && !userUpdate.isEmpty()) {
			return new ResponseEntity<>(userUpdate, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ServiceConstants.Request_Fail, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<String> getUserById(@PathVariable(value = "userId") long userId)
			throws JsonProcessingException {
		String userData = userServices.getUserById(userId);
		if (null != userData && !userData.isEmpty()) {
			return new ResponseEntity<>(userData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ServiceConstants.Request_Fail, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/getAllUser")
	@ResponseBody
	public ResponseEntity<String> getAllUsers(@RequestBody SearchUserDTO searchUserDto) throws JsonProcessingException {
		String users = userServices.getUserDetails(searchUserDto.getSearchUser());
		if (null != users && !users.isEmpty()) {
			return new ResponseEntity<>(users, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ServiceConstants.Request_Fail, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteUserById/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable(value = "userId") long userId)
			throws JsonProcessingException {
		String deleteUserId = userServices.deleteUserById(userId);
		if (null != deleteUserId && !deleteUserId.isEmpty()) {
			return new ResponseEntity<>(deleteUserId, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ServiceConstants.Request_Fail, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
