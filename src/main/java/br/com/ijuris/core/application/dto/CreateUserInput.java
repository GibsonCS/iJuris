package br.com.ijuris.core.application.dto;

import java.time.LocalDate;

public record CreateUserInput(
        String nome,
        String sobrenome,
        String cpf,
        String email,
        LocalDate dataNascimento,
        AddressInput addressInput
) {
}
