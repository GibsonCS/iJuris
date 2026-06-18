package br.com.ijuris.application.dto;

import java.time.LocalDate;

public record CreateUserInput(String nome, String sobrenome, String cpf, String email, LocalDate dataNascimento,
                              AddressInput addressInput
) {
}
