package br.com.ijuris.infrastructure.api.dto;

import jakarta.validation.constraints.NotBlank;

public record AddressRequestDTO(

        @NotBlank(message = "O cep é obrigatório")
        String cep,

        @NotBlank(message = "O estado é obrigatório")
        String state,

        @NotBlank(message = "A cidade é obrigatória")
        String city,

        @NotBlank(message = "O bairro é obrigatório")
        String neighborhood,

        @NotBlank(message = "O número é obrigatório")
        String number,

        @NotBlank(message = "O complemento é obrigatório")
        String complement,

        @NotBlank(message = "A rua é obrigatória")
        String street
) {
}
