package com.project.starter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.starter.data.MemeEntity;
import com.project.starter.repository.MemeRepository;
import com.project.starter.repositoryservice.MemeRepositoryService;

@Service
public class MemeServiceImpl implements MemeService{

    @Autowired
    private MemeRepository memeRepository;
    @Autowired
    private MemeRepositoryService memeRepositoryService;

    @Override
    public List<MemeEntity> getAllMemes() {
        // TODO Auto-generated method stub
        return memeRepositoryService.getTopHunderedMemes();
    }

    @Override
    public MemeEntity getByExternalId(int id) {
        // TODO Auto-generated method stub
        return memeRepository.findById(id);
    }

    @Override
    public void saveMeme(MemeEntity memeEntity) {
        // TODO Auto-generated method stub
        memeRepository.save(memeEntity);
    }
    
    
}
