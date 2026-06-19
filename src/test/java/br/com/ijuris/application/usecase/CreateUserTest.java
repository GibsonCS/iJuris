package br.com.ijuris.application.usecase;

import br.com.ijuris.core.application.dto.AddressInput;
import br.com.ijuris.core.application.dto.CreateUserInput;
import br.com.ijuris.core.application.usecase.CreateUser;
import br.com.ijuris.core.domain.entity.Address;
import br.com.ijuris.core.domain.entity.Role;
import br.com.ijuris.core.domain.entity.User;
import br.com.ijuris.core.domain.repository.AddressRepository;
import br.com.ijuris.core.domain.repository.RoleRepository;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateUserTest {

    private final String VALID_NAME = "Gibson";
    private final String VALID_LAST_NAME = "CRUZ";
    private final String VALID_CPF = "156.753.577-18";
    private final String VALID_EMAIL = "gibson8fla@gmail.com";
    private final LocalDate VALID_BIRTH_DATE = LocalDate.of(1996, 9, 22);

    private final String VALID_ZIP_CODE = "21532-290";
    private final String VALID_STATE = "Rio de Janeiro";
    private final String VALID_CITY = "Rio de Janeiro";
    private final String VALID_NEIGHBORHOOD = "Pavuna";
    private final String VALID_NUMBER = "811";
    private final String VALID_COMPLEMENT = "Casa 36";
    private final String VALID_STREET = "AV. Sargento de Milicias";

    private final UUID DEFAULT_ROLE_ID = UUID.fromString("125ad5a3-d23e-4878-992b-c8e3bc112b20");

    @Mock
    UserRepository userRepository;

    @Mock
    RoleRepository roleRepository;

    @Mock
    AddressRepository addressRepository;

    @InjectMocks
    CreateUser createUser;

    CreateUserInput createUserInput;
    AddressInput addressInput;

    @Mock
    Role role;

    @BeforeEach
    void setup() {
        addressInput = new AddressInput(VALID_ZIP_CODE, VALID_STATE, VALID_CITY, VALID_NEIGHBORHOOD, VALID_NUMBER,
                VALID_COMPLEMENT, VALID_STREET);

        createUserInput = new CreateUserInput(VALID_NAME, VALID_LAST_NAME, VALID_CPF, VALID_EMAIL, VALID_BIRTH_DATE,
                addressInput);
    }

    @Test
    void shouldCreateANewUser() {

        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(roleRepository.findById(DEFAULT_ROLE_ID)).thenReturn(Optional.of(role));

        User createdUser = createUser.execute(createUserInput);

        Assertions.assertNotNull(createdUser.getId(), "O ID do usuário deve ser gerado");
        Assertions.assertEquals(VALID_CPF, createdUser.getCpf().cpf());
        Assertions.assertEquals(VALID_EMAIL, createdUser.getEmail().email());

        verify(userRepository, times(1)).save(any(User.class));
        verify(addressRepository, times(1)).save(any(Address.class));
        verify(roleRepository, times(1)).findById(DEFAULT_ROLE_ID);
    }
}