package com.userservices.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.userservices.dto.RoleDTO;
import com.userservices.model.Role;
import com.userservices.repository.RoleRepository;
import com.userservices.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public String saveRole(RoleDTO roleDto) throws JsonProcessingException {
		String roleSave = "";
		Role role = new Role();
		Optional<Role> roleOptional = roleRepository.findRoleByRoleName(roleDto.getRoleName());
		if (!roleOptional.isPresent()) {
			role.setRoleName(roleDto.getRoleName());
			ObjectMapper objectMapper = new ObjectMapper();
			roleSave = objectMapper.writeValueAsString(roleRepository.save(role));
		}
		return roleSave;
	}

	@Override
	public String updateRole(RoleDTO roleDto) throws JsonProcessingException {
		String roleUpdate = "";
		long roleId = roleDto.getRoleId();
		Optional<Role> roleOptional = roleRepository.findById(roleId);
		if (roleOptional.isPresent()) {
			Role roleExist = roleOptional.get();
			roleExist.setRoleName(roleDto.getRoleName());
			ObjectMapper objectMapper = new ObjectMapper();
			roleUpdate = objectMapper.writeValueAsString(roleRepository.save(roleExist));
		}
		return roleUpdate;
	}

	@Override
	public String deleteRoleById(long roleId) throws JsonProcessingException {
		String deleteRoleId = "";
		deleteRoleId = String.valueOf(roleId);
		if (!deleteRoleId.isEmpty()) {
			roleRepository.deleteById(roleId);
			ObjectMapper objectMapper = new ObjectMapper();
			deleteRoleId = objectMapper.writeValueAsString(roleId);
		}
		return deleteRoleId;
	}

	@Override
	public String getRoleById(long roleId) throws JsonProcessingException {
		String roleData = "";
		Optional<Role> roleOptional = roleRepository.findById(roleId);
		if (roleOptional.isPresent()) {
			ObjectMapper objectMapper = new ObjectMapper();
			roleData = objectMapper.writeValueAsString(roleOptional.get());
		}
		return roleData;
	}

	@Override
	public String getAllRoles() throws JsonProcessingException {
		String roles = "";
		List<Role> roleList = roleRepository.findAll();
		if (!roleList.isEmpty()) {
			ObjectMapper objectMapper = new ObjectMapper();
			roles = objectMapper.writeValueAsString(roleList);
		}
		return roles;
	}
}
