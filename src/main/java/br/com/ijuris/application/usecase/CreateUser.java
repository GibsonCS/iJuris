package br.com.ijuris.domain.application.usecase;

import br.com.ijuris.domain.application.dto.CreateUserInput;
import br.com.ijuris.domain.entity.Address;
import br.com.ijuris.domain.entity.User;
import br.com.ijuris.domain.repository.AddressRepository;
import br.com.ijuris.domain.repository.UserRepository;
import br.com.ijuris.exception.BusinessException;

public class CreateUser {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public CreateUser(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    User execute(CreateUserInput createUserInput) {

        userRepository.findByEmail(createUserInput.email()).ifPresent(user -> {
            throw new BusinessException("Erro ao criar usuário");
        });

        User createdUser = User.create(createUserInput.nome(), createUserInput.sobrenome(), createUserInput.cpf(),
                createUserInput.email(), createUserInput.dataNascimento());

        Address createdAddress = Address.create(
                createdUser.getId(),
                createUserInput.addressInput().cep(),
                createUserInput.addressInput().estado(),
                createUserInput.addressInput().cidade(),
                createUserInput.addressInput().bairro(),
                createUserInput.addressInput().numero(),
                createUserInput.addressInput().complemento(),
                createUserInput.addressInput().lograduouro()
        );

        userRepository.save(createdUser);

        addressRepository.save(createdAddress);

        return createdUser;
    }
}
