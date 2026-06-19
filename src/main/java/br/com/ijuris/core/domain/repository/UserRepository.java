package br.com.ijuris.core.domain.repository;

import br.com.ijuris.core.domain.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    void save(User user);
}
