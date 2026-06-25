package br.com.ijuris.infrastructure.api.dto;

import br.com.ijuris.core.application.dto.UpdateUserInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UpdateUserRequestDTO(

        @NotBlank(message = "O nome não pode ser vazio")
        @Size(message = "O nome deve ter mais de 2 caracteres")
        String name,

        @NotBlank(message = "O sobrenome não pode ser vazio")
        @Size(message = "O sobrenome deve ter mais de 2 caracteres")
        String lastname,

        @NotNull(message = "A data de nascimento não pode ser nula")
        LocalDate dateOfBirthday
) {
    public UpdateUserInput toInput() {
        return new UpdateUserInput(name, lastname, dateOfBirthday);
    }
}
