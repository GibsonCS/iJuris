package br.com.ijuris.core.domain.entity;

import br.com.ijuris.core.domain.vo.Cep;

import java.util.UUID;

public class Address {

    private final UUID id;
    private final UUID userId;

    private Cep cep;
    private String state;
    private String city;
    private String neighborhood;
    private String number;
    private String complement;
    private String street;

    private Address(UUID id, UUID userId, Cep cep, String state, String city, String neighborhood, String number,
                    String complement, String street
    ) {
        this.id = id;
        this.userId = userId;
        this.cep = cep;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.number = number;
        this.complement = complement;
        this.street = street;
    }

    public static Address create(UUID userId, String cep, String state, String city, String neighborhood, String number,
                                 String complement, String street
    ) {

        return new Address(UUID.randomUUID(), userId, new Cep(cep), state, city, neighborhood, number, complement, street);
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public Cep getCep() {
        return cep;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getStreet() {
        return street;
    }
}
