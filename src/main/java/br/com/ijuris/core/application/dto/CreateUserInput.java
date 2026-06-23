package br.com.ijuris.core.application.dto;

public record CreateUserInput(
        UserInput userInput,
        AddressInput addressInput
) {
}
