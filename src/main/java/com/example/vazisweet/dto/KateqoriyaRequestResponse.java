package com.example.vazisweet.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record KateqoriyaRequestResponse(

        @NotNull
        String fullName,

        LocalDate age
) {
}
