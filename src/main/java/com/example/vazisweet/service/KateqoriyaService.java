package com.example.vazisweet.service;

import com.example.vazisweet.dto.KateqoriyaDto;
import com.example.vazisweet.dto.KateqoriyaPageResponse;

public interface KateqoriyaService {
    KateqoriyaPageResponse getAll(int page, int count);
    KateqoriyaDto getById( int id);
    void addKateqoriya(KateqoriyaDto kateqoriyaDto);
    void deleteKateqoriya(int id);

}
