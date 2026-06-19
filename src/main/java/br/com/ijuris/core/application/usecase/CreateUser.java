package br.com.ijuris.core.application.usecase;

import br.com.ijuris.core.application.dto.CreateUserInput;
import br.com.ijuris.core.domain.entity.User;
import br.com.ijuris.core.domain.repository.AddressRepository;
import br.com.ijuris.core.domain.entity.Address;
import br.com.ijuris.core.domain.entity.Role;
import br.com.ijuris.core.domain.repository.RoleRepository;
import br.com.ijuris.core.domain.repository.UserRepository;
import br.com.ijuris.exception.BusinessException;

import java.util.Optional;
import java.util.UUID;

public class CreateUser {

    private static final UUID DEFAULT_CUSTOMER_ROLE_ID = UUID.fromString("125ad5a3-d23e-4878-992b-c8e3bc112b20");

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final RoleRepository roleRepository;

    public CreateUser(
            UserRepository userRepository,
            AddressRepository addressRepository,
            RoleRepository roleRepository
    ) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.roleRepository = roleRepository;
    }

    public User execute(CreateUserInput createUserInput) {

        userRepository.findByEmail(createUserInput.email()).ifPresent(user -> {
            throw new BusinessException("O e-mail informado já está cadastrado.");
        });

        Optional<Role> customerRole = roleRepository.findById(DEFAULT_CUSTOMER_ROLE_ID);

        if (customerRole.isEmpty()) {
            throw new BusinessException("A Role de cliente padrão não foi encontrada.");
        }

        User createdUser = User.create(
                createUserInput.nome(),
                createUserInput.sobrenome(),
                createUserInput.cpf(),
                createUserInput.email(),
                createUserInput.dataNascimento(),
                customerRole.get()
        );

        Address createdAddress = Address.create(
                createdUser.getId(),
                createUserInput.addressInput().cep(),
                createUserInput.addressInput().estado(),
                createUserInput.addressInput().cidade(),
                createUserInput.addressInput().bairro(),
                createUserInput.addressInput().numero(),
                createUserInput.addressInput().complemento(),
                createUserInput.addressInput().logradouro()
        );

        userRepository.save(createdUser);
        addressRepository.save(createdAddress);

        return createdUser;
    }
}