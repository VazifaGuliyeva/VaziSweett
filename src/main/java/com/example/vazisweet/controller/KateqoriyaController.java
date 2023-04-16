package com.example.vazisweet.controller;

import com.example.vazisweet.entity.Kateqoriya;
import com.example.vazisweet.manager.KateqoriyaManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class KateqoriyaController {
    private final KateqoriyaManager kateqoriyaManager;


    public KateqoriyaController(KateqoriyaManager kateqoriyaManager) {
        this.kateqoriyaManager = kateqoriyaManager;
    }
    @GetMapping("/kateqoriyalar")
    public List<Kateqoriya> getAll(){
        return kateqoriyaManager.getAll();

    }
    @GetMapping("/kateqoriyalar/{id}")
    public Kateqoriya getById(@PathVariable int id){
        return kateqoriyaManager.getById(id);
    }
    @PostMapping("/kateqoriyalar")
    public void addKateqoriya(@RequestBody Kateqoriya kateqoriya){
        kateqoriyaManager.addKateqoriya(kateqoriya);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteKateqoriya(@PathVariable int id){
        kateqoriyaManager.deleteKateqoriya(id);
    }
}
