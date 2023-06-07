package com.example.demo.repostory;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.models.MainMenu;




public interface
MainMenuRepository 
extends MongoRepository<MainMenu, String> {
	  List<MainMenu> findByoptionNameContaining(String optionName);
	  List<MainMenu> findByoptionImageContaining(String optionImage);
//	  List<MainMenu> findByoptionImage(String optionImage);
	}