package br.com.ijuris.core.application.dto;

import java.time.LocalDate;

public record UpdateUserInput(String name, String lastname, LocalDate dateOfBirthday) {
}
