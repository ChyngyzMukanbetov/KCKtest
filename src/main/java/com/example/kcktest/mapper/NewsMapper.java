package com.example.kcktest.mapper;

import com.example.kcktest.model.dto.NewsDto;
import com.example.kcktest.model.entity.News;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface NewsMapper {

    @Mapping(source = "user", target = "userDto")
    @Mapping(source = "image.uri", target = "imageUri")
    NewsDto toDto(News news);
}
