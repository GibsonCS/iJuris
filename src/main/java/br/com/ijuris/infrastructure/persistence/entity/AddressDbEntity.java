package br.com.ijuris.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "address")
public class AddressDbEntity {

    @Id
    private UUID id;
}
