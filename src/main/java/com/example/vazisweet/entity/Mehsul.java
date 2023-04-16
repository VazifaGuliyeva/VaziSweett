package com.example.vazisweet.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="mehsullar")
public class Mehsul {
    @Id
    private Integer mehsul_id;
    @Column(name="mehsulun_adi")
    private String mehsul_ad;
    @Column(name="qiymet")
    private double qiymet;
    @Column(name="olcu")
    private String olcu;

}
