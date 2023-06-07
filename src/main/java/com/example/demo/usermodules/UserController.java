package com.example.demo.usermodules;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.example.demo.models.MainMenu;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")

public class UserController {

  @Autowired
  UserRepository userRepository;
  
  @GetMapping("/getUsertest")  
  public String hello()   
  {  
	  
	  
  return "User Connected test";  
  } 
  
  
  
  @PostMapping("/user/register")
//  @RequestMapping(method = RequestMethod.POST)
//  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<UserModel> registerUser(@RequestBody 
		  UserModel me)
			  {
				  
				  if (userRepository.existsByUsername(me.getUsername())) {
					  return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				    }
			
				    if (userRepository.existsByEmail(me.getEmail())) {
				    	return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				    }
	  
	    		try {
				  System.out.print("the fields are ...62");
				  System.out.println(me);
				  UserModel _tutorial = userRepository.save(new 
						  UserModel(me.getUsername(), 
				  me.getPassword(),
				  me.getEmail(),
				  me.getIsAdmin()));
				  return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
				   
				    } catch (Exception e) {
				      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				    }
			  }
  
  

  @GetMapping("/user/users")
  public ResponseEntity<List<UserModel>>
  getAllUsers(@RequestParam(required = false) String title) {
	  
	  List<UserModel> tutorials =  new ArrayList<UserModel>();
	  userRepository.findAll().forEach
      (tutorial -> tutorials.add(tutorial));

      return new ResponseEntity<>(tutorials, HttpStatus.ACCEPTED);

  }
  
  
  
  
  @GetMapping("/user/users/{id}")
  public ResponseEntity<Optional<UserModel>> 
  getUserById(@PathVariable String id) {
      return ResponseEntity.ok().body(
    		  userRepository.findById(id));
  }

  


  @GetMapping("/user/users/published")
  public ResponseEntity<List<MainMenu>> findByPublished() {
	return null;
    
  }
  


  @PutMapping("/user/users/{id}")
  public ResponseEntity<UserModel> updateUser(
		  @PathVariable("id") String id, @RequestBody UserModel u) {
    Optional<UserModel> userData = userRepository.findById(id);

    if (userData.isPresent()) {
    	UserModel _u = userData.get();
      _u.setUsername(u.getUsername());
      _u.setPassword(u.getPassword());
      _u.setEmail(u.getEmail());
      _u.setIsAdmin(u.getIsAdmin());
      
      return new ResponseEntity<>(userRepository.save(_u), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  
  @DeleteMapping("/user/users/{id}")
  public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") String id) {
    try {
    	userRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  

  @DeleteMapping("/user")
  public ResponseEntity<HttpStatus> deleteAllUsers() {
    try {
    	userRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  






}

