package com.example.wetravel.Mapper;

import java.util.List;

public interface MapperStruct<E,D> {
    E toEntity(D dto);

    D toDTO (E entity);

    List<E> toListEntity(List<D> dtoList);

    List <D> toListDTO(List<E> entityList);
}
