package com.project.starter.repository;

import com.project.starter.data.GreetingsEntity;
import com.project.starter.data.MemeEntity;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemeRepository extends MongoRepository<MemeEntity,String> {
    MemeEntity findById(int id);
    List<MemeEntity> findAll();

}
