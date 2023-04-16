package com.example.vazisweet.manager;

import com.example.vazisweet.entity.Mehsul;
import com.example.vazisweet.repository.MehsulRepository;
import com.example.vazisweet.service.MehsulService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class MehsulManager implements MehsulService {
    private final MehsulRepository mehsulRepository;


    @Override
    public List<Mehsul> getAll() {
        return mehsulRepository.findAll();
    }

    @Override
    public Mehsul getById(int id) {
        return mehsulRepository.findById(id).get();
    }

    @Override
    public void addMehsul(Mehsul mehsul) {
        mehsulRepository.save(mehsul);

    }

    @Override
    public void deleteMehsul(int id) {
        mehsulRepository.deleteById(id);
    }
}
