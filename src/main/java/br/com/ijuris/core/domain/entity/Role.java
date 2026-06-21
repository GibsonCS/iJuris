package br.com.ijuris.core.domain.entity;

import br.com.ijuris.core.exception.BusinessException;

public class Role {


    private final String name;

    private Role(String name) {

        if (name == null || name.isEmpty()) {
            throw new BusinessException("Role invalida");
        }


        this.name = name;
    }

    public static Role create(String name) {
        return new Role(name);
    }

    public String getName() {
        return name;
    }
}
