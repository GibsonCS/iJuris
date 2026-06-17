package br.com.ijuris.domain;

import br.com.ijuris.domain.vo.Cep;

import java.util.UUID;

public class Address {

    private final UUID id;
    private final UUID IdUsuario;

    private Cep cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String numero;
    private String complemento;
    private String lograduouro;

    public Address(UUID id, UUID idUsuario, Cep cep, String estado, String cidade, String bairro, String numero,
                   String complemento, String lograduouro
    ) {
        this.id = id;
        this.IdUsuario = idUsuario;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.lograduouro = lograduouro;
    }

    public static Address create(UUID idUsuario, Cep cep, String estado, String cidade, String bairro,
                                 String numero, String complemento, String lograduouro
    ) {

        return new Address(UUID.randomUUID(), idUsuario, cep, estado, cidade, bairro, numero, complemento,
                lograduouro
        );
    }

    public UUID getId() {
        return id;
    }

    public UUID getIdUsuario() {
        return IdUsuario;
    }

    public Cep getCep() {
        return cep;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getLograduouro() {
        return lograduouro;
    }
}
