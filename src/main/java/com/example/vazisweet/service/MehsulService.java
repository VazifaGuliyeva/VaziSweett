package com.example.vazisweet.service;

import com.example.vazisweet.dto.MehsulDto;
import com.example.vazisweet.dto.MehsulPageResponse;

public interface MehsulService {
    MehsulPageResponse getAll(int page, int count);
    MehsulDto getById(int id);
    void addMehsul(MehsulDto mehsulDto);
    void deleteMehsul(int id);

}
