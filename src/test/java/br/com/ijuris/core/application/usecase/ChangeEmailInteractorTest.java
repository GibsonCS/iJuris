package br.com.ijuris.core.application.usecase;

import br.com.ijuris.core.domain.entity.User;
import br.com.ijuris.core.domain.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ChangeEmailInteractorTest {

    private final UUID VALID_ID = UUID.randomUUID();
    private final String VALID_EMAIL = "gibson@gibso.com";

    @Mock
    UserRepository userRepository;

    @InjectMocks
    ChangeEmailInteractor changeEmailInteractor;


    @Test
    void shouldChangeUserEmail() {
        User user = User.create("Jorge", "niga", "123.123.343-18", "gibskd@gmail.com",
                LocalDate.of(2000, 1, 20), "dsfjdsHFdf@fd");

        when(userRepository.findById(VALID_ID)).thenReturn(Optional.of(user));

        String newEmail = changeEmailInteractor.execute(VALID_ID, VALID_EMAIL);

        Assertions.assertEquals(VALID_EMAIL, newEmail);

        verify(userRepository, times(1)).findById(any());
        verify(userRepository,times(1)).save(any());
    }
}