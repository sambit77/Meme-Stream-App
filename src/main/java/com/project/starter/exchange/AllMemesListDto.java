package com.project.starter.exchange;

import java.util.List;

import com.project.starter.data.MemeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllMemesListDto {
    List<MemeEntity> memesList;
}
