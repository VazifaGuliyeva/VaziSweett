package com.example.vazisweet.service;

import com.example.vazisweet.entity.Kateqoriya;

import java.util.List;

public interface KateqoriyaService {
    List<Kateqoriya> getAll();
    Kateqoriya getById( int id);
    void addKateqoriya(Kateqoriya kateqoriya);
    void deleteKateqoriya(int id);

}
