package br.com.ijuris.infrastructure.api.dto;

import br.com.ijuris.core.application.dto.AddressInput;
import br.com.ijuris.core.application.dto.CreateUserInput;
import br.com.ijuris.core.application.dto.UserInput;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CreateUserRequestDTO(

        @NotNull(message = "Os dados do usuário são obrigatórios")
        @Valid
        UserRequestDTO user,

        @NotNull(message = "Os dados do endereço são obrigatórios")
        @Valid
        AddressRequestDTO address
) {

    public CreateUserInput toInput() {
        AddressInput addressInput = new AddressInput(address.cep(), address.state(), address.city(),
                address.neighborhood(), address.number(), address.complement(), address.street()
        );

        UserInput userInput = new UserInput(user.name(), user.lastname(), user.cpf(), user.email(), user.password(),
                user.dateOfBirthday()
        );

        return new CreateUserInput(userInput, addressInput);
    }
}
