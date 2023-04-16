package com.example.vazisweet.manager;

import com.example.vazisweet.entity.Kateqoriya;
import com.example.vazisweet.repository.KateqoriyaRepository;
import com.example.vazisweet.service.KateqoriyaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class KateqoriyaManager implements KateqoriyaService {
    private final KateqoriyaRepository kateqoriyaRepository;

    @Override
    public List<Kateqoriya> getAll() {
        return kateqoriyaRepository.findAll();
    }

    @Override
    public Kateqoriya getById(int id) {
        return kateqoriyaRepository.findById(id).get();
    }

    @Override
    public void addKateqoriya(Kateqoriya kateqoriya) {
        kateqoriyaRepository.save(kateqoriya);

    }

    @Override
    public void deleteKateqoriya(int id) {
        kateqoriyaRepository.deleteById(id);

    }
}
