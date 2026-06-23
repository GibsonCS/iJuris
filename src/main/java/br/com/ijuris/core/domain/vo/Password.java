package br.com.ijuris.core.domain.vo;

import br.com.ijuris.core.exception.BusinessException;

public record Password(String password) {

    public Password {
        if (password == null || password.length() < 8) {
            throw new BusinessException("A senha deve ter 8 ou mais dígitos");
        }

        if (password.isBlank()) {
            throw new BusinessException("A senha não pode ser vazia");
        }
    }
}
