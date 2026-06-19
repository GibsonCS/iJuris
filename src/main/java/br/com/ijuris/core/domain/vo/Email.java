package br.com.ijuris.core.domain.vo;

import br.com.ijuris.exception.BusinessException;

public record Email(String email) {
    public Email {

        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

        if (email == null || !email.matches(regex)) {
            throw new BusinessException("E-mail em formato inválido.");
        }
    }
}
