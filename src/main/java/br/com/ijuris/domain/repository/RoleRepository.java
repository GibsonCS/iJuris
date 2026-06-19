package br.com.ijuris.domain.repository;

import br.com.ijuris.domain.entity.Role;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository {
    Optional<Role> findById(UUID id);
}
