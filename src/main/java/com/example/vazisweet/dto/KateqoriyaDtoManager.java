package com.example.vazisweet.dto;

import com.example.vazisweet.entity.Category;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class KateqoriyaDtoManager implements Function<Category,KateqoriyaDto> {
    @Override
    public KateqoriyaDto apply(Category kateqoriya) {
        return new KateqoriyaDto(kateqoriya.getKateqoriyaAd());
    }
}
