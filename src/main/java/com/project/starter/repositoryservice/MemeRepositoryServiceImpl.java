package com.project.starter.repositoryservice;

import java.util.List;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.project.starter.data.MemeEntity;
import com.project.starter.repository.MemeRepository;

@Service
public class MemeRepositoryServiceImpl implements MemeRepositoryService{

    @Autowired
    private MemeRepository memeRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<MemeEntity> getTopHunderedMemes() {
        // TODO Auto-generated method stub
        org.springframework.data.mongodb.core.query.Query query = new org.springframework.data.mongodb.core.query.Query();
        query.limit(100);
        query.with(Sort.by(Sort.Direction.DESC, "id"));
        return mongoTemplate.find(query, MemeEntity.class);
    }


}
