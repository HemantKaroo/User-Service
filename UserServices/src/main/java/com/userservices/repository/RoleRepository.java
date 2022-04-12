package com.userservices.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.userservices.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query("SELECT r FROM Role r WHERE r.roleName IN (:roleNames)")
	public List<Role> findByRoleNames(@Param(value = "roleNames") List<String> roleNames);

	Optional<Role> findRoleByRoleName(String roleName);
}
