package com.example.demo.repostory;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.models.SubMenu;




public interface
SubMenuRepository 
extends MongoRepository<SubMenu, String> {
	  List<SubMenu> findByoptionNameContaining(String optionName);
	  List<SubMenu> findByoptionImageContaining(String optionImage);
	  List<SubMenu> findBymainIdContaining(String mainId);
	  
	  List<SubMenu> findByMainId(String MainId);
//	   List<SubMenu> findBySubMenus(String mainId);
//	  List<MainMenu> findByoptionImage(String optionImage);
	}






