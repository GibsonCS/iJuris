package br.com.ijuris.infrastructure.persistence.adapter;

import br.com.ijuris.core.domain.entity.Role;
import br.com.ijuris.core.domain.entity.User;
import br.com.ijuris.core.domain.repository.UserRepository;
import br.com.ijuris.core.exception.BusinessException;
import br.com.ijuris.infrastructure.persistence.entity.RoleDbEntity;
import br.com.ijuris.infrastructure.persistence.entity.UserDbEntity;
import br.com.ijuris.infrastructure.persistence.repository.SpringDataRoleRepository;
import br.com.ijuris.infrastructure.persistence.repository.SpringDataUserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
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


        Optional<UserDbEntity> userDbEntity = springDataUserRepository.findByEmail(email);

        if (userDbEntity.isEmpty()) {
            return Optional.empty();
        }

        User user = User.create(userDbEntity.get().getName(), userDbEntity.get().getLastName(), userDbEntity.get().getCpf(),
                userDbEntity.get().getEmail(), userDbEntity.get().getDateOfBirthDay(),
                userDbEntity.get().getPassword()
        );

        userDbEntity.get().getRoles().forEach(r -> {
            user.addRole(Role.create(r.getName()));
        });

        return Optional.of(user);
    }

    @Override
    public void save(User user) {

        Set<Role> roles = user.getRoles();

        Set<RoleDbEntity> roleDbEntities = roles.stream().map(role -> springDataRoleRepository.findByName(role.getName())
                .orElseThrow(() -> new BusinessException("Erro adiconar roles"))).collect(Collectors.toSet()
        );

        UserDbEntity userDbEntity = new UserDbEntity(
                user.getId(),
                user.getName(),
                user.getLastname(),
                user.getCpf().cpf(),
                user.getEmail().email(),
                user.getDateOfBirthDay(),
                user.getPassword().password(),
                roleDbEntities
        );

        springDataUserRepository.save(userDbEntity);
    }

    @Override
    public Optional<User> findById(UUID userId) {

        Optional<UserDbEntity> userDbEntity = springDataUserRepository.findById(userId);

        if(userDbEntity.isEmpty()){
            return Optional.empty();
        }

        User createdUser = User.restore(userDbEntity.get().getId(), userDbEntity.get().getName(),
                userDbEntity.get().getLastName(),userDbEntity.get().getCpf(),
                userDbEntity.get().getEmail(),userDbEntity.get().getDateOfBirthDay(),userDbEntity.get().getPassword());

        userDbEntity.get().getRoles().forEach(r -> createdUser.addRole(Role.create(r.getName())));

        return Optional.of(createdUser);
    }
}
