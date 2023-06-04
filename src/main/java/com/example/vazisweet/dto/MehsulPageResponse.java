package com.example.vazisweet.dto;

import java.util.List;

public record MehsulPageResponse(
        List<MehsulDto> mehsuls,
        long totalElements,
        int totalPages,
        boolean hasNextPage
) {
}
