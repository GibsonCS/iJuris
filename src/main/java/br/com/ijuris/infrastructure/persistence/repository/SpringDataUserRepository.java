package br.com.ijuris.infrastructure.persistence.repository;

import br.com.ijuris.infrastructure.persistence.entity.UserDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataUserRepository extends JpaRepository<UserDbEntity, UUID> {
    Optional<UserDbEntity> findByEmail(String email);
}
