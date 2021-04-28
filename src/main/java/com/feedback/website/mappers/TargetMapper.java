package com.feedback.website.mappers;


import com.feedback.website.dtos.TargetDto;
import com.feedback.website.entities.TargetEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TargetMapper {
    

    @Mapping(source = "targetName", target = "name")
    TargetEntity dtoToEntity(TargetDto dto);

    @Mapping(source = "name", target = "targetName")
    TargetDto entityToDto(TargetEntity entity);

    List<TargetDto> entityListToDtoList(List<TargetEntity> entityList);

    List<TargetEntity> dtoListtoEntityList(List<TargetDto> dtoList);

}
