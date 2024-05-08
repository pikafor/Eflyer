package com.example.final_lab.mapper;

import com.example.final_lab.dto.abstracts.AbstractDTO;
import com.example.final_lab.model.abstracts.AbstractEntity;

public interface Mapper<E extends AbstractEntity, D extends AbstractDTO> {
    E toEntity(D dto);


    D toDto(E entity);

    void configureMapper();


}
