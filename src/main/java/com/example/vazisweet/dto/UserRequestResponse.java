package com.example.vazisweet.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UserRequestResponse(
        @Email(message = "mutleq email daxil etmelisiniz")
        @Size(min = 4,message = "minimum uzunluq 4")
        String fullname
) {
}
