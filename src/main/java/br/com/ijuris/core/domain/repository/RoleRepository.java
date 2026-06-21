package br.com.ijuris.core.domain.repository;

import br.com.ijuris.core.domain.entity.Role;
import br.com.ijuris.infrastructure.persistence.entity.RoleDbEntity;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository {
    Optional<Role> findById(UUID id);
    Optional<Role> findByName(String name);
}
