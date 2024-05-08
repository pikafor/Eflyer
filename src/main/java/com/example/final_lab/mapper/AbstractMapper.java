package com.example.final_lab.mapper;

import com.example.final_lab.dto.abstracts.AbstractDTO;
import com.example.final_lab.model.abstracts.AbstractEntity;
import jakarta.annotation.PostConstruct;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

import static java.util.Objects.isNull;

public abstract class AbstractMapper<E extends AbstractEntity, D extends AbstractDTO> implements Mapper<E, D> {

    AbstractMapper() {}

    ModelMapper mapper;
    private Class<E> entityClass;
    private Class<D> dtoClass;

    AbstractMapper(Class<E> entityClass, Class<D> dtoClass) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @PostConstruct
    public void init() {

        configureMapper();
    }
    @Override
    public E toEntity(D dto) {
        return isNull(dto)
                ? null
                : mapper.map(dto, entityClass);
    }

    protected E toNewEntity(D source) {
        return toEntity(source);
    }

    protected E toUpdatedEntity(D source) {
        return toEntity(source);
    }

    @Override
    public D toDto(E entity) {
        return isNull(entity)
                ? null
                : mapper.map(entity, dtoClass);
    }


    Converter<E, D> toDtoConverter() {
        return context -> {
            E source = context.getSource();
            D destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    Converter<D, E> toEntityConverter() {
        return context -> {
            D source = context.getSource();
            E destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    void mapSpecificFields(E source, D destination) {
    }

    void mapSpecificFields(D source, E destination) {
    }

    Long checkIdNotNull(Long id) {
        if (isNull(id)) {
            return -1L;
        }
        return id;
    }

    public E fillEntityFromDTO(E entity, D dto) {
        if (isNull(entity) || isNull(dto)) {
            throw new IllegalArgumentException("Утеряна часть данных для классов: " + entityClass.getName() + " и " + dtoClass.getName());
        }
        return entity;
    }
}
