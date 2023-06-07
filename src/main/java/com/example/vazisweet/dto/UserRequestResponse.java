package com.example.vazisweet.dto;

import jakarta.validation.constraints.*;

public record UserRequestResponse(
        @NotNull(message = "fullName null olmamalidir")
        @NotEmpty(message = "fullName empty olmamalidir")
        @NotBlank(message = "fullName blank olmamalidir")

        @Email(message = "mutleq email daxil etmelisiniz")
        @Size(min = 4,message = "minimum uzunluq 4")
        String fullname
) {
}
