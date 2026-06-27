package br.com.ijuris.infrastructure.api.dto;

public record ChangeEmailResponseDTO(String email) {

    public static ChangeEmailResponseDTO fromDomain(String email) {
        return new ChangeEmailResponseDTO(email);
    }
}
