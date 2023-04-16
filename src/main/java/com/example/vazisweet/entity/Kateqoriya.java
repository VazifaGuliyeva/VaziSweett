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
@Entity(name="kateqoriyalar")
public class Kateqoriya {
    @Id
    private Integer id;
    @Column(name="Kateqoriya_adi")
    private String kateqoriya_ad;

}
