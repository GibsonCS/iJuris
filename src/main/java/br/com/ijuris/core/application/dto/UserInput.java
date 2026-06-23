package br.com.ijuris.core.application.dto;

import java.time.LocalDate;

public record UserInput(String name,
                        String lastname,
                        String cpf,
                        String email,
                        String password,
                        LocalDate dateOfBirthday
) {
}
