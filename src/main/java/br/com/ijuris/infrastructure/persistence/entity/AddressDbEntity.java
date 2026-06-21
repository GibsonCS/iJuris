package br.com.ijuris.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "address")
@Data
public class AddressDbEntity {

    @Id
    private UUID id;

    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String number;
    private String complement;
    private String street;

    public AddressDbEntity(){}

    public AddressDbEntity(String cep, String state, String city, String neighborhood, String number, String complement, String street) {
        this.cep = cep;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.number = number;
        this.complement = complement;
        this.street = street;

    }

    @ManyToOne
    private UserDbEntity userDbEntity;
}
