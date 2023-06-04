package com.example.vazisweet.mapper;

import com.example.vazisweet.dto.MehsulDto;
import com.example.vazisweet.entity.Mehsul;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MehsulMapperTest {
    private final MehsulMapper mehsulMapper=new MehsulMapperImpl();

    @Test
    void toMehsulDto() {
       Mehsul mehsul=new Mehsul(111,"SnikersTort",11.25,"4 neferlik");
       MehsulDto expected=new MehsulDto(111,"SnikersTort",11.25,"4 neferlik");

       MehsulDto actual=mehsulMapper.toMehsulDto(mehsul);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void toEntity() {
        MehsulDto mehsulDto=new MehsulDto(111,"SnikersTort",11.25,"4 neferlik");
        Mehsul expected=new Mehsul(111,"SnikersTort",11.25,"4 neferlik");

        Mehsul actual=mehsulMapper.toEntity(mehsulDto);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}