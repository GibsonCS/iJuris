package br.com.ijuris.infrastructure.persistence.adapter;

import br.com.ijuris.core.domain.entity.Role;
import br.com.ijuris.core.domain.repository.RoleRepository;
import br.com.ijuris.core.exception.BusinessException;
import br.com.ijuris.infrastructure.persistence.entity.RoleDbEntity;
import br.com.ijuris.infrastructure.persistence.repository.SpringDataRoleRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    private final SpringDataRoleRepository springDataRoleRepository;

    public RoleRepositoryImpl(SpringDataRoleRepository springDataRoleRepository) {
        this.springDataRoleRepository = springDataRoleRepository;
    }

    @Override
    public Optional<Role> findById(UUID id) {

        Optional<RoleDbEntity> roleDbEntity = springDataRoleRepository.findById(id);

        if (roleDbEntity.isPresent()) {
            return Optional.of(Role.create(roleDbEntity.get().getName()));
        }

        throw new BusinessException("Role não encotrada");
    }
}
