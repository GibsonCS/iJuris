package br.com.ijuris.core.application.usecase;

import br.com.ijuris.core.application.dto.CreateUserInput;
import br.com.ijuris.core.application.port.PasswordEncoder;
import br.com.ijuris.core.domain.entity.Address;
import br.com.ijuris.core.domain.entity.User;
import br.com.ijuris.core.domain.repository.AddressRepository;
import br.com.ijuris.core.domain.repository.RoleRepository;
import br.com.ijuris.core.domain.repository.UserRepository;
import br.com.ijuris.core.exception.BusinessException;
import jakarta.transaction.Transactional;

public class CreateUser {

    private static final String DEFAULT_CUSTOMER_ROLE_ID = "customer";

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final PasswordEncoder passwordEncoder;


    public CreateUser(
            UserRepository userRepository,
            AddressRepository addressRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User execute(CreateUserInput createUserInput) {

        userRepository.findByEmail(createUserInput.userInput().email()).ifPresent(user -> {
            throw new BusinessException("O e-mail informado já está cadastrado.");
        });

        User createdUser = User.create(
                createUserInput.userInput().name(),
                createUserInput.userInput().lastname(),
                createUserInput.userInput().cpf(),
                createUserInput.userInput().email(),
                createUserInput.userInput().dateOfBirthday(),
                passwordEncoder.encode(createUserInput.userInput().password())
        );

        userRepository.save(createdUser);

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

        addressRepository.save(createdAddress);

        return createdUser;
    }
}