package br.com.ijuris.infrastructure.api.dto;

import java.time.LocalDate;

public record UserRequestDTO(String nome, String sobrenome, String cpf, String email, LocalDate dataNascimento) {
}
