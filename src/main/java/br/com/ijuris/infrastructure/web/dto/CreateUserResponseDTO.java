package br.com.ijuris.infrastructure.web.dto;

import br.com.ijuris.domain.entity.User;

import java.util.UUID;

public record CreateUserResponseDTO(UUID userId) {

    public static CreateUserResponseDTO fromDomain(User user) {
        return new CreateUserResponseDTO(user.getId());
    }
}
