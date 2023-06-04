package com.example.vazisweet.mapper;

import com.example.vazisweet.dto.KateqoriyaDto;
import com.example.vazisweet.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KateqoriyaMapper {


    KateqoriyaDto toKateqoriyaDto(Category kateqoriya);

    Category toEntity(KateqoriyaDto kateqoriyaDto);
}
