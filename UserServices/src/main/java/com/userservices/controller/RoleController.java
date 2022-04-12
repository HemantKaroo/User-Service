package com.userservices.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userservices.constants.ServiceConstants;
import com.userservices.dto.RoleDTO;
import com.userservices.service.RoleService;

@Controller
@RequestMapping("/roleservice")
public class RoleController {

	@Autowired
	RoleService roleServices;

	@PostMapping("/saveRole")
	@ResponseBody
	public ResponseEntity<String> saveRole(@Valid @RequestBody RoleDTO roleDto) throws JsonProcessingException {
		String roleSave = roleServices.saveRole(roleDto);
		if (null != roleSave && !roleSave.isEmpty()) {
			return new ResponseEntity<>(roleSave, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ServiceConstants.Request_Fail, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteRole/{roleId}")
	public ResponseEntity<String> deleteRole(@PathVariable(value = "roleId") long roleId)
			throws JsonProcessingException {
		String deleteRoleId = roleServices.deleteRoleById(roleId);
		if (null != deleteRoleId && !deleteRoleId.isEmpty()) {
			return new ResponseEntity<>(deleteRoleId, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ServiceConstants.Request_Fail, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAllRoles")
	public ResponseEntity<String> getAllRoles() throws JsonProcessingException {
		String roles = roleServices.getAllRoles();
		if (null != roles && !roles.isEmpty()) {
			return new ResponseEntity<>(roles, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ServiceConstants.Request_Fail, HttpStatus.OK);
		}
	}

	@GetMapping("/getAllRoleById/{roleId}")
	public ResponseEntity<String> getRoleById(@PathVariable(value = "roleId") long roleId)
			throws JsonProcessingException {
		String roleData = roleServices.getRoleById(roleId);
		if (null != roleData && !roleData.isEmpty()) {
			return new ResponseEntity<>(roleData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ServiceConstants.Request_Fail, HttpStatus.OK);
		}
	}

	@PutMapping("/roleUpdate")
	@ResponseBody
	public ResponseEntity<String> updateRole(@RequestBody RoleDTO roleDto) throws JsonProcessingException {
		String roleUpdate = roleServices.updateRole(roleDto);
		if (null != roleUpdate && !roleUpdate.isEmpty()) {
			return new ResponseEntity<>(roleUpdate, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ServiceConstants.Request_Fail, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
