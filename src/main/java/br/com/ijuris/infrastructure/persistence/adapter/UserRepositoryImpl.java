package br.com.ijuris.infrastructure.persistence.adapter;

import br.com.ijuris.core.domain.entity.Role;
import br.com.ijuris.core.domain.entity.User;
import br.com.ijuris.core.domain.repository.UserRepository;
import br.com.ijuris.infrastructure.persistence.entity.RoleDbEntity;
import br.com.ijuris.infrastructure.persistence.entity.UserDbEntity;
import br.com.ijuris.infrastructure.persistence.repository.SpringDataRoleRepository;
import br.com.ijuris.infrastructure.persistence.repository.SpringDataUserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private SpringDataUserRepository springDataUserRepository;
    private SpringDataRoleRepository springDataRoleRepository;

    public UserRepositoryImpl(SpringDataUserRepository springDataUserRepository, SpringDataRoleRepository springDataRoleRepository) {
        this.springDataUserRepository = springDataUserRepository;
        this.springDataRoleRepository = springDataRoleRepository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public void save(User user) {

        Set<Role> roles = user.getRoles();

        Set<RoleDbEntity> roleDbEntities = roles.stream().map(r -> springDataRoleRepository.findByName(r.getName())).collect(Collectors.toSet());

        UserDbEntity userDbEntity = new UserDbEntity(user.getName(),
                user.getLastname(),
                user.getCpf().cpf(),
                user.getEmail().email(),
                user.getDateOfBirthDay(),
                roleDbEntities
        );

        userDbEntity.setId(user.getId());

        springDataUserRepository.save(userDbEntity);
    }
}
