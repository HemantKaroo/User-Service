package com.userservices.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.userservices.dto.UserDTO;
import com.userservices.model.Role;
import com.userservices.model.User;
import com.userservices.repository.RoleRepository;
import com.userservices.repository.UserRepository;
import com.userservices.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	@Override
	public String saveUser(UserDTO userDto) throws JsonProcessingException {
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setMiddleName(userDto.getMiddleName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAddressOne(userDto.getAddressOne());
		user.setAddressTwo(userDto.getAddressTwo());
		user.setCity(userDto.getCity());
		user.setState(userDto.getState());
		user.setPincode(userDto.getPincode());
		user.setCountry(userDto.getCountry());
		user.setPhoneNumber(userDto.getPhoneNumber());
		List<Role> roleList = roleRepository.findByRoleNames(userDto.getRoles());
		user.setRoles(roleList);
		ObjectMapper objectMapper = new ObjectMapper();
		String userSave = objectMapper.writeValueAsString(userRepository.save(user));
		return userSave;
	}

	@Override
	public String updateUser(UserDTO userDto) throws JsonProcessingException {
		long userId = userDto.getUserId();
		String userUpdate = "";
		Optional<User> userOptional = userRepository.findById(userId);
		if (userOptional.isPresent()) {
			User userExist = userOptional.get();
			userExist.setFirstName(userDto.getFirstName());
			userExist.setMiddleName(userDto.getMiddleName());
			userExist.setLastName(userDto.getLastName());
			userExist.setEmail(userDto.getEmail());
			userExist.setPassword(userDto.getPassword());
			userExist.setAddressOne(userDto.getAddressOne());
			userExist.setAddressTwo(userDto.getAddressTwo());
			userExist.setCity(userDto.getCity());
			userExist.setState(userDto.getState());
			userExist.setPincode(userDto.getPincode());
			userExist.setCountry(userDto.getCountry());
			userExist.setPhoneNumber(userDto.getPhoneNumber());
			List<Role> rolesExist = roleRepository.findByRoleNames(userDto.getRoles());
			userExist.setRoles(rolesExist);
			ObjectMapper objectMapper = new ObjectMapper();
			userUpdate = objectMapper.writeValueAsString(userRepository.save(userExist));
		}
		return userUpdate;
	}

	@Override
	public String getUserById(long userId) throws JsonProcessingException {
		String userData = "";
		Optional<User> userOptional = userRepository.findById(userId);
		if (userOptional.isPresent()) {
			ObjectMapper objectMapper = new ObjectMapper();
			userData = objectMapper.writeValueAsString(userOptional.get());
		}
		return userData;
	}

	@Override
	public String getUserDetails(String searchUsers) throws JsonProcessingException {
		String users = "";
		List<User> userList = userRepository.searchUsers(searchUsers);
		if (!userList.isEmpty()) {
			ObjectMapper objectMapper = new ObjectMapper();
			users = objectMapper.writeValueAsString(userList);
		}
		return users;
	}

	@Override
	public String deleteUserById(long userId) throws JsonProcessingException {
		String deleteUserId = "";
		deleteUserId = String.valueOf(userId);
		if (!deleteUserId.isEmpty()) {
			userRepository.deleteById(userId);
			ObjectMapper objectMapper = new ObjectMapper();
			deleteUserId = objectMapper.writeValueAsString(userId);
		}
		return deleteUserId;
	}

	@Override
	public boolean isValidUserEmail(UserDTO userDto) {
		boolean isValid = true;
		if (userDto.getUserId() != 0) {
			if (userRepository.findByEmailAddress(userDto.getUserId(), userDto.getEmail()) != null) {
				isValid = false;
			}
		} else {
			if (userRepository.findByEmail(userDto.getEmail()) != null) {
				isValid = false;
			}
		}
		return isValid;
	}

}
