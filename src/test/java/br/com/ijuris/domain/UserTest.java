package br.com.ijuris.domain;

import br.com.ijuris.exception.BusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

class UserTest {

    private UUID VALID_ID = UUID.randomUUID();
    private String VALID_NAME = "Gibson";
    private String VALID_SOBRENOME = "CRUZ";
    private String VALID_CPF = "156.753.577-18";
    private String VALID_EMAIL = "gibson8fla@gmail.com";
    private LocalDate VALID_DATA_NASCIMENTO = LocalDate.of(1996, 9, 22);

    @Test
    void shouldCreateANewUser() {

        User userCreated = User.create(VALID_ID, VALID_NAME, VALID_SOBRENOME, VALID_CPF, VALID_EMAIL,
                VALID_DATA_NASCIMENTO
        );

        Assertions.assertEquals(VALID_ID, userCreated.getId());
    }

    @Test
    void shouldNotCreateUserWithInvalidName() {

        Assertions.assertThrows(BusinessException.class, () -> User.create(VALID_ID, "",
                VALID_SOBRENOME, VALID_CPF, VALID_EMAIL,
                VALID_DATA_NASCIMENTO
        ));
    }

    @Test
    void shouldNotCreateAnUserWithInvalidCpf() {
        Assertions.assertThrows(BusinessException.class, () -> User.create(VALID_ID, VALID_NAME,
                VALID_SOBRENOME, "ASD", VALID_EMAIL,
                VALID_DATA_NASCIMENTO
        ));
    }

    @Test
    void shouldNotCreateAnUserWithInvalidEmail() {
        Assertions.assertThrows(BusinessException.class, () -> User.create(VALID_ID, VALID_NAME,
                VALID_SOBRENOME, VALID_CPF, "gibson23.com",
                VALID_DATA_NASCIMENTO
        ));
    }
}