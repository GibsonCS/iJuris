package br.com.ijuris.domain.entity;

import br.com.ijuris.exception.BusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class UserTest {

    private String VALID_NAME = "Gibson";
    private String VALID_SOBRENOME = "CRUZ";
    private String VALID_CPF = "156.753.577-18";
    private String VALID_EMAIL = "gibson8fla@gmail.com";
    private LocalDate VALID_DATA_NASCIMENTO = LocalDate.of(1996, 9, 22);


    Role role;

    @BeforeEach
    void setup() {
        role = Role.create("customer");
    }

    @Test
    void shouldCreateANewUser() {

        User userCreated = User.create(VALID_NAME, VALID_SOBRENOME, VALID_CPF, VALID_EMAIL,
                VALID_DATA_NASCIMENTO, role
        );

        Assertions.assertEquals(VALID_CPF, userCreated.getCpf().cpf());
    }

    @Test
    void shouldNotCreateUserWithInvalidName() {

        Assertions.assertThrows(BusinessException.class, () -> User.create("",
                VALID_SOBRENOME, VALID_CPF, VALID_EMAIL,
                VALID_DATA_NASCIMENTO, role
        ));
    }

    @Test
    void shouldNotCreateAnUserWithInvalidCpf() {
        Assertions.assertThrows(BusinessException.class, () -> User.create(VALID_NAME,
                VALID_SOBRENOME, "ASD", VALID_EMAIL,
                VALID_DATA_NASCIMENTO, role
        ));
    }

    @Test
    void shouldNotCreateAnUserWithInvalidEmail() {
        Assertions.assertThrows(BusinessException.class, () -> User.create(VALID_NAME,
                VALID_SOBRENOME, VALID_CPF, "gibson23.com",
                VALID_DATA_NASCIMENTO, role

        ));
    }

    @Test
    void shouldNotCreateUserLessThan18YearsOld() {
        Assertions.assertThrows(BusinessException.class, () -> User.create(VALID_NAME,
                VALID_SOBRENOME, VALID_CPF, VALID_EMAIL,
                LocalDate.of(2023, 1, 22), role
        ));
    }
}