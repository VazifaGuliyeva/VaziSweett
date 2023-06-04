package com.example.vazisweet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="mehsullar")
public class Mehsul {
    @Id
    @GeneratedValue
    private Integer mehsulId;
    @Column(name = "mehsulun_adi")
    private String mehsulAd;
    @Column(name = "qiymet")
    private double qiymet;
    @Column(name = "olcu")
    private String olcu;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="kateqoriya_id",referencedColumnName = "id")
    Category kateqoriya;

    public Mehsul(int i, String snikersTort, double v, String s) {
    }
}


