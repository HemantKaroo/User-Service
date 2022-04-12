package com.userservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.userservices.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("Select u from User u where u.firstName like %:searchUser% or u.middleName like %:searchUser% or u.lastName like %:searchUser% or u.email like %:searchUser% or u.addressOne like %:searchUser% or u.addressTwo like %:searchUser% or u.city like %:searchUser% or u.state like %:searchUser% or u.pincode like %:searchUser% or u.country like %:searchUser% or u.phoneNumber like %:searchUser%")
	public List<User> searchUsers(@Param(value = "searchUser") String searchUsers);

	@Query("Select u from User u where u.email =:email and u.userId !=:userId")
	public User findByEmailAddress(@Param("userId") long userId, @Param("email") String email);
	
	public User findByEmail(String email);

}
