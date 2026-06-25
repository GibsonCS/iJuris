package br.com.ijuris.infrastructure.api.dto;

import br.com.ijuris.core.domain.entity.User;

import java.time.LocalDate;
import java.util.UUID;

public record UpdateUserResponseDTO(String name, String lastname, LocalDate dateOfBirthday) {

    public static  UpdateUserResponseDTO fromDomain(User user) {
        return new UpdateUserResponseDTO(user.getName(), user.getLastname(), user.getDateOfBirthDay());
    }
}
