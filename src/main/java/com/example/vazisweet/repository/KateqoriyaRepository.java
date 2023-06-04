package com.example.vazisweet.repository;

import com.example.vazisweet.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KateqoriyaRepository extends JpaRepository<Category, Integer> {

}
