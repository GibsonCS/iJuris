package br.com.ijuris.infrastructure.config;

import br.com.ijuris.core.application.port.PasswordEncoder;
import br.com.ijuris.core.application.port.in.UpdateUserProfileUseCase;
import br.com.ijuris.core.application.usecase.CreateUser;
import br.com.ijuris.core.application.usecase.UpdateUserProfileInteractor;
import br.com.ijuris.core.domain.repository.AddressRepository;
import br.com.ijuris.core.domain.repository.RoleRepository;
import br.com.ijuris.core.domain.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UseCaseConfig(UserRepository userRepository, AddressRepository addressRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CreateUser createUser() {
        return new CreateUser(userRepository,addressRepository,roleRepository, passwordEncoder);
    }

    @Bean
    public UpdateUserProfileUseCase updateUserProfileUseCase() {
        return new UpdateUserProfileInteractor(userRepository);
    }
}
