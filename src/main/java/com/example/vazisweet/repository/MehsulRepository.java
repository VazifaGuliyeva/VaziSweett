package com.example.vazisweet.repository;

import com.example.vazisweet.entity.Mehsul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MehsulRepository extends JpaRepository<Mehsul,Integer> {
}
