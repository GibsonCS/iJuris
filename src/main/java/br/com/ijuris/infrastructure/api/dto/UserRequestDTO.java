package br.com.ijuris.infrastructure.api.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserRequestDTO(

        @NotBlank(message = "O nome do usuário é obrigatório.")
        String name,

        @NotBlank(message = "Sobrenome é obrigatório")
        String lastname,

        @NotBlank(message = "CPF é obrigatório")
        String cpf,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "Email inválido")
        String email,

        @NotNull(message = "A data de nascimento é obrigatória")
        LocalDate dateOfBirthday,

        @NotBlank(message = "Password não deve ser vazio.")
        @Size(min = 6, message = "A senha deve ter no mínimo seis dígitos.")
        String password,

        @NotBlank(message = "Confirmação do password inválida")
        String confirmPassword
) {

        @AssertTrue(message = "As senhas não conferem")
        public boolean isPasswordMatching() {
                if (password == null || confirmPassword == null) {
                        return true;
                }

                return password.equals(confirmPassword);
        }
}
