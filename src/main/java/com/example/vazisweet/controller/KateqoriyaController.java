package com.example.vazisweet.controller;

import com.example.vazisweet.dto.KateqoriyaDto;
import com.example.vazisweet.dto.KateqoriyaPageResponse;
import com.example.vazisweet.manager.KateqoriyaManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kateqoriyalar")


public class KateqoriyaController {

    Logger logger= LoggerFactory.getLogger(KateqoriyaController.class);

    private final KateqoriyaManager kateqoriyaManager;


    public KateqoriyaController(KateqoriyaManager kateqoriyaManager) {
        this.kateqoriyaManager = kateqoriyaManager;
    }
    @GetMapping
    public KateqoriyaPageResponse getAll(@RequestParam(value = "page") int page, @RequestParam(value="count") int count){
        logger.info("getAll request accepted");
        return kateqoriyaManager.getAll(page,count);

    }
    @GetMapping("/{id}")
    public KateqoriyaDto getById(@PathVariable int id){
        return kateqoriyaManager.getById(id);
    }
    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public void addKateqoriya(@RequestBody KateqoriyaDto kateqoriyaDto){

        kateqoriyaManager.addKateqoriya(kateqoriyaDto);
    }
    @DeleteMapping("/{id}")
    public void deleteKateqoriya(@PathVariable int id){

        kateqoriyaManager.deleteKateqoriya(id);
    }
}
