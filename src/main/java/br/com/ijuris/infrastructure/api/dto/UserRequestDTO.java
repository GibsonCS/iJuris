package br.com.ijuris.infrastructure.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record UserRequestDTO(

        @NotBlank(message = "O nome não deve etar em branco.")

        String name,
        @NotBlank(message = "Sobrenome é obrigatório")
        String lastname,

        @NotBlank(message = "CPF é obrigatório")
        String cpf,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "Email inválido")
        String email,

        @NotBlank(message = "A data de nascimento é obrigatória")
        LocalDate dateOfBirthday
) {
}
