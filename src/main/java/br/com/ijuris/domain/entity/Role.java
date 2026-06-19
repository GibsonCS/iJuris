package br.com.ijuris.domain.entity;

import br.com.ijuris.exception.BusinessException;

import java.util.UUID;

public class Role {

    private final UUID id;
    private final String name;

    private Role(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Role create(String name) {
        if (name == null || name.isEmpty()) {
            throw new BusinessException("Role invalida");
        }

        return new Role(UUID.randomUUID(), name);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
