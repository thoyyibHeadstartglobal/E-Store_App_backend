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




import java.util.ArrayList;

import com.example.demo.models.MainMenu;


import com.example.demo.repostory.*;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MainMenuController {

  @Autowired
  MainMenuRepository mainMenuRepository;
  
  @GetMapping("/getMenutest")  
  public String hello()   
  {  
	  
	  
  return "Menu test";  
  } 
  
  
  
  @PostMapping("/addMainMenu")
//  @RequestMapping(method = RequestMethod.POST)
//  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<MainMenu> addMainMenu(@RequestBody 
		  MainMenu me) {
    try {
  System.out.print("the fields are ...62");
  System.out.println(me);
  MainMenu _tutorial = mainMenuRepository.save(new 
		  MainMenu(me.getOptionName(), 
				  me.getOptionImage()));
  return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
   
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  

  @GetMapping("/mainMenus")
  public ResponseEntity<List<MainMenu>>
  getAllMainMenus(@RequestParam(required = false) String title) {
	  
	  List<MainMenu> tutorials =  new ArrayList<MainMenu>();
	  mainMenuRepository.findAll().forEach
      (tutorial -> tutorials.add(tutorial));

      return new ResponseEntity<>(tutorials, HttpStatus.ACCEPTED);

  }
  
  
  
  
  @GetMapping("/mainMenus/{id}")
  public ResponseEntity<Optional<MainMenu>> 
  getMainMenuById(@PathVariable String id) {
      return ResponseEntity.ok().body(
    		  mainMenuRepository.findById(id));
  }

  
  


  @GetMapping("/mainMenus/published")
  public ResponseEntity<List<MainMenu>> findByPublished() {
	return null;
    
  }
  


  @PutMapping("/mainMenus/{id}")
  public ResponseEntity<MainMenu> updateMainMenu(
		  @PathVariable("id") String id, @RequestBody MainMenu m) {
    Optional<MainMenu> tutorialData = mainMenuRepository.findById(id);

    if (tutorialData.isPresent()) {
    	MainMenu _m = tutorialData.get();
      _m.setOptionName(m.getOptionName());
      _m.setOptionImage(m.getOptionImage());
      
      return new ResponseEntity<>(mainMenuRepository.save(_m), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  
  @DeleteMapping("/mainMenus/{id}")
  public ResponseEntity<HttpStatus> deleteMainMenu(@PathVariable("id") String id) {
    try {
    	mainMenuRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/mainMenus")
  public ResponseEntity<HttpStatus> deleteAllMainMenus() {
    try {
    	mainMenuRepository.deleteAll();
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
