package br.com.ijuris.domain.repository;

import br.com.ijuris.domain.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    void save(User user);
}
