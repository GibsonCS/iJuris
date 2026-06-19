package br.com.ijuris.core.domain.vo;

import br.com.ijuris.exception.BusinessException;

public record Cpf(String cpf) {
    public Cpf {

        String regex = "\\d{3}.\\d{3}.\\d{3}-\\d{2}";

        if (cpf == null || !cpf.matches(regex)) {
            throw new BusinessException("Insira um cpf válido.");
        }
    }
}
