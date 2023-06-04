package com.example.vazisweet.mapper;

import com.example.vazisweet.dto.MehsulDto;
import com.example.vazisweet.entity.Mehsul;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MehsulMapper {

    MehsulDto toMehsulDto(Mehsul mehsul);

    Mehsul toEntity(MehsulDto mehsulDto);
}
