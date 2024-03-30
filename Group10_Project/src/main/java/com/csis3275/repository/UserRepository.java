package com.csis3275.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csis3275.model_group10.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 User findByEmailAndPassword(String email, String password);
}
