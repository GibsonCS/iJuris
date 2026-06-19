package br.com.ijuris.infrastructure.web.dto;

import java.time.LocalDate;

public record UserRequestDTO(String nome, String sobrenome, String cpf, String email, LocalDate dataNascimento) {
}
