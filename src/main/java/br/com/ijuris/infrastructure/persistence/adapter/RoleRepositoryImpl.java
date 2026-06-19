package br.com.ijuris.infrastructure.persistence.adapter;

import br.com.ijuris.domain.entity.Role;
import br.com.ijuris.domain.repository.RoleRepository;
import br.com.ijuris.infrastructure.persistence.repository.SpringDataRoleRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    private final SpringDataRoleRepository springDataRoleRepository;

    public RoleRepositoryImpl (SpringDataRoleRepository springDataRoleRepository) {
        this.springDataRoleRepository = springDataRoleRepository;
    }
    @Override
    public Optional<Role> findById(UUID id) {
        return Optional.empty();
    }
}
