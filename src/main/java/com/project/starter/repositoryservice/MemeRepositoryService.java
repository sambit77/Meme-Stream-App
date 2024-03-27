package com.project.starter.repositoryservice;

import java.util.List;

import com.project.starter.data.MemeEntity;

public interface MemeRepositoryService {
    public List<MemeEntity> getTopHunderedMemes();
}
