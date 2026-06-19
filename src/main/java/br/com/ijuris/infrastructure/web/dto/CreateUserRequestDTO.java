package br.com.ijuris.infrastructure.web.dto;

import br.com.ijuris.core.application.dto.AddressInput;
import br.com.ijuris.core.application.dto.CreateUserInput;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CreateUserRequestDTO(

        @NotNull(message = "Os dados do usuário são obrigatórios")
        @Valid
        UserRequestDTO userRequestDTO,

        @NotNull(message = "Os dados do endereço são obrigatórios")
        @Valid
        AddressRequestDTO addressRequestDTO
) {

    public CreateUserInput toInput() {
        AddressInput addressInput = new AddressInput(addressRequestDTO.cep(),
                addressRequestDTO.estado(), addressRequestDTO.cidade(), addressRequestDTO.bairro(),
                addressRequestDTO.numero(), addressRequestDTO.complemento(), addressRequestDTO.logradouro()
        );
        return new CreateUserInput(userRequestDTO.nome(), userRequestDTO.sobrenome(), userRequestDTO.cpf(),
                userRequestDTO.email(), userRequestDTO.dataNascimento(), addressInput
        );
    }
}
