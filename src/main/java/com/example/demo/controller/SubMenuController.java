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

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;




import java.util.ArrayList;


import com.example.demo.models.SubMenu;
import com.example.demo.repostory.SubMenuRepository;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class SubMenuController {

  @Autowired
  SubMenuRepository subMenuRepository;
  
  @GetMapping("/getSubMenutest")  
  public String hello()   
  {  
	  
	  
  return "Menu test";  
  } 
  
 
  
 
  @PostMapping("/addSubMenu")
//  @RequestMapping(method = RequestMethod.POST)
//  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<SubMenu> createSubMenu(@RequestBody 
		  SubMenu me) {
    try {
  System.out.print("the fields are ...62");
  System.out.println(me);
//  SubMenu _tutorial;
//  this.optionName = optionName;
//  this.optionImage = optionImage;
//  this.mainId = mainId;
  
  SubMenu _s = subMenuRepository.save(new 
		  SubMenu(me.getOptionName(), 
				  me.getOptionImage(),
				  me.getMainId()));
  return new ResponseEntity<>(_s, HttpStatus.CREATED);
   
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  

  @GetMapping("/subMenus")
  public ResponseEntity<List<SubMenu>>
  getAllSubMenus(@RequestParam(required = false) String title) {
	  
	  List<SubMenu> tutorials =  new ArrayList<SubMenu>();
	  subMenuRepository.findAll().forEach
      (tutorial -> tutorials.add(tutorial));

      return new ResponseEntity<>(tutorials, HttpStatus.ACCEPTED);

  }
  
  
  
  
  @GetMapping("/subMenus/{id}")
  public ResponseEntity<Optional<SubMenu>> 
  getSubMenuById(@PathVariable String id) {
      return ResponseEntity.ok().body(
    		  subMenuRepository.findById(id));
  }

  
  // get Sub Menu by mainId
  
  @GetMapping("/subMenus/mainMenu/{mainId}")
  public ResponseEntity<List<SubMenu>> 
  getSubMenuByMainId(@PathVariable String mainId) {
	
      return ResponseEntity.ok().body(
    		  subMenuRepository.findByMainId(mainId));
  }



  @GetMapping("/subMenus/published")
  public ResponseEntity<List<SubMenu>> findByPublished() {
	return null;
    
  }
  

  

  @PutMapping("/subMenu/{id}")
  public ResponseEntity<SubMenu> updateSubMenu(
		  @PathVariable("id") String id, @RequestBody SubMenu m) {
    Optional<SubMenu> subData = subMenuRepository.findById(id);

    if (subData.isPresent()) {
    	SubMenu _m = subData.get();
      _m.setOptionName(m.getOptionName());
      _m.setOptionImage(m.getOptionImage());
      _m.setMainId(m.getMainId());
      
      return new ResponseEntity<>(subMenuRepository.save(_m), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  
  @DeleteMapping("/subMenus/{id}")
  public ResponseEntity<HttpStatus> deleteSubMenu(@PathVariable("id") String id) {
    try {
    	subMenuRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/subMenus")
  public ResponseEntity<HttpStatus> deleteAllSubMenus() {
    try {
    	subMenuRepository.deleteAll();
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

