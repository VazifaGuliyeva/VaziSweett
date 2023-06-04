package com.example.vazisweet.dto;

import com.example.vazisweet.entity.Mehsul;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class MehsulDtoManager implements Function<Mehsul,MehsulDto> {
    @Override
    public MehsulDto apply(Mehsul mehsul) {
        return new MehsulDto(111, mehsul.getMehsulAd(),mehsul.getQiymet(),mehsul.getOlcu());
    }
}
