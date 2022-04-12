package com.userservices.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userservices.dto.RoleDTO;

@Service
public interface RoleService {

	public String saveRole(RoleDTO roleDto) throws JsonProcessingException;

	public String updateRole(RoleDTO roleDto) throws JsonProcessingException;

	public String deleteRoleById(long roleId) throws JsonProcessingException;

	public String getRoleById(long roleId) throws JsonProcessingException;

	public String getAllRoles() throws JsonProcessingException;

}
