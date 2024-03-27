package com.project.starter.service;

import java.util.List;

import com.project.starter.data.MemeEntity;

public interface MemeService {
    List<MemeEntity> getAllMemes();
    MemeEntity getByExternalId(int id);
    void saveMeme(MemeEntity memeEntity);

}
