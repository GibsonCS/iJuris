package br.com.ijuris.core.domain.repository;

import br.com.ijuris.core.domain.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    void save(User user);
    Optional<User> findById(UUID userId);
}
