package br.com.ijuris.core.domain.vo;

import br.com.ijuris.exception.BusinessException;

public record Cep(String cep) {
    public Cep {

        String regex = "\\d{5}-\\d{3}";

        if (!cep.matches(regex)) {
            throw new BusinessException("Insira um cep válido");
        }
    }

    @Override
    public String cep() {
        return cep;
    }
}
