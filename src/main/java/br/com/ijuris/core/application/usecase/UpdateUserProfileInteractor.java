package br.com.ijuris.core.application.usecase;

import br.com.ijuris.core.application.dto.UpdateUserInput;
import br.com.ijuris.core.application.port.in.UpdateUserProfileUseCase;
import br.com.ijuris.core.domain.entity.User;
import br.com.ijuris.core.domain.repository.UserRepository;
import br.com.ijuris.core.exception.BusinessException;

import java.util.UUID;

public class UpdateUserProfileInteractor implements UpdateUserProfileUseCase {

    private final UserRepository userRepository;

    public UpdateUserProfileInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User execute(UUID userId, UpdateUserInput updateUserInput) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException("usuário não encontrado"));


        user.changeName(updateUserInput.name());
        user.changeLastname(updateUserInput.lastname());
        user.changeDateOfBirthday(updateUserInput.dateOfBirthday());

        userRepository.save(user);

        return user;
    }
}
