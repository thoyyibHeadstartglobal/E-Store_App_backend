package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


//
import java.util.ArrayList;


//import org.springframework.web.bind.annotation.RequestMethod;




import com.example.demo.models.Tutorial;
import com.example.demo.repostory.*;

//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TutorialController {

  @Autowired
  TutorialRepository tutorialRepository;
  
  @GetMapping("/getData")  
  public String hello()   
  {  
	  
	  
  return "Hello User test";  
  } 
  
  
  
  @PostMapping("/addTutorials")
//  @RequestMapping(method = RequestMethod.POST)
//  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
    try {
  System.out.print("the fields are ...180");
  System.out.println(tutorial);
      Tutorial _tutorial = tutorialRepository.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
      return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  

  @GetMapping("/tutorials")
  public ResponseEntity<List<Tutorial>>
  getAllTutorials(@RequestParam(required = false) String title) {
	  
	  List<Tutorial> tutorials =  new ArrayList<Tutorial>();
      tutorialRepository.findAll().forEach
      (tutoriial -> tutorials.add(tutoriial));

      return new ResponseEntity<>(tutorials, HttpStatus.ACCEPTED);

  }
  
  
  
  
  @GetMapping("/tutorials/{id}")
  public ResponseEntity<Optional<Tutorial>> 
  getProductById(@PathVariable String id) {
      return ResponseEntity.ok().body(
    		  tutorialRepository.findById(id));
  }

  
  
//  @Bean
//  public OpenAPI openAPI() {
//      return new OpenAPI().info(new Info().title("SpringDoc example")
//          .description("SpringDoc application")
//          .version("v0.0.1"));
//  }


  @GetMapping("/tutorials/published")
  public ResponseEntity<List<Tutorial>> findByPublished() {
	return null;
    
  }
  


  @PutMapping("/tutorials/{id}")
  public ResponseEntity<Tutorial> updateTutorial(
		  @PathVariable("id") String id, @RequestBody Tutorial tutorial) {
    Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

    if (tutorialData.isPresent()) {
      Tutorial _tutorial = tutorialData.get();
      _tutorial.setTitle(tutorial.getTitle());
      _tutorial.setDescription(tutorial.getDescription());
      _tutorial.setPublished(tutorial.isPublished());
      return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  
  @DeleteMapping("/tutorials/{id}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
    try {
      tutorialRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/tutorials")
  public ResponseEntity<HttpStatus> deleteAllTutorials() {
    try {
      tutorialRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  


//– @CrossOrigin is for configuring allowed origins.
//– @RestController annotation is used to define a controller and to indicate that the return value of the methods should be be bound to the web response body.
//– @RequestMapping("/api") declares that all Apis’ url in the controller will start with /api.
//– We use @Autowired to inject TutorialRepository bean to local variable.
//
//Now I will show you how to implement each controller’s CRUD methods.

//Create Operation
//We use @PostMapping annotation for handling POST HTTP requests.
//A new Tutorial will be created by MongoRepository.save() method.



}
