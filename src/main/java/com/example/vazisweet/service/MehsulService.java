package com.example.vazisweet.service;

import com.example.vazisweet.entity.Mehsul;

import java.util.List;

public interface MehsulService {
    List<Mehsul> getAll();
    Mehsul getById(int id);
    void addMehsul(Mehsul mehsul);
    void deleteMehsul(int id);

}
