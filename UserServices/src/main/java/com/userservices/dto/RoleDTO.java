package com.userservices.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RoleDTO {

	private long roleId;

	@NotNull(message = "roleName can not be empty.")
	@Size(min = 2, max = 20, message = "enter valid roleName.")
	@Valid
	private String roleName;

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
