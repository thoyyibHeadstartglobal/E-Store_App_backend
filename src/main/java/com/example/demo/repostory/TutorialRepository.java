package com.example.demo.repostory;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.models.Tutorial;


public interface TutorialRepository extends MongoRepository<Tutorial, String> {
  List<Tutorial> findByTitleContaining(String title);
  List<Tutorial> findByPublished(boolean published);
}





