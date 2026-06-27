package br.com.ijuris.infrastructure.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record ChangeEmailRequestDTO(
        @Email
        @NotNull
        String email) {
}
