package br.com.ijuris.core.application.usecase;

import br.com.ijuris.core.application.dto.UpdateUserInput;
import br.com.ijuris.core.domain.entity.User;
import br.com.ijuris.core.domain.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
class UpdateUserProfileInteractorTest {


    private final UUID VALID_USERID = UUID.randomUUID();
    private final String VALID_NAME = "Gibson";
    private final String VALID_LASTNAME = "Silva";
    private final String VALID_CPF = "123.243.123-18";
    private final String VALID_EMAIL = "Gibson@gibs.com";
    private final LocalDate VALID_LOCALDATE = LocalDate.of(1996, 9, 22);
    private final String VALID_PASSWORD = "ADFgdsdf1234$4";

    UpdateUserInput updateUserInput;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UpdateUserProfileInteractor updateUserProfileInteractor;

    User user;

    @BeforeEach
    void setup() {

        user = User.create(VALID_NAME, VALID_LASTNAME, VALID_CPF, VALID_EMAIL, VALID_LOCALDATE, VALID_PASSWORD);
    }

    @Test
    void shouldUpdateUserProfile() {

        when(userRepository.findById(VALID_USERID)).thenReturn(Optional.of(user));

        updateUserInput = new UpdateUserInput( "Pedro", "Silas",
                LocalDate.of(1995, 8, 6)
        );

        User response = updateUserProfileInteractor.execute(VALID_USERID,updateUserInput);

        Assertions.assertEquals(updateUserInput.name(), response.getName());
        Assertions.assertEquals(updateUserInput.lastname(), response.getLastname());
        Assertions.assertEquals(updateUserInput.dateOfBirthday(), response.getDateOfBirthDay());

        verify(userRepository, times(1)).findById(VALID_USERID);
        verify(userRepository, times(1)).save(user);
    }
}