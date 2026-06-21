package br.com.ijuris.infrastructure.persistence.repository;

import br.com.ijuris.infrastructure.persistence.entity.RoleDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataRoleRepository extends JpaRepository<RoleDbEntity, UUID> {
    public RoleDbEntity findByName(String name);
}
