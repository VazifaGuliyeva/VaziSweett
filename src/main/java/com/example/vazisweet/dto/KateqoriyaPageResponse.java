package com.example.vazisweet.dto;

import java.util.List;

public record KateqoriyaPageResponse(
        List<KateqoriyaDto> kateqoriya,
        long totalElements,
        int totalPages,
        boolean hasNextPage
) {
}
