package br.com.ijuris.core.application.port.in;

import java.util.UUID;

public interface ChangeEmailUseCase {
    String execute(UUID userId, String email);
}
