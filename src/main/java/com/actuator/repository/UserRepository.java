package com.actuator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.actuator.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	

}