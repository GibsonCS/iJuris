package br.com.ijuris.infrastructure.persistence.repository;

import br.com.ijuris.infrastructure.persistence.entity.RoleDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataRoleRepository extends JpaRepository<RoleDbEntity, UUID> {
     Optional<RoleDbEntity> findByName(String name);
}
