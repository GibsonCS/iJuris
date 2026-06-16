package br.com.ijuris.domain.vo;

import br.com.ijuris.exception.BusinessException;

public class Cpf {

    private String cpf;

    private Cpf (String cpf) {
        this.cpf = cpf;
    }

    public static Cpf create(String cpf) {
        String regex = "\\d{3}.\\d{3}.\\d{3}-\\d{2}";

        if(!cpf.matches(regex)) {
            throw new BusinessException("Insira um cpf válido.");
        }

        return new Cpf(cpf);
    }

    public String getCpf() {
        return cpf;
    }
}
