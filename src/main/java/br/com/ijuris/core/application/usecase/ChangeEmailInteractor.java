package br.com.ijuris.core.application.usecase;

import br.com.ijuris.core.application.port.in.ChangeEmailUseCase;
import br.com.ijuris.core.domain.entity.User;
import br.com.ijuris.core.domain.repository.UserRepository;
import br.com.ijuris.core.exception.BusinessException;

import java.util.UUID;

public class ChangeEmailInteractor implements ChangeEmailUseCase {

    private final UserRepository userRepository;

    public ChangeEmailInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String execute(UUID userId, String email) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException("Usuário não encontrado"));

        user.changeEmail(email);

        userRepository.save(user);

        return user.getEmail().email();
    }
}
