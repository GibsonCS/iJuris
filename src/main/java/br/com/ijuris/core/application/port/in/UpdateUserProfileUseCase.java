package br.com.ijuris.core.application.port.in;

import br.com.ijuris.core.application.dto.UpdateUserInput;
import br.com.ijuris.core.domain.entity.User;

import java.util.UUID;

public interface UpdateUserProfileUseCase {
    User execute(UUID userId, UpdateUserInput updateUserInput);
}
