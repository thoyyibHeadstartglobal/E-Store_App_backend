package com.example.demo.usermodules;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;






public interface
UserRepository 
extends MongoRepository<UserModel, String> {
	  List<UserModel> findByemailContaining(String email);
	  List<UserModel> findByusernameContaining(String username);
	 
	  List<UserModel> findByPasswordContaining(String password);
	  List<UserModel> findByisAdminContaining(boolean isAdmin);
	  
	  Boolean existsByUsername(String username);

	  Boolean existsByEmail(String email);
	  
	}
