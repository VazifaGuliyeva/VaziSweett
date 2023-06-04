package com.example.vazisweet.controller;

import com.example.vazisweet.dto.MehsulDto;
import com.example.vazisweet.dto.MehsulPageResponse;
import com.example.vazisweet.manager.MehsulManager;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mehsullar")

public class MehsulController {
    private final MehsulManager mehsulManager;

    public MehsulController(MehsulManager mehsulManager) {
        this.mehsulManager = mehsulManager;
    }

    @GetMapping
    public MehsulPageResponse getAll(@RequestParam (value="page")int page, @RequestParam(value="count")int count) {
        return mehsulManager.getAll(page,count);

    }

    @GetMapping("/{id}")
    public MehsulDto getById(@PathVariable int id) {
        return mehsulManager.getById(id);
    }

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public void addMehsul(@RequestBody MehsulDto mehsulDto) {
        mehsulManager.addMehsul(mehsulDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteMehsul(@PathVariable int id) {
        mehsulManager.deleteMehsul(id);
    }
}
