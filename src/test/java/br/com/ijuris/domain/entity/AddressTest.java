package br.com.ijuris.domain.entity;

import br.com.ijuris.domain.vo.Cep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class AddressTest {

    private String CEP_VALIDO = "21532-290";
    private String ESTADO_VALIDO = "Rio de Janeiro";
    private String CIDADE_VALIDA = "Rio de Janeiro";
    private String BAIRRO_VALIDO = "Pavuna";
    private String NUMERO_VALIDO = "811";
    private String COMPLEMENTO_VALIDO = "Casa 36";
    private String LOGRADOURO_VALIDO = "AV. Sargento de Milicias";
    private UUID ID_USUARIO_VALIDO = UUID.randomUUID();

    @Test
    void shouldCreateAnAddress() {

        Address endereco = Address.create(ID_USUARIO_VALIDO, CEP_VALIDO, ESTADO_VALIDO, CIDADE_VALIDA, BAIRRO_VALIDO,
                NUMERO_VALIDO, COMPLEMENTO_VALIDO, LOGRADOURO_VALIDO
        );

        Assertions.assertEquals(CEP_VALIDO, endereco.getCep().cep());
        Assertions.assertTrue(BAIRRO_VALIDO.equalsIgnoreCase(endereco.getBairro()));
    }
}