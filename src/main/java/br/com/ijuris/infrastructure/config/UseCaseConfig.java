package br.com.ijuris.infrastructure.config;

import br.com.ijuris.core.application.usecase.CreateUser;
import br.com.ijuris.core.domain.repository.AddressRepository;
import br.com.ijuris.core.domain.repository.RoleRepository;
import br.com.ijuris.core.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final RoleRepository roleRepository;

    public UseCaseConfig(UserRepository userRepository, AddressRepository addressRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.roleRepository = roleRepository;
    }

    @Bean
    @Transactional
    public CreateUser createUser() {

        return new CreateUser(userRepository,addressRepository,roleRepository);
    }
}
